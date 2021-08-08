package org.nostress.behappy

import android.content.Intent
import android.net.Uri
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_pendapat_psikolog.*
import kotlinx.android.synthetic.main.activity_solusi_stres.btn_to_menu
import kotlinx.android.synthetic.main.item_pendapat_psikolog.*


class PendapatPsikologActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pendapat_psikolog)



        ivThumbnail1.setOnClickListener {
            ivThumbnail1.visibility = View.INVISIBLE
            videoView1.visibility = View.VISIBLE
            videoView1()
            videoView1.setOnCompletionListener {
                videoView1.visibility = View.INVISIBLE
                ivThumbnail1.visibility = View.VISIBLE
            }
        }

        ivThumbnail2.setOnClickListener {
            ivThumbnail2.visibility = View.INVISIBLE
            videoView2.visibility = View.VISIBLE
            videoView2()
            videoView2.setOnCompletionListener {
                videoView2.visibility = View.INVISIBLE
                ivThumbnail2.visibility = View.VISIBLE
            }
        }

        btn_to_menu.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    private fun videoView2() {
        val videoView = findViewById<VideoView>(R.id.videoView2)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val videoUri = Uri.parse("android.resource://$packageName/${R.raw.mengelola_stres_pak_budi}")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()
        videoView.start()
    }

    private fun videoView1(){

        val videoView = findViewById<VideoView>(R.id.videoView1)
        val mediaController1 = MediaController(this)
        mediaController1.setAnchorView(videoView)

        val videoUri1 = Uri.parse("android.resource://$packageName/${R.raw.pengertian_stres}")

        videoView.setMediaController(mediaController1)
        videoView.setVideoURI(videoUri1)
        videoView.requestFocus()
        videoView.start()
    }

}