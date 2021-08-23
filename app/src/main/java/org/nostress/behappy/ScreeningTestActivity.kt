package org.nostress.behappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_screening_test.*

class ScreeningTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screening_test)

        btn_mulai.setOnClickListener {
            startActivity(Intent(this,TestK10Activity::class.java))
            finish()
        }
    }
}