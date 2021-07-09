package org.nostress.behappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val currentuser = auth.currentUser
        if(currentuser != null) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }

        login_button_login.setOnClickListener {
           login()
        }

        back_to_register_textview.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }
    }

    private fun login(){
        val email = email_edittext_login.text.toString()
        val password = password_edittext_login.text.toString()

        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
            return
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (!it.isSuccessful) return@addOnCompleteListener

                Log.d("Loginakun", "Login berhasil");
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
    }

}
