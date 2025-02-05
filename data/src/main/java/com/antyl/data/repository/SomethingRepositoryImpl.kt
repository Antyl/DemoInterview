package com.antyl.data.repository

import com.antyl.domain.model.Something
import com.antyl.core.utils.NetworkResult
import com.antyl.data.remote.source.RemoteDataSource
import com.antyl.data.repository.mapper.SomethingMapper
import com.antyl.domain.repository.SomethingRepository
import javax.inject.Inject

internal class SomethingRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val mapper: SomethingMapper
): SomethingRepository {

    override suspend fun getSomething(): Result<List<Something>> {
        return when(val response = remoteDataSource.getSomething()) {
            is NetworkResult.Success -> {
                val data = mapper.map(response.data.orEmpty())
                Result.success(data)
            }
            is NetworkResult.Error -> {
                Result.failure(Throwable(message = response.message))
            }
        }
    }
}