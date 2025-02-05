package com.antyl.feature_something_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antyl.core.utils.UiState
import com.antyl.feature_something_list.data.SomethingViewData
import com.antyl.feature_something_list.domain.GetSomethingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SomethingListViewModel @Inject constructor(
    private val getSomethingUseCase: GetSomethingUseCase
): ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<SomethingViewData>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<SomethingViewData>>> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getSomethingUseCase()
                .collect {
                    _uiState.emit(it)
                }
        }
    }
}