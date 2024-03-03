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
package com.vn.moviedb.presentation.landing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vn.moviedb.presentation.models.MovieModel

class LandingViewModel : ViewModel() {
    val movieList =
        MutableLiveData<List<MovieModel>>(
            listOf(
                MovieModel("1", "Movie 1", "https://via.placeholder.com/150"),
                MovieModel("2", "Movie 2", "https://via.placeholder.com/150"),
                MovieModel("3", "Movie 3", "https://via.placeholder.com/150"),
                MovieModel("4", "Movie 4", "https://via.placeholder.com/150"),
                MovieModel("5", "Movie 5", "https://via.placeholder.com/150"),
            ),
        )
}
