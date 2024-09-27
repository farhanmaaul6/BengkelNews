package com.farhan.bengkelnews.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.farhan.bengkelnews.ViewModelFactory
import com.farhan.bengkelnews.di.Injection
import com.farhan.bengkelnews.model.Bengkel
import com.farhan.bengkelnews.ui.common.UiState
import com.farhan.bengkelnews.ui.theme.BengkelNewsTheme


@Composable
fun DetailNewsScreen(
    newsId: Long,
    viewModel: DetailNewsViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navigateBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState(initial = UiState.Loading)

    when (uiState) {
        is UiState.Loading -> {
            viewModel.getBengkelById(newsId)
        }
        is UiState.Success<*> -> {
            val data = (uiState as UiState.Success<List<Bengkel>>).data.firstOrNull()
            if (data != null) {
                DetailContent(
                    photoUrl = data.photoUrl,
                    title = data.title,
                    description = data.description,
                    type1 = data.type1,
                    type2 = data.type2,
                    linkUrl = data.linkUrl,
                )
            } else {
            }
        }
        is UiState.Error -> {

        }
    }
}

@Composable
fun DetailContent(
    photoUrl: String,
    title: String,
    type1:String,
    type2: String,
    description: String,
    linkUrl: String,
) {

    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .width(200.dp)
                .padding(8.dp)
        )
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    bottom = 10.dp
                )
        )
        Row (
            modifier = Modifier
                .padding(start = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFFFA500), shape = RoundedCornerShape(15.dp))
            ) {
                Text(
                    text = type1,
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .width(5.dp)
            )
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFFFC0CB), shape = RoundedCornerShape(15.dp))
            ) {
                Text(
                    text = type2,
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        Spacer(
            modifier = Modifier
              .height(10.dp)
        )
        Text(
            text = description,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    bottom = 10.dp
                )
                .align(alignment = Alignment.Start)
        )

        Button(
            onClick = {
                uriHandler.openUri(linkUrl)
            },
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    uriHandler.openUri(linkUrl)
                }
        ) {
            Text("Open URL")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailContentPreview() {
    BengkelNewsTheme {
        DetailContent(
            photoUrl = "",
            title = "Penyebab Motor Matic Sering Mogok saat Digunakan Berkendara",
            description = "Penyebab motor matic mogok bisa karena berbagai faktor. Tak jarang motor matic mogok karena pemilik tidak mengecek kondisi motornya dan melakukan service secara rutin.",
            linkUrl = " ",
            type1 = "Motor",
            type2 = "Motor Matic"
        )
    }
}