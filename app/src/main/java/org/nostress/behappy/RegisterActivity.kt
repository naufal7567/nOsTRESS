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
import org.nostress.behappy.Utils.isValidEmail
import org.nostress.behappy.Utils.isValidPassword

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
        register_button_register = findViewById(R.id.register_button_register)

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

        if (!isValidEmail(email)) {
            Toast.makeText(this, "Format email anda salah", Toast.LENGTH_SHORT).show()
            return
        }
        if (!isValidPassword(password)) {
            Toast.makeText(this, "Password Minimal 8 karakter", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener { authResult ->
                    val ref: DatabaseReference = FirebaseDatabase.getInstance().getReference("UserStress")
                    val userStressId = ref.push().key.toString()
                    val userStress = UserStress(auth.currentUser?.uid.toString(), username, email, password)
                    ref.child(userStressId).setValue(userStress)
                            .addOnSuccessListener {
                                Toast.makeText(applicationContext, "Berhasi Mempunyai Akun NoStress", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this, LoginActivity::class.java))
                                finish()
                            }
                            .addOnFailureListener {
                                Log.d("Gagal","DB gagal")
                                Log.d("Gagal","${it.message}")
                                Toast.makeText(applicationContext, "Terjadi Kesalahan saat membuat akun", Toast.LENGTH_SHORT).show()
                            }
                }
                .addOnFailureListener {
                    Log.d("Registerakun", "Failed to create user : ${it.message}")
                    if (it.message.equals("The email address is badly formatted.")) {
                        Toast.makeText(this, "Format email salah", Toast.LENGTH_SHORT).show()
                    } else if (it.message.equals("The email address is already in use by another account.")) {
                        Toast.makeText(this, "Email sudah pernah digunakan", Toast.LENGTH_SHORT).show()
                    }
                }
    }
}

