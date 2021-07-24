package org.nostress.behappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_solusi_stres.*
import kotlinx.android.synthetic.main.fragment_gejala_stres.*
import kotlinx.android.synthetic.main.fragment_gejala_stres.indicator
import kotlinx.android.synthetic.main.fragment_gejala_stres.viewpager_gejala_stres
import org.nostress.behappy.viewpager.ViewPagerAdapter_Gejala_Stres
import org.nostress.behappy.viewpager.ViewPagerAdapter_Solusi_Stres

class SolusiStresActivity : AppCompatActivity() {

    private var titleList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solusi_stres)

        postToList()

        viewpager_gejala_stres.adapter = ViewPagerAdapter_Solusi_Stres(titleList,imageList)
        viewpager_gejala_stres.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        indicator.setViewPager(viewpager_gejala_stres)

        btn_to_menu.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }

    private fun addToList(title: String, image: Int){
        titleList.add(title)
        imageList.add(image)
    }

    private fun postToList (){
        for (i in 0..0){
            addToList(
                "Latihan pernapasan dalam diyakini dapat mengurangi stres. \n\nGeser ke kanan untuk memulai latihan pernapasan dalam.",
                R.drawable.nafas_title
            )
            addToList(
                "Tarik napas pelan-pelan melalui hidung, mulut ditutup. Ambil napas dalam, lembut dan pelan.",
                R.drawable.nafas1
            )
            addToList(
                "Saat menarik napas, dorong perut ke arah tangan dan rasakan perut mengembang. Tahan selama 2 detik.",
                R.drawable.nafas2
            )
            addToList(
                "Keluarkan napas perlahan melalui hidung, rasakan perut mulai melemas dan turunkan tangan",
                R.drawable.nafas3
            )
            addToList(
                "Ulangi 5 sampai 10 kali untuk hasil yang lebih maksimal.",
                R.drawable.nafas4
            )
        }
    }
}

