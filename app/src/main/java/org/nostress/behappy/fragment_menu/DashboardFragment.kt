package org.nostress.behappy.fragment_menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.nostress.behappy.LoginActivity
import org.nostress.behappy.R
import org.nostress.behappy.SolusiStresActivity
import org.nostress.behappy.fragment_info_stres.*


class DashboardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_Pengertian_stres.setOnClickListener{
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, PengertianStresFragment())
            transaction?.commit()
        }

        btn_gejala_stres.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, GejalaStresFragment())
            transaction?.commit()
        }

        btn_penyebab_stres.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, PenyebabStresFragment())
            transaction?.commit()
        }

        btn_tingkatan_stres.setOnClickListener{
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, TingkatanStresFragment())
            transaction?.commit()
        }

        btn_dampak_stres.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, DampakStresFragment())
            transaction?.commit()
        }

        btn_solusi_stres.setOnClickListener {
            activity?.let{
                val intent = Intent (it, SolusiStresActivity::class.java)
                it.startActivity(intent)
            }
        }
    }


}