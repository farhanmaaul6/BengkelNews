package com.farhan.bengkelnews.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.farhan.bengkelnews.ui.theme.BengkelNewsTheme
import java.lang.reflect.Type

@Composable
fun BengkelListItem(
    title: String,
    photoUrl: String,
    type1: String,
    type2: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()  // Set the width to fill the available space
                .height(200.dp)
                .width(200.dp)
                .padding(8.dp)
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp),
            maxLines = 3
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
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
    }
}

@Preview(showBackground = true)
@Composable
fun BengkelListItemPreview() {
    BengkelNewsTheme {
        BengkelListItem(
            title = "Penyebab Motor Matic Sering Mogok saat Digunakan Berkendara",
            photoUrl = " ",
            type1 = "Motor",
            type2 = "Motor Matic",
        )
    }
}