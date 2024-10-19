package com.example.notes.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.notes.R
import com.example.notes.theme.myFontFamily

@Composable
fun CustomAlertDialog(onclose: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        containerColor = Color.White,
        onDismissRequest = {
            onclose()
        },
        icon = { Icon(Icons.Filled.Delete, contentDescription = null, tint = MaterialTheme.colorScheme.background) },
        title = {
            Text(
                stringResource(R.string.tem_certeza_que_deseja_exluir),
                textAlign = TextAlign.Center, fontSize = 30.sp, color = MaterialTheme.colorScheme.background,
                fontFamily = myFontFamily, fontWeight = FontWeight.Bold
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm()
                }
            ) {
                Text(
                    stringResource(R.string.confirmar),
                    color = Color.Red,
                    fontFamily = myFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onclose()
                }
            ) {
                Text(
                    stringResource(R.string.cancelar),
                    color = MaterialTheme.colorScheme.background,
                    fontFamily = myFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    )
}