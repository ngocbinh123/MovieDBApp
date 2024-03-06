package com.vn.moviedb.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.vn.moviedb.presentation.contact.OnClickButtonListener

@Composable
fun backCircleButton(modifier: Modifier = Modifier, onClickListener: OnClickButtonListener) {
    Box(
        modifier = modifier
            .size(backButtonSize)
            .background(color = Color.White, shape = CircleShape)
            .padding(spacing8),
    ) {
        IconButton(onClick = onClickListener) {
            Icon(Icons.Filled.Close, contentDescription = "Back")
        }
    }
}

@Preview
@Composable
fun previewBackCircleButton() {
    backCircleButton {

    }
}


