package org.nostress.behappy

import com.google.firebase.database.Exclude

data class UserScore (
    val uid: String = "",
    val score: Int = 0
    ) {
//        @get:Exclude
//        val id: String = ""
    }
