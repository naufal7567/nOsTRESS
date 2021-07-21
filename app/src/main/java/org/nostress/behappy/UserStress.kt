package org.nostress.behappy

import com.google.firebase.database.Exclude

data class UserStress(
        val uid: String = "",
        val firstname: String = "",
        val lastname: String = "",
        val tempat: String = "",
        val tanggal: String = "",
        val telepon: String = "",
        val alamat: String = "",
        val email: String = "",
        val password: String = ""
)