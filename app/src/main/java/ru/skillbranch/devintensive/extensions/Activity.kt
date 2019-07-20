package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager


fun Activity.isKeyboardOpen() : Boolean {
    val rootView = findViewById<View>(android.R.id.content)
    val visibleBounds = Rect().apply { rootView.getWindowVisibleDisplayFrame(this) }
    return rootView.height - visibleBounds.height() > dpToPx(128F)
}

fun Activity.isKeyboardClose() = !this.isKeyboardOpen()

fun Activity.hideKeyboard() {
   // if (isKeyboardClosed()) return
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}
