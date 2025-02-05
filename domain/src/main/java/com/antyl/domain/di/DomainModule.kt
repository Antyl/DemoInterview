package com.antyl.domain.di

import com.antyl.domain.repository.SomethingRepository
import com.antyl.domain.usecase.GetSomethingDetailsUC
import com.antyl.domain.usecase.GetSomethingDomainUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DomainModule {

    @Provides
    fun provideGetSomethingUseCase(somethingRepository: SomethingRepository): GetSomethingDomainUC {
        return GetSomethingDomainUC(somethingRepository)
    }

    @Provides
    fun provideGetSomethingDetailsUC(somethingRepository: SomethingRepository): GetSomethingDetailsUC {
        return GetSomethingDetailsUC(somethingRepository)
    }
}