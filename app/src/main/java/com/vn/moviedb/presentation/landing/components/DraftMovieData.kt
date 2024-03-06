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

import com.vn.moviedb.presentation.models.MovieModel

/**
 * provide fake data for preview function in jetpack compose
 * */
internal val movie1 = MovieModel(
        adult = false,
        backdropPath = "https://via.placeholder.com/150",
        genreIds = listOf(1, 2, 3),
        id = 1,
        originalLanguage = "en",
        originalTitle = "Godzilla x Kong: The New Empire",
        overview = "Following their explosive showdown, Godzilla and Kong must reunite against " +
                "a colossal undiscovered threat hidden within our world, challenging their very existence – and our own",
        popularity = 7.5,
        releaseDate = "2022-01-01",
        title = "Godzilla x Kong: The New Empire",
        video = false,
        voteAverage = 8.0,
        voteCount = 100,
    )

internal val draftMovies = listOf(movie1, movie1, movie1, movie1, movie1, movie1, movie1)
