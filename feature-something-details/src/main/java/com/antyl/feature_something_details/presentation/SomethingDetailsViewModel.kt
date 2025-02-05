package com.antyl.feature_something_details.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antyl.core.utils.UiState
import com.antyl.feature_something_details.data.SomethingDetailsViewData
import com.antyl.feature_something_details.domain.GetSomethingDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SomethingDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getSomethingDetailsUseCase: GetSomethingDetailsUseCase
): ViewModel() {

    private val somethingId = savedStateHandle.get<Long>("id")

    private val _uiState: MutableStateFlow<UiState<SomethingDetailsViewData>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<SomethingDetailsViewData>> = _uiState.asStateFlow()

    init {
        Log.e("TAG 1", savedStateHandle.toString())
        Log.e("TAG 2", savedStateHandle.keys().toString())
        Log.e("TAG 2", savedStateHandle.get<Long>("id").toString())
        viewModelScope.launch {
            if (somethingId != null) {
                getSomethingDetailsUseCase(id = somethingId)
                    .collect { _uiState.emit(it) }
            } else {
                _uiState.emit(UiState.Error(message = "Parameter 'savedStateHandle:id' not found"))
            }
        }
    }
}