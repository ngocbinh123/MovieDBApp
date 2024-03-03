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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.vn.moviedb.presentation.components.cardHeight
import com.vn.moviedb.presentation.components.spacing8
import com.vn.moviedb.presentation.contact.OnClickMovieListener
import com.vn.moviedb.presentation.models.MovieModel

@ExperimentalCoilApi
@Composable
fun movieItemCompose(
    movie: MovieModel,
    onclickListener: OnClickMovieListener,
) {
    Card(
        modifier =
            Modifier.padding(spacing8)
                .clickable { onclickListener(movie) },
        elevation = CardDefaults.outlinedCardElevation(),
    ) {
        Column(
            modifier = Modifier.padding(spacing8),
        ) {
            Image(
                painter = rememberAsyncImagePainter(movie.thumbnailUrl),
                contentDescription = movie.name,
                modifier = Modifier.size(cardHeight),
            )
            Spacer(modifier = Modifier.height(spacing8))
            Text(
                text = movie.name,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@ExperimentalCoilApi
@ExperimentalComposeApi
@Preview
@Composable
fun previewMovieItemCompose() {
    val draftMovie =
        MovieModel(
            "movie01",
            "Code 8",
            "https://via.placeholder.com/150",
        )
    movieItemCompose(draftMovie) {
    }
}
