package org.nostress.behappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    private lateinit var ref :DatabaseReference

    private lateinit var username_edittext_register : EditText
    private lateinit var email_edittext_register : EditText
    private lateinit var password_edittext_register : EditText
    private lateinit var register_button_register : Button

//    var dataReference : DatabaseReference? = null
//    var database : FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        ref = FirebaseDatabase.getInstance().getReference("UserStress")

        username_edittext_register = findViewById(R.id.username_edittext_register)
        email_edittext_register = findViewById(R.id.email_edittext_register)
        password_edittext_register = findViewById(R.id.password_edittext_register)

//        database = FirebaseDatabase.getInstance()
//        dataReference = datafinbase?.getReference("profil")

        register_button_register.setOnClickListener {
            Register()
        }

        already_have_account_text_view.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }

    private fun Register() {
        val username = username_edittext_register.text.toString().trim()
        val email = email_edittext_register.text.toString().trim()
        val password = password_edittext_register.text.toString().trim()

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
            return
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

//                val currentUser = auth.currentUser
//                val currentUserDb = dataReference?.child((currentUser?.uid!!))
//                currentUserDb?.child("username")?.setValue(username_edittext_register.text.toString())
//                currentUserDb?.child("email")?.setValue(email_edittext_register.text.toString())
//                currentUserDb?.child("password")?.setValue(password_edittext_register.text.toString())

                Log.d("Registerakun", "Successfully create user with uid : ${it.result?.user?.uid}")
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            .addOnFailureListener {
                Log.d("Registerakun", "Failed to create user : ${it.message}")
                if (it.message.equals("The email address is badly formatted.")) {
                    Toast.makeText(this, "Format email salah", Toast.LENGTH_SHORT).show()
                } else if (it.message.equals("The given password is invalid. [ Password should be at least 6 characters ]")) {
                    Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
                } else if (it.message.equals("The email address is already in use by another account.")) {
                    Toast.makeText(this, "Email sudah pernah digunakan", Toast.LENGTH_SHORT).show()
                }
            }
        //val ref: DatabaseReference = FirebaseDatabase.getInstance().getReference("UserStress")

        val UserStressId = ref.push().key

        val UserStress = UserStress(UserStressId, username, email)

        if (UserStressId != null) {
            ref.child(UserStressId).setValue(UserStress).addOnCanceledListener {
                Toast.makeText(applicationContext, "Berhasi Mempunyai Akun NoStress",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
