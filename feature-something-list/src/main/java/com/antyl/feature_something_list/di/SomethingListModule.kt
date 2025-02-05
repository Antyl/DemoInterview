package com.antyl.feature_something_list.di

import com.antyl.domain.usecase.GetSomethingDomainUseCase
import com.antyl.feature_something_list.data.ViewDataMapper
import com.antyl.feature_something_list.domain.GetSomethingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object SomethingListModule {

    @Provides
    fun provideViewDataMapper(): ViewDataMapper = ViewDataMapper()

    @Provides
    fun provideGetSomethingUseCase(
        getSomethingDomainUseCase: GetSomethingDomainUseCase,
        viewDataMapper: ViewDataMapper
    ): GetSomethingUseCase {
        return GetSomethingUseCase(getSomethingDomainUseCase, viewDataMapper)
    }
}