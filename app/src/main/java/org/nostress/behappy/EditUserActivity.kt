package org.nostress.behappy

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_edit_user.*
import kotlinx.android.synthetic.main.activity_register.*
import org.nostress.behappy.Utils.isValidEmail
import org.nostress.behappy.Utils.isValidPassword
import java.text.SimpleDateFormat
import java.util.*

class EditUserActivity : AppCompatActivity() {
//    private lateinit var auth : FirebaseAuth
//
//    private lateinit var ref : DatabaseReference
//
//    private lateinit var firstname_edittext_edit : EditText
//    private lateinit var lastname_edittext_edit : EditText
//    private lateinit var tempat_edittext_edit : EditText
//    private lateinit var alamat_edittext_edit : EditText
//    private lateinit var telepon_edittext_edit : EditText
//    private lateinit var simpan_button : Button
//
//    private val formatter = SimpleDateFormat("dd-MM-yyyy")
//    private var pilihTanggal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)

//
//
//        ref = FirebaseDatabase.getInstance().getReference("UserStress")
//
//        firstname_edittext_edit = findViewById(R.id.Firstname_edittext_edit)
//        lastname_edittext_edit = findViewById(R.id.Lastname_edittext_edit)
//        tempat_edittext_edit = findViewById(R.id.Tempat_edittext_edit)
//        alamat_edittext_edit = findViewById(R.id.alamat_edittext_edit)
//        telepon_edittext_edit = findViewById(R.id.telepon_edittext_edit)
//
//        simpan_button = findViewById(R.id.btn_simpan)
//
//
//        val firstname = firstname_edittext_edit.text.toString().trim()
//        val lastname = lastname_edittext_edit.text.toString().trim()
//        val tempat = tempat_edittext_edit.text.toString().trim()
//        val tanggal = Tanggal_edittext_edit.text.toString().trim()
//        val alamat = alamat_edittext_edit.text.toString().trim()
//        val telepon = telepon_edittext_edit.text.toString().trim()
//
//        pickDate()
//
//        simpan_button.setOnClickListener {
//            EditData(firstname, lastname, tempat, tanggal, alamat, telepon)
//        }

        btn_batal.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("setFragment","account")
            startActivity(intent)
        }
    }

//    private fun EditData(firstname: String, lastname: String, tempat: String, tanggal: String, alamat: String, telepon: String) {
//        val database = FirebaseDatabase.getInstance().getReference("UserStress")
//        val uid = database.key.toString()
//        val user = mapOf<String, String>(
//                "firstname" to firstname,
//                "lastname" to lastname,
//                "tempat" to tempat,
//                "tanggal" to tanggal,
//                "alamat" to alamat,
//                "telepon" to telepon
//        )
//
//        database.child(uid).updateChildren(user).addOnSuccessListener {
//            val intent = Intent(this,MainActivity::class.java)
//            intent.putExtra("setFragment","account")
//            startActivity(intent)
//        }.addOnFailureListener {
//            Log.d("Gagal","DB gagal")
//            Log.d("Gagal","${it.message}")
//            Toast.makeText(applicationContext, "Terjadi Kesalahan saat membuat akun", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun pickDate() {
//        val calendar = Calendar.getInstance()
//        val year = calendar.get(Calendar.YEAR)
//        val month = calendar.get(Calendar.MONTH)
//        val day = calendar.get(Calendar.DAY_OF_MONTH)
//
//        Tanggal_edittext_edit.setOnClickListener {
//            val datePicker = DatePickerDialog(
//                    this,
//                    { _, mYear, mMonth, mDay ->
//                        pilihTanggal .set(mYear, mMonth, mDay)
//                        Tanggal_edittext_edit.text = Editable.Factory.getInstance()
//                                .newEditable(formatter.format(Date(pilihTanggal.timeInMillis)))
//                    },
//                    year,
//                    month,
//                    day
//            )
//            datePicker.show()
//        }
//    }

}