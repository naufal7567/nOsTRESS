package org.nostress.behappy

import com.google.firebase.database.Exclude

data class UserScore (
    val uid: String = "",
    val date: String = "",
    val score: Int = 0
    ) {

    }
