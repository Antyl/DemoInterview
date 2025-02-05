package com.antyl.feature_something_details.di

import com.antyl.domain.usecase.GetSomethingDetailsUC
import com.antyl.domain.usecase.GetSomethingDomainUC
import com.antyl.feature_something_details.data.ViewDataMapper
import com.antyl.feature_something_details.domain.GetSomethingDetailsUseCase
import com.antyl.feature_something_details.domain.GetSomethingDetailsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object SomethingDetailsModule {

    @Provides
    fun provideViewDataMapper(): ViewDataMapper = ViewDataMapper()

    @Provides
    fun provideGetSomethingDetailsUseCase(
        getSomethingDetailsUC: GetSomethingDetailsUC,
        viewDataMapper: ViewDataMapper
    ): GetSomethingDetailsUseCase {
        return GetSomethingDetailsUseCaseImpl(getSomethingDetailsUC, viewDataMapper)
    }
}