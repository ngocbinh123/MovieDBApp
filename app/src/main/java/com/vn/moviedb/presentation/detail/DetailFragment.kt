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
package com.vn.moviedb.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vn.moviedb.presentation.contact.OnClickButtonListener
import com.vn.moviedb.presentation.detail.components.detailScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {
    val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModel()

    private val onCLickBackButton = object : OnClickButtonListener {
        override fun invoke() {
            findNavController().popBackStack()
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                detailScreen(args.movieModel, onCLickBackButton)
            }
        }
    }
}
