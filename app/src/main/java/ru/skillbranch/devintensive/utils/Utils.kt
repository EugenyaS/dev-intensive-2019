package ru.skillbranch.devintensive.utils

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
        var initials: String? = null
        if (!firstName.isNullOrBlank()) {
            initials = firstName?.capitalize()?.first().toString()
        }
        if (!lastName.isNullOrBlank()) {
            initials += lastName?.capitalize()?.first().toString()
        }
        return initials
    }


}