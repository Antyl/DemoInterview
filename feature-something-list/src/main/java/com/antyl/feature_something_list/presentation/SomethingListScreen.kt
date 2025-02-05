package com.antyl.feature_something_list.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.antyl.core.utils.UiState
import com.antyl.feature_something_list.data.SomethingViewData
import com.antyl.ui.component.SomethingItem

@Composable
fun SomethingListScreen(
    onDetailsClick: (Long) -> Unit
) {
    val viewModel: SomethingListViewModel = hiltViewModel<SomethingListViewModel>()
    val state by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        when(state) {
            is UiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            is UiState.Success -> {
                val data = (state as UiState.Success<List<SomethingViewData>>).data
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    items(data) {
                        SomethingItem(it.name, it.currentParam) {
                            onDetailsClick.invoke(it.id)
                        }
                    }
                }
            }
            is UiState.Error -> {
            }
        }
    }
}