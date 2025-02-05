package com.antyl.domain.di

import com.antyl.domain.repository.SomethingRepository
import com.antyl.domain.usecase.GetSomethingDomainUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DomainModule {

    @Provides
    fun provideGetSomethingUseCase(somethingRepository: SomethingRepository): GetSomethingDomainUseCase {
        return GetSomethingDomainUseCase(somethingRepository)
    }
}