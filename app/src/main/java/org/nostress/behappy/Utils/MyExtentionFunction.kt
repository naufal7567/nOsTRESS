package org.nostress.behappy.Utils


fun isValidEmail(email: String) = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

fun isValidPassword(password: String) = password.length >= 8