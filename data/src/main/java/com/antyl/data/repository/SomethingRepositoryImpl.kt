package com.antyl.data.repository

import com.antyl.domain.model.Something
import com.antyl.core.utils.NetworkResult
import com.antyl.data.local.cache.LocalCacheDataSource
import com.antyl.data.remote.source.RemoteDataSource
import com.antyl.data.repository.mapper.SomethingMapper
import com.antyl.domain.repository.SomethingRepository
import javax.inject.Inject

internal class SomethingRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val cacheDataSource: LocalCacheDataSource,
    private val mapper: SomethingMapper,
): SomethingRepository {

    override suspend fun getSomethingList(): Result<List<Something>> {
        return when(val response = remoteDataSource.getSomething()) {
            is NetworkResult.Success -> {
                val responseData = response.data.orEmpty()
                cacheDataSource.saveSomethingList(responseData)
                val data = mapper.map(responseData)
                Result.success(data)
            }
            is NetworkResult.Error -> {
                val cache = cacheDataSource.getSomethingList().ifEmpty {
                    return Result.failure(Throwable(message = response.message))
                }
                Result.success(mapper.map(cache))
            }
        }
    }

    override suspend fun getSomething(id: Long): Result<Something> {
        cacheDataSource.getSomething(id = id)?.let {
            return Result.success(mapper.map(it))
        }
        return Result.failure(Throwable(message = "Something object not found"))
    }
}