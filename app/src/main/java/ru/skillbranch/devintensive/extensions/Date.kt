package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.absoluteValue

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time
    return this
}


fun Date.humanizeDiff(date: Date = Date()): String {
    var time = this.time - date.time
    var resultTimeDay = time / DAY
    var resultTimeHour = time / HOUR
    var resultTimeMinute = time / MINUTE
    var resultTimeSecond = time / SECOND
    var str: String
    if (resultTimeDay.absoluteValue > 360)
        if (resultTimeDay < 0) str = "более года назад" else str = "более чем через год"
    else
        if (resultTimeDay.absoluteValue <= 360 && resultTimeHour.absoluteValue > 26) {
            if (resultTimeDay < 0) str = "${resultTimeDay.absoluteValue} дня назад" else str =
                "через ${resultTimeDay.absoluteValue} дня"
        } else
            if (resultTimeHour.absoluteValue >= 26 && resultTimeHour.absoluteValue < 22) {
                if (resultTimeHour < 0) str = "день назад" else str = "через день"
            } else
                if (resultTimeHour.absoluteValue <= 22 && resultTimeMinute.absoluteValue > 75) {
                    if (resultTimeHour < 0) str = "${resultTimeHour.absoluteValue} часа назад" else str =
                        "через ${resultTimeHour.absoluteValue} часа"
                } else
                    if (resultTimeMinute.absoluteValue >= 75 && resultTimeMinute.absoluteValue < 45) {
                        if (resultTimeMinute < 0) str = "час назад" else str = "через час"
                    } else
                        if (resultTimeMinute.absoluteValue <= 45 && resultTimeSecond.absoluteValue > 75) {
                            if (resultTimeMinute < 0) str = "${resultTimeMinute.absoluteValue} минуты назад" else str =
                                "через ${resultTimeMinute.absoluteValue} минуты"
                        } else
                            if (resultTimeSecond.absoluteValue >= 75 && resultTimeSecond.absoluteValue < 45) {
                                if (resultTimeSecond < 0) str = "минуту назад" else str = "через минуту"
                            } else
                                if (resultTimeSecond.absoluteValue >= 45 && resultTimeSecond.absoluteValue < 1) {
                                    if (resultTimeSecond < 0) str = "секунду назад" else str = "через секунду"
                                } else str = "только что"
    return str
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

