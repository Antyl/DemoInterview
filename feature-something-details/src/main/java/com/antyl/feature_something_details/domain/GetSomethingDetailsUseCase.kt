package com.antyl.feature_something_details.domain

import com.antyl.core.utils.UiState
import com.antyl.feature_something_details.data.SomethingDetailsViewData
import kotlinx.coroutines.flow.Flow

interface GetSomethingDetailsUseCase {
    operator fun invoke(id: Long): Flow<UiState<SomethingDetailsViewData>>
}