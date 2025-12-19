package com.example.mvicorepoc.presentation.auth.signup.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun isDateValid(date: String): Boolean {
    if (date.length != 10) return false

    val parts = date.split("/")
    if (parts.size != 3) return false

    val day = parts[0].toIntOrNull() ?: return false
    val month = parts[1].toIntOrNull() ?: return false
    val year = parts[2].toIntOrNull() ?: return false

    if (day !in 1..31) return false
    if (month !in 1..12) return false
    if (year !in 1900..Calendar.getInstance().get(Calendar.YEAR)) return false

    return try {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        sdf.isLenient = false
        sdf.parse(date)
        true
    } catch (e: Exception) {
        false
    }
}