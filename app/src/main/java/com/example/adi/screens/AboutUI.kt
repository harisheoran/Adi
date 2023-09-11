package com.example.adi.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.adi.R

data class About(
    val title: String,
    val subtitle: String,
    val icon: Int,
    val url: String
)

@Composable
fun AboutUI(modifier: Modifier = Modifier) {
    val aboutList = listOf<About>(
        About(
            title = "Github",
            subtitle = "Report Bugs, View the Source Code",
            icon = R.drawable.github,
            url = "https://github.com/harisheoran/Adi"
        ),
        About(
            title = "Mail",
            subtitle = "Reach out to us via email",
            icon = R.drawable.email,
            url = "mailto:harisheoran01@gmail.com"
        ),
        About(
            title = "TwitterX",
            subtitle = "Connect with me on twitter",
            icon = R.drawable.xlogo,
            url = "https://twitter.com/harisheoran"
        ),


        )
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(
            start = 18.dp,
            top = 18.dp,
            end = 18.dp,
            bottom = 18.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(aboutList) {
            AboutCard(data = it)
        }
    }
}

@Composable
fun AboutCard(data: About) {
    val paddingModifier = Modifier.padding(10.dp)
    val context = LocalContext.current
    val intent =
        remember { Intent(Intent.ACTION_VIEW, Uri.parse(data.url)) }

    Row(
        modifier = Modifier
            .padding(top = 12.dp, start = 12.dp, end = 12.dp, bottom = 12.dp)
            .clickable {
                startActivity(context, intent, null)
            }) {
        Column(modifier = Modifier.padding(top = 6.dp)) {
            Image(
                painter = painterResource(id = data.icon),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = data.subtitle,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400
            )
        }
    }

}