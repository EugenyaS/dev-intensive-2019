package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extensions.TimeUnits

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        var firstName: String?
        var lastName: String?
        if (fullName.isNullOrBlank()) {
            firstName = null;
            lastName = null;
        } else {
            var parts: List<String>? = fullName?.trim()?.split(" ")
            firstName = parts?.getOrNull(0)
            lastName = parts?.getOrNull(1)
        }
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val map: HashMap<String, String> = hashMapOf(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya",
            " " to divider
        )

        var result: String = ""
        payload.toLowerCase().forEachIndexed { index, char ->
            if (map.get(char.toString()).isNullOrBlank()) result += payload[index] else if (payload[index].isUpperCase()) result += map.get(
                char.toString()
            )?.capitalize() else result += map.get(char.toString())
        }
        return result
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initials: String? = ""
        if (!firstName.isNullOrBlank()) {
            initials += firstName?.capitalize()?.first().toString()
        }
        if (!lastName.isNullOrBlank()) {
            initials += lastName?.capitalize()?.first().toString()
        }
        if (initials!!.isBlank()) initials = null
        return initials
    }

    fun declension(unitCnt: String, units: TimeUnits): String {
        val count="0$unitCnt"
        var str = when (units) {
            TimeUnits.SECOND -> {
                when (count[count.lastIndex]) {
                    '1' -> if (count[count.lastIndex - 1] == '1') "$unitCnt секунд" else "$unitCnt секунду"
                    in '2'..'4' -> if (count[count.lastIndex - 1] == '1') "$unitCnt секунд" else "$unitCnt секунды"
                    else -> "$unitCnt секунд"
                }
            }
            TimeUnits.MINUTE -> {
                when (count[count.lastIndex]) {
                    '1' -> if (count[count.lastIndex - 1] == '1') "$unitCnt минут" else "$unitCnt минуту"
                    in '2'..'4' -> if (count[count.lastIndex - 1] == '1') "$unitCnt минут" else "$unitCnt минуты"
                    else -> "$unitCnt минут"
                }
            }
            TimeUnits.HOUR -> {
                when (count[count.lastIndex]) {
                    '1' -> if (count[count.lastIndex - 1] == '1') "$unitCnt часов" else "$unitCnt час"
                    in '2'..'4' -> if (count[count.lastIndex - 1] == '1') "$unitCnt часов" else "$unitCnt часа"
                    else -> "$unitCnt часов"
                }
            }
            TimeUnits.DAY -> {
                when (count[count.lastIndex]) {
                    '1' -> if (count[count.lastIndex - 1] == '1') "$unitCnt дней" else "$unitCnt день"
                    in '2'..'4' -> if (count[count.lastIndex - 1] == '1') "$unitCnt дней" else "$unitCnt дня"
                    else -> "$unitCnt дней"
                }
            }
        }
        return str
    }

}