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

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.vn.moviedb.R
import com.vn.moviedb.presentation.contact.LoadMoreMoviesListener
import com.vn.moviedb.presentation.contact.OnClickMovieListener
import com.vn.moviedb.presentation.landing.components.landingScreen
import com.vn.moviedb.presentation.models.GetRemoteMovieState
import com.vn.moviedb.presentation.models.MovieModel
import com.vn.moviedb.presentation.services.GetMoviesService
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LandingFragment : Fragment() {
    private val viewModel: LandingViewModel by viewModel()
    private var getMoviesService: GetMoviesService? = null
    private lateinit var serviceConnection: ServiceConnection

    private val onClickMovieListener = object : OnClickMovieListener {
        override fun invoke(movie: MovieModel) {
            findNavController().navigate(R.id.action_landingFragment_to_detailFragment)
        }

    }

    private val onLoadMoreMoviesListener = object : LoadMoreMoviesListener {
        override fun invoke() {
            getMoviesService?.loadMoreData()
        }
    }

    override fun onStart() {
        super.onStart()
        bindToService()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                landingScreen(
                    viewModel.movieList.value,
                    onClickMovieListener,
                    onLoadMoreMoviesListener
                )
            }
        }
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStop() {
        super.onStop()
        unbindService()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            getMoviesService?.allMoviesStateFlow?.collect { state ->
                when (state) {
                    GetRemoteMovieState.Loading -> {
//                        show loading
                    }
                    is GetRemoteMovieState.Success -> {
                        viewModel.updateMovies(state.ls)
                    }
                    is GetRemoteMovieState.Error -> {
                        Toast.makeText(requireContext(), state.msg, Toast.LENGTH_SHORT).show()
                    }
                    else -> {
//                        hide loading
                    }
                }
            }
        }
    }

    private fun bindToService() {
        val intent = Intent(requireContext(), GetMoviesService::class.java)
        serviceConnection =
            object : ServiceConnection {
                override fun onServiceConnected(
                    name: ComponentName?,
                    service: IBinder?,
                ) {
                    val binder = service as GetMoviesService.MovieBinder
                    getMoviesService = binder.getService()
                    setupObservers()
                }

                override fun onServiceDisconnected(name: ComponentName?) {
                    getMoviesService = null
                }
            }
        requireContext().bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private fun unbindService() {
        requireContext().unbindService(serviceConnection)
    }
}
