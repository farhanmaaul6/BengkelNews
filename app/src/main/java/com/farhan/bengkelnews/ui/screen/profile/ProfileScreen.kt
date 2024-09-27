package com.farhan.bengkelnews.ui.screen.profile

import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.farhan.bengkelnews.R
import com.farhan.bengkelnews.ui.theme.BengkelNewsTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .padding(top = 32.dp)
            .fillMaxSize()
    ) {
        val borderWidth = 4.dp
        Image(
            painter = painterResource(id = R.drawable.me),
            contentDescription = stringResource(id = R.string.me_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
                .border(
                    BorderStroke(borderWidth, Color.Cyan),
                    CircleShape
                )
                .padding(borderWidth)
                .clip(CircleShape)
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Text(
            text = stringResource(id = R.string.me_description),
            fontSize = 18.sp,
            lineHeight = 10.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 8.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(id = R.string.me_email),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    bottom = 10.dp
                )
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    BengkelNewsTheme {
        ProfileScreen(

        )
    }
}