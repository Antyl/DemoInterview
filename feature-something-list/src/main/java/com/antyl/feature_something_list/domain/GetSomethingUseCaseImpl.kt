package com.antyl.feature_something_list.domain

import com.antyl.core.utils.UiState
import com.antyl.domain.usecase.GetSomethingDomainUC
import com.antyl.feature_something_list.data.SomethingViewData
import com.antyl.feature_something_list.data.ViewDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class GetSomethingUseCaseImpl @Inject constructor(
    private val getSomethingDomainUC: GetSomethingDomainUC,
    private val mapper: ViewDataMapper
): GetSomethingUseCase {

    override operator fun invoke(): Flow<UiState<List<SomethingViewData>>> {
        return flow {
            emit(UiState.Loading)
            val result = getSomethingDomainUC()
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

