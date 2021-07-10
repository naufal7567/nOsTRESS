package org.nostress.behappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class HasilTestActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_test)

        auth = FirebaseAuth.getInstance()

        val extraScore =intent.getIntExtra("EXTRA_SCORE", 0)
        val ref: DatabaseReference = FirebaseDatabase.getInstance().getReference("UserStress")
        val userStressId = ref.push().key.toString()
        val userStress = UserScore(auth.currentUser?.uid.toString(), extraScore)
        ref.child(userStressId).setValue(userStress)
                .addOnSuccessListener {
                    Toast.makeText(applicationContext, "Berhasi Menyimpan Skor", Toast.LENGTH_SHORT)
                }
                .addOnFailureListener {
                    Toast.makeText(applicationContext, "Terjadi Kesalahan saat menyimpan skor", Toast.LENGTH_SHORT)
                }

        var tvScore = findViewById<TextView>(R.id.tvSkor)
        var btnSolusi = findViewById<Button>(R.id.btn_Solusi)
        var btnPsikolog = findViewById<Button>(R.id.btn_Hubungi_Psikolog)
        var btnSelesai = findViewById<Button>(R.id.btn_SelesaiTest)

        tvScore.text = extraScore.toString()

        btnSolusi.setOnClickListener {
            startActivity(Intent(this,SolusiStresActivity::class.java))
            finish()
        }

        btnSelesai.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}