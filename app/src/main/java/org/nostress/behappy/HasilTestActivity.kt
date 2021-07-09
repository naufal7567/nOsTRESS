package org.nostress.behappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HasilTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_test)

        val extraScore =intent.getIntExtra("EXTRA_SCORE", 0)

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