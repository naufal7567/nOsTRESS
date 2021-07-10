package org.nostress.behappy

import com.google.firebase.database.Exclude

data class UserStress(
        val uid: String,
        val username: String,
        val email: String,
        val password: String
) {

}