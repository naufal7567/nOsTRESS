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

        ivThumbnail3.setOnClickListener {
            ivThumbnail3.visibility = View.INVISIBLE
            videoView3.visibility = View.VISIBLE
            videoView3()
            videoView3.setOnCompletionListener {
                videoView3.visibility = View.INVISIBLE
                ivThumbnail3.visibility = View.VISIBLE
            }
        }

        ivThumbnail4.setOnClickListener {
            ivThumbnail4.visibility = View.INVISIBLE
            videoView4.visibility = View.VISIBLE
            videoView4()
            videoView4.setOnCompletionListener {
                videoView4.visibility = View.INVISIBLE
                ivThumbnail4.visibility = View.VISIBLE
            }
        }

        ivThumbnail5.setOnClickListener {
            ivThumbnail5.visibility = View.INVISIBLE
            videoView5.visibility = View.VISIBLE
            videoView5()
            videoView5.setOnCompletionListener {
                videoView5.visibility = View.INVISIBLE
                ivThumbnail5.visibility = View.VISIBLE
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

        val videoUri = Uri.parse("android.resource://$packageName/${R.raw.mengelola_stres}")

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

    private fun videoView3(){

        val videoView = findViewById<VideoView>(R.id.videoView3)
        val mediaController3 = MediaController(this)
        mediaController3.setAnchorView(videoView)

        val videoUri3 = Uri.parse("android.resource://$packageName/${R.raw.pengertian_stres_pak_budi}")

        videoView.setMediaController(mediaController3)
        videoView.setVideoURI(videoUri3)
        videoView.requestFocus()
        videoView.start()
    }

    private fun videoView4(){

        val videoView = findViewById<VideoView>(R.id.videoView4)
        val mediaController4 = MediaController(this)
        mediaController4.setAnchorView(videoView)

        val videoUri4 = Uri.parse("android.resource://$packageName/${R.raw.tingkatan_stres_pak_budi}")

        videoView.setMediaController(mediaController4)
        videoView.setVideoURI(videoUri4)
        videoView.requestFocus()
        videoView.start()
    }

    private fun videoView5(){

        val videoView = findViewById<VideoView>(R.id.videoView5)
        val mediaController5 = MediaController(this)
        mediaController5.setAnchorView(videoView)

        val videoUri5 = Uri.parse("android.resource://$packageName/${R.raw.mengelola_stres_pak_budi}")

        videoView.setMediaController(mediaController5)
        videoView.setVideoURI(videoUri5)
        videoView.requestFocus()
        videoView.start()
    }


}