package com.antyl.feature_something_details.domain

import com.antyl.core.utils.UiState
import com.antyl.domain.usecase.GetSomethingDetailsUC
import com.antyl.domain.usecase.GetSomethingDomainUC
import com.antyl.feature_something_details.data.SomethingDetailsViewData
import com.antyl.feature_something_details.data.ViewDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class GetSomethingDetailsUseCaseImpl @Inject constructor(
    private val getSomethingDetailsUC: GetSomethingDetailsUC,
    private val mapper: ViewDataMapper
): GetSomethingDetailsUseCase {

    override operator fun invoke(id: Long): Flow<UiState<SomethingDetailsViewData>> {
        return flow {
            emit(UiState.Loading)
            getSomethingDetailsUC(id = id)
                .onSuccess {
                    emit(UiState.Success(mapper.map(it)))
                }
                .onFailure {
                    emit(UiState.Error(message = it.message.toString()))
                }
        }
    }
}

