package com.antyl.data.di

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
    fun provideServerApi(): RemoteDataSource = RemoteDataSourceImpl()

    @Provides
    @Singleton
    fun provideSomethingMapper(): SomethingMapper = SomethingMapper

    @Provides
    @Singleton
    fun provideSomethingRepository(remoteDataSource: RemoteDataSource, mapper: SomethingMapper): SomethingRepository {
        return SomethingRepositoryImpl(remoteDataSource, mapper)
    }
}