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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.vn.moviedb.presentation.components.spacing16
import com.vn.moviedb.presentation.components.spacing24
import com.vn.moviedb.presentation.components.spacing32
import com.vn.moviedb.presentation.components.spacing8
import com.vn.moviedb.presentation.contact.OnClickMovieListener
import com.vn.moviedb.presentation.models.MovieModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun landingScreen(
    movieList: List<MovieModel>,
    // listener for movie item clicks
    onClickMovieItemListener: OnClickMovieListener
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(spacing16),
        verticalArrangement = Arrangement.spacedBy(spacing16), // Vertical padding between items
        horizontalArrangement = Arrangement.spacedBy(spacing16) // Horizontal padding between items
    ) {
        items(
            count = movieList.size,
        ) { pos ->
            movieItemCompose(movie = movieList[pos], onClickMovieItemListener
            )
        }
    }
}

@Preview
@Composable
fun previewLandingScreen() {
    landingScreen(draftMovies) {
    }
}
