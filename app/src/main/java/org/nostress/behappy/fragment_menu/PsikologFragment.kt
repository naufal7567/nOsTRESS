package org.nostress.behappy.fragment_menu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_psikolog.*
import org.nostress.behappy.R


class PsikologFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_psikolog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvEmail_Gilberta.setOnClickListener {
            val selectorIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
            }
            val intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_EMAIL, arrayOf("deargilby@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Email Konsultasi NoStress")
                selector = selectorIntent
            }
            startActivity(Intent.createChooser(intent, "Tess"))
        }
        tvEmail_Titin.setOnClickListener {
            val selectorIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
            }
            val intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_EMAIL, arrayOf("titinflorentina77@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Email Konsultasi NoStress")
                selector = selectorIntent
            }
            startActivity(Intent.createChooser(intent, "Tess 2"))
        }
        tvEmail_Budy.setOnClickListener {
            val selectorIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
            }
            val intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_EMAIL, arrayOf("budhyapuak@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Email Konsultasi NoStress")
                selector = selectorIntent
            }
            startActivity(Intent.createChooser(intent, "Tess 3"))
        }
        tvEmail_Herawaty.setOnClickListener {
            val selectorIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
            }
            val intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_EMAIL, arrayOf("herawatyaminullah@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Email Konsultasi NoStress")
                selector = selectorIntent
            }
            startActivity(Intent.createChooser(intent, "Tess 4"))
        }


    }
}