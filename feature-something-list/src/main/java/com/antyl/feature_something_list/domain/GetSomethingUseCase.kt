package com.antyl.feature_something_list.domain

import com.antyl.core.utils.UiState
import com.antyl.feature_something_list.data.SomethingViewData
import kotlinx.coroutines.flow.Flow

interface GetSomethingUseCase {
    operator fun invoke(): Flow<UiState<List<SomethingViewData>>>
}