package com.antyl.feature_something_list.domain

import com.antyl.core.utils.UiState
import com.antyl.domain.usecase.GetSomethingDomainUseCase
import com.antyl.feature_something_list.data.SomethingViewData
import com.antyl.feature_something_list.data.ViewDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class GetSomethingUseCase @Inject constructor(
    private val getSomethingDomainUseCase: GetSomethingDomainUseCase,
    private val mapper: ViewDataMapper
) {

    operator fun invoke(): Flow<UiState<List<SomethingViewData>>> {
        return flow {
            emit(UiState.Loading)
            val result = getSomethingDomainUseCase()
            result
                .onSuccess {
                    emit(UiState.Success(mapper.mapList(it)))
                }
                .onFailure {
                    emit(UiState.Error(message = it.message.toString()))
                }
        }
    }
}

