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

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.vn.moviedb.presentation.models.MovieModel

class LandingViewModel : ViewModel() {
    private val _movieList = mutableStateOf<List<MovieModel>>(emptyList())
    val movieList: State<List<MovieModel>> = _movieList
    internal fun updateMovies(ls: List<MovieModel>) {
        _movieList.value = ls
    }
}
