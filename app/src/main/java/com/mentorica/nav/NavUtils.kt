package com.mentorica.nav

object NavUtils {

    fun composePath(screenName: String, args: List<String>): String {
        val stringOfArgs = args.joinToString(separator = "/") { "{$it}" }
        return if (stringOfArgs.isEmpty()) screenName else "$screenName/$stringOfArgs"
    }
}
