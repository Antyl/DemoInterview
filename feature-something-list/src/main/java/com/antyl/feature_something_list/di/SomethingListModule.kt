package com.antyl.feature_something_list.di

import com.antyl.domain.usecase.GetSomethingDomainUC
import com.antyl.feature_something_list.data.ViewDataMapper
import com.antyl.feature_something_list.domain.GetSomethingUseCase
import com.antyl.feature_something_list.domain.GetSomethingUseCaseImpl
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
        getSomethingDomainUC: GetSomethingDomainUC,
        viewDataMapper: ViewDataMapper
    ): GetSomethingUseCase {
        return GetSomethingUseCaseImpl(getSomethingDomainUC, viewDataMapper)
    }
}