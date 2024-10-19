package com.example.notes.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object CustomTextFieldColors {
    @Composable
    fun colorsTextFields() = OutlinedTextFieldDefaults.colors(
        unfocusedContainerColor = MaterialTheme.colorScheme.tertiary.copy(0.9f),
        focusedContainerColor = MaterialTheme.colorScheme.tertiary.copy(0.9f),
        focusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedBorderColor = MaterialTheme.colorScheme.onSurface,
        focusedBorderColor = MaterialTheme.colorScheme.onSurface,
        focusedPlaceholderColor = MaterialTheme.colorScheme.onSurface,
        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurface,
        cursorColor = MaterialTheme.colorScheme.onSurface,
        errorBorderColor = Color.Red,
        errorContainerColor = MaterialTheme.colorScheme.tertiary.copy(0.9f),
        errorPlaceholderColor = MaterialTheme.colorScheme.onSurface
    )
}