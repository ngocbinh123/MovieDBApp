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
package com.vn.moviedb.domain.usecases.movies

import com.vn.moviedb.data.repo.movie.GetLocalMoviesRepo
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetLocalMoviesUseCase : KoinComponent {
    private val repo: GetLocalMoviesRepo by inject()

    fun getRemoteMoviesFlow() =
        flow {
            val result = repo.getLocalMovies()
            emit(result)
        }
}