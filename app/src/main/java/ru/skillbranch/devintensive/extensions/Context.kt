package ru.skillbranch.devintensive.extensions

import android.content.Context
import android.util.TypedValue
import kotlin.math.roundToInt

fun Context.dpToPx(dp: Float): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).roundToInt()