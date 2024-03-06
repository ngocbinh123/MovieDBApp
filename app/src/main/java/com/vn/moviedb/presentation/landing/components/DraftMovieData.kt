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

val movie1 =
    MovieModel(
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

val movie2 =
    MovieModel(
        adult = true,
        backdropPath = "https://via.placeholder.com/150",
        genreIds = listOf(4, 5, 6),
        id = 2,
        originalLanguage = "fr",
        originalTitle = "Dummy Original Title 2",
        overview = "Dummy Overview 2",
        popularity = 8.5,
        releaseDate = "2022-02-02",
        title = "Dummy Title 2",
        video = true,
        voteAverage = 9.0,
        voteCount = 200,
    )

val movie3 =
    MovieModel(
        adult = false,
        backdropPath = "https://via.placeholder.com/150",
        genreIds = listOf(7, 8, 9),
        id = 3,
        originalLanguage = "es",
        originalTitle = "Dummy Original Title 3",
        overview = "Dummy Overview 3",
        popularity = 9.5,
        releaseDate = "2022-03-03",
        title = "Dummy Title 3",
        video = false,
        voteAverage = 9.5,
        voteCount = 300,
    )

val movie4 =
    MovieModel(
        adult = true,
        backdropPath = "https://via.placeholder.com/150",
        genreIds = listOf(10, 11, 12),
        id = 4,
        originalLanguage = "de",
        originalTitle = "Dummy Original Title 4",
        overview = "Dummy Overview 4",
        popularity = 6.5,
        releaseDate = "2022-04-04",
        title = "Dummy Title 4",
        video = true,
        voteAverage = 7.0,
        voteCount = 400,
    )

val movie5 =
    MovieModel(
        adult = false,
        backdropPath = "https://via.placeholder.com/150",
        genreIds = listOf(13, 14, 15),
        id = 5,
        originalLanguage = "it",
        originalTitle = "Dummy Original Title 5",
        overview = "Dummy Overview 5",
        popularity = 8.0,
        releaseDate = "2022-05-05",
        title = "Dummy Title 5",
        video = false,
        voteAverage = 8.5,
        voteCount = 500,
    )

val movie6 =
    MovieModel(
        adult = true,
        backdropPath = "https://via.placeholder.com/150",
        genreIds = listOf(16, 17, 18),
        id = 6,
        originalLanguage = "ja",
        originalTitle = "Dummy Original Title 6",
        overview = "Dummy Overview 6",
        popularity = 7.0,
        releaseDate = "2022-06-06",
        title = "Dummy Title 6",
        video = true,
        voteAverage = 7.5,
        voteCount = 600,
    )

val draftMovies = listOf(movie1, movie2, movie3, movie4, movie5, movie5, movie6)
