package org.nostress.behappy

import android.os.Parcelable
import com.google.firebase.database.Exclude
import kotlinx.android.parcel.Parcelize


@Parcelize
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
):Parcelable{
        @get:Exclude
        var idUser: String = ""
}
