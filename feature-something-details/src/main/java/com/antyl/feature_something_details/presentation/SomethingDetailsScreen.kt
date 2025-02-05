package com.antyl.feature_something_details.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.antyl.core.utils.UiState
import com.antyl.feature_something_list.R
import com.antyl.ui.component.ErrorView
import com.antyl.ui.component.LoadingView
import com.antyl.ui.theme.Pink40
import com.antyl.ui.theme.Pink80

@Composable
fun SomethingDetailsScreen(
    viewModel: SomethingDetailsViewModel,
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        when(val state = uiState) {
            is UiState.Loading -> {
                LoadingView()
            }
            is UiState.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 10.dp)
                        .background(color = Pink80, shape = RoundedCornerShape(10.dp)),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .padding(top = 10.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            text = stringResource(R.string.name),
                            textAlign = TextAlign.Start
                        )
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            text = state.data.name,
                            textAlign = TextAlign.End
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .padding(bottom = 10.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            text = stringResource(R.string.current_param),
                            textAlign = TextAlign.Start
                        )
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            text = state.data.currentParam,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
            is UiState.Error -> {
                ErrorView(text = state.message)
            }
        }
    }
}