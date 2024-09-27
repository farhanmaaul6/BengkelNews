package com.farhan.bengkelnews.ui.screen.news

import android.content.res.Resources
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.farhan.bengkelnews.model.Bengkel
import com.farhan.bengkelnews.ui.common.UiState
import com.farhan.bengkelnews.R
import com.farhan.bengkelnews.ViewModelFactory
import com.farhan.bengkelnews.di.Injection
import com.farhan.bengkelnews.model.BengkelData
import com.farhan.bengkelnews.ui.components.BengkelListItem
import com.farhan.bengkelnews.ui.theme.BengkelNewsTheme


@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
    when (uiState) {
        is UiState.Loading -> {
            viewModel.getBengkel()
        }
        is UiState.Success -> {
            NewsContent(
                bengkel = uiState.data,
                modifier = modifier,
                navigateToDetail = navigateToDetail,
            )
        }
        is UiState.Error -> {}
    }
    }
}

@Composable
fun NewsContent(
    bengkel: List<Bengkel>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    Box(modifier = modifier) {
        LazyColumn {
            items(bengkel, key = { it.title }) { bengkelItem ->
                BengkelListItem(
                    title = bengkelItem.title,
                    photoUrl = bengkelItem.photoUrl,
                    type1 = bengkelItem.type1,
                    type2 = bengkelItem.type2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navigateToDetail(bengkelItem.id) }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewsContentPreview() {
    BengkelNewsTheme {
        NewsContent(
            bengkel = listOf(
                Bengkel(
                    id = 1,
                    title = "Penyebab Motor Matic Sering Mogok saat Digunakan Berkendara",
                    photoUrl = " ",
                    type1 = "Motor",
                    type2 = "Motor Matic",
                    description = " ",
                    linkUrl = " ",
                )
            ),
            modifier = Modifier,
            navigateToDetail = {}
        )
    }
}

