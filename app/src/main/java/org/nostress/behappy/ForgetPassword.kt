package org.nostress.behappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forget_password.*

class ForgetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        LupaPassword_button_Submit.setOnClickListener {
            val email: String = email_edittext_lLupaPassword.text.toString().trim { it <= ' '}
            if (email.isEmpty()){
                Toast.makeText(
                    this@ForgetPassword,
                    "Mohon isi email anda terlebih dahulu.",
                    Toast.LENGTH_SHORT
                ).show()
            }else {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Toast.makeText(
                                this@ForgetPassword,
                                "Sukses mengirim ke email anda untuk melakukan reset password!",
                                Toast.LENGTH_LONG
                            ).show()
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        }else {
                            Toast.makeText(
                                this@ForgetPassword,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }
    }
}