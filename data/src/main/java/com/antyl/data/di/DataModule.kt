package com.antyl.data.di

import com.antyl.data.local.cache.LocalCacheDataSource
import com.antyl.data.local.cache.LocalCacheDataSourceImpl
import com.antyl.data.remote.source.RemoteDataSource
import com.antyl.data.remote.source.RemoteDataSourceImpl
import com.antyl.domain.repository.SomethingRepository
import com.antyl.data.repository.SomethingRepositoryImpl
import com.antyl.data.repository.mapper.SomethingMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(): RemoteDataSource = RemoteDataSourceImpl()

    @Provides
    @Singleton
    fun provideLocalCacheDataSource(): LocalCacheDataSource = LocalCacheDataSourceImpl()

    @Provides
    @Singleton
    fun provideSomethingMapper(): SomethingMapper = SomethingMapper

    @Provides
    @Singleton
    fun provideSomethingRepository(
        remoteDataSource: RemoteDataSource,
        localCacheDataSource: LocalCacheDataSource,
        mapper: SomethingMapper
    ): SomethingRepository {
        return SomethingRepositoryImpl(remoteDataSource, localCacheDataSource, mapper)
    }
}