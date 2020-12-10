package com.kreate.mvvmproject

import android.app.Activity
import android.content.Context
import com.google.android.material.snackbar.Snackbar

fun isSnackBar(context: Context, message: String) {
    val snackbar =
        Snackbar.make(
            (context as Activity).findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        )
    snackbar.show()
}