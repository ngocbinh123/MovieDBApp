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
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import com.vn.moviedb.presentation.components.spacing16
import com.vn.moviedb.presentation.contact.LoadMoreMoviesListener
import com.vn.moviedb.presentation.contact.OnClickMovieListener
import com.vn.moviedb.presentation.models.MovieModel

private const val NUMBER_OF_LAST_ITEMS = 5
@OptIn(ExperimentalCoilApi::class)
@Composable
fun landingScreen(
    movieList: List<MovieModel>,
    onclickMovieItemListener: OnClickMovieListener,
    loadMoreData: LoadMoreMoviesListener
) {
    val scrollState = rememberLazyGridState()

    val reachedBottom: Boolean by remember {
        derivedStateOf {
            val lastVisibleItem = scrollState.layoutInfo.visibleItemsInfo.lastOrNull()
            lastVisibleItem?.index != 0 && lastVisibleItem?.index == scrollState.layoutInfo.totalItemsCount - NUMBER_OF_LAST_ITEMS
        }
    }

    LaunchedEffect(reachedBottom) {
        if (reachedBottom) {
            loadMoreData()
        }
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(spacing16),
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(spacing16), // Vertical padding between items
        horizontalArrangement = Arrangement.spacedBy(spacing16) // Horizontal padding between items
    ) {
        items(
            count = movieList.size,
        ) { pos ->
            movieItemCompose(movie = movieList[pos], onclickMovieItemListener)
        }
    }
}

@Preview
@Composable
fun previewLandingScreen() {
    landingScreen(draftMovies, {}, {})
}
