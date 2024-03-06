/*
 * Copyright 2023 Vincent Tsen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vn.moviedb.presentation.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.vn.moviedb.presentation.components.backButtonSize
import com.vn.moviedb.presentation.components.backCircleButton
import com.vn.moviedb.presentation.components.conner0
import com.vn.moviedb.presentation.components.conner16
import com.vn.moviedb.presentation.components.detailImageHeight
import com.vn.moviedb.presentation.components.spacing16
import com.vn.moviedb.presentation.components.spacing24
import com.vn.moviedb.presentation.components.spacing8
import com.vn.moviedb.presentation.contact.OnClickButtonListener
import com.vn.moviedb.presentation.landing.components.movie1
import com.vn.moviedb.presentation.models.MovieModel
@OptIn(ExperimentalCoilApi::class)
@Composable
fun detailScreen(movie: MovieModel,
                 onClickBackButtonListener: OnClickButtonListener
) {
    val painter: Painter = rememberAsyncImagePainter(movie.backdropPath)
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(detailImageHeight)

            )
            backCircleButton(
                Modifier.padding(spacing16, spacing24),
                onClickBackButtonListener
            )
        }
        Text(
            text = movie.title,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = spacing16, end = spacing16, top = spacing24)
        )
        Text(
            text = movie.overview,
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(spacing16)
        )

        Text(
            text = "Votes: ${movie.voteCount}",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = spacing16, end = spacing16, bottom = spacing8)
        )
        Text(
            text = "vote Average: ${movie.voteAverage}, Rotten Tomatoes: ${movie.voteAverage}",
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(spacing16)
        )

        // Add more sections as needed
    }
}

@Preview
@Composable
fun previewDetailScreen() {
    detailScreen(movie1) {}
}
