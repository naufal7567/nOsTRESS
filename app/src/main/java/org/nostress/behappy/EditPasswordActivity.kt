package org.nostress.behappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.bumptech.glide.load.engine.Resource
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_edit_password.*

class EditPasswordActivity : AppCompatActivity() {


    private lateinit var password_edittext: EditText
    private lateinit var passwordNew1_edittext: EditText
    private lateinit var passwordNew2_edittext: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_password)

        var auth = FirebaseAuth.getInstance().currentUser

        password_edittext = findViewById(R.id.password_edittext)
        passwordNew1_edittext = findViewById(R.id.passwordNew1_edittext)
        passwordNew2_edittext = findViewById(R.id.passwordNew2_edittext)



        btn_simpanPassword.setOnClickListener {
            val passwordLama = password_edittext.text.toString().trim()
            val passwordBaru1 = passwordNew1_edittext.text.toString().trim()
            val passwordBaru2 = passwordNew2_edittext.text.toString().trim()

            if (passwordLama.isEmpty() || passwordBaru1.isEmpty() || passwordBaru2.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
            } else if (passwordBaru1 != passwordBaru2) {
                Toast.makeText(this, "Password baru yang dimasukkan berbeda", Toast.LENGTH_LONG)
                    .show()
            } else {
                if (auth != null) {
                    val credential = EmailAuthProvider.getCredential(auth?.email!!, passwordLama)

                    auth!!.reauthenticate(credential)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                auth!!.updatePassword(passwordBaru1)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            Toast.makeText(
                                                this,
                                                "Berhasil ganti password",
                                                Toast.LENGTH_LONG
                                            ).show()
                                            val intent = Intent(this, MainActivity::class.java)
                                            intent.putExtra("setFragment", "account")
                                            startActivity(intent)
                                        }
                                    }
                            } else {
                                Toast.makeText(this, "Gagal ganti password", Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                }
            }

            btn_batal_simpan_pass.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("setFragment", "account")
                startActivity(intent)
            }
        }
    }
}