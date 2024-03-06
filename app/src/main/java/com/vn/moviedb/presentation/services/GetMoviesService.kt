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
package com.vn.moviedb.presentation.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.vn.moviedb.domain.usecases.movies.GetRemoteMoviesUseCase
import com.vn.moviedb.presentation.mapping.toModel
import com.vn.moviedb.presentation.models.GetRemoteMovieState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

@OptIn(ExperimentalCoroutinesApi::class)
class GetMoviesService : Service() {
    private val fetchMoviesUseCase: GetRemoteMoviesUseCase by inject()
    private val allMoviesFlow = MutableStateFlow<GetRemoteMovieState>(GetRemoteMovieState.Loading)
    internal val allMoviesStateFlow: StateFlow<GetRemoteMovieState>
        get() = allMoviesFlow

    private val binder = MovieBinder()

    override fun onCreate() {
        super.onCreate()
        fetchMovies()
    }

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int,
    ): Int {
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    inner class MovieBinder : Binder() {
        fun getService(): GetMoviesService {
            return this@GetMoviesService
        }
    }

    private fun fetchMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            allMoviesFlow.value = GetRemoteMovieState.Loading
            delay(2000L)
            fetchMoviesUseCase.getRemoteMoviesFlow()
                .flatMapLatest { entities ->
                    flow {
                        val models = entities.map { it.toModel() }
                        Log.d("NNBINH", "fetchMovies: $models")
                        emit(GetRemoteMovieState.Success(models))
                    }
                }
                .flowOn(Dispatchers.IO)
                .collect { result ->
                    allMoviesFlow.value = result
                }
        }
    }
}
