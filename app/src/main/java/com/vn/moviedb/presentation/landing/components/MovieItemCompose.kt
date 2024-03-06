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
package com.vn.moviedb.presentation.landing.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.vn.moviedb.presentation.components.conner0
import com.vn.moviedb.presentation.components.conner16
import com.vn.moviedb.presentation.components.spacing8
import com.vn.moviedb.presentation.contact.OnClickMovieListener
import com.vn.moviedb.presentation.models.MovieModel

@ExperimentalCoilApi
@Composable
fun movieItemCompose(
    movie: MovieModel,
    onclickListener: OnClickMovieListener,
) {
    val painter: Painter = rememberAsyncImagePainter(movie.backdropPath)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onclickListener(movie) },
        elevation = CardDefaults.outlinedCardElevation(),
    ) {
        Column{
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f) // Maintain aspect ratio of the image
                    .clip(RoundedCornerShape(topStart = conner16,
                        topEnd = conner16,
                        bottomEnd = conner0,
                        bottomStart = conner0
                    ))
            )

            Text(
                text = movie.title,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(spacing8)
            )
        }
    }
}

@ExperimentalCoilApi
@ExperimentalComposeApi
@Preview
@Composable
fun previewMovieItemCompose() {
    movieItemCompose(movie1) {
    }
}
