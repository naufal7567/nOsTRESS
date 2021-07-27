package org.nostress.behappy

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_pendapat_psikolog.*
import kotlinx.android.synthetic.main.activity_solusi_stres.*
import kotlinx.android.synthetic.main.activity_solusi_stres.btn_to_menu
import kotlinx.android.synthetic.main.activity_solusi_stres.indicator
import kotlinx.android.synthetic.main.activity_solusi_stres.viewpager_gejala_stres
import kotlinx.android.synthetic.main.fragment_gejala_stres.*
import kotlinx.android.synthetic.main.item_pendapat_psikolog.*
import org.nostress.behappy.viewpager.ViewPagerAdapter_Pengertian_Stres
import org.nostress.behappy.viewpager.ViewPagerAdapter_Solusi_Stres

class PendapatPsikologActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pendapat_psikolog)


        videoView1()
        videoView2()

        btn_to_menu.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    private fun videoView2() {
        val videoView = findViewById<VideoView>(R.id.videoView2)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val videoUri = Uri.parse("android.resource://$packageName/${R.raw.mengelola_stres}")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(videoUri)
    }

    private fun videoView1(){

        val videoView = findViewById<VideoView>(R.id.videoView1)
        val mediaController1 = MediaController(this)
        mediaController1.setAnchorView(videoView)

        val videoUri1 = Uri.parse("android.resource://$packageName/${R.raw.pengertian_stres}")

        videoView.setMediaController(mediaController1)
        videoView.setVideoURI(videoUri1)
    }


}