package ru.skillbranch.devintensive.extensions


fun String.truncate(lengthStr: Int = 16): String  = when (trimEnd().length - 1) {
        in 0..lengthStr -> trimEnd()
        else -> trimEnd().substring(0 until lengthStr).trimEnd().plus("...")
    }

fun String.stripHtml():String {
    var result=this
    result = result.replace("[ ]+".toRegex(), " ").replace("&(?:[a-z\\d]+|#\\d+|#x[a-f\\d]+);".toRegex(), "")
        .replace("<(.|\\n)*?>".toRegex(), "")
    return result
}
