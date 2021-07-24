package org.nostress.behappy.fragment_info_stres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_gejala_stres.*
import org.nostress.behappy.R
import org.nostress.behappy.viewpager.ViewPagerAdapter_Dampak_Stres
import org.nostress.behappy.viewpager.ViewPagerAdapter_Gejala_Stres

class MengelolaStresFragment : Fragment() {
    private var titleList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mengelola_stres, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postToList()

        viewpager_gejala_stres.adapter = ViewPagerAdapter_Gejala_Stres(titleList,imageList)
        viewpager_gejala_stres.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        indicator.setViewPager(viewpager_gejala_stres)

    }

    private fun addToList(title: String, image: Int){
        titleList.add(title)
        imageList.add(image)
    }

    private fun postToList () {
        for (i in 0..0) {
            addToList(
                "Mendekatkan diri kepada tuhan",
                R.drawable.pray_solusi
            )
            addToList(
                "Mengikuti komunitas keagamaan dan komunitas belajar",
                R.drawable.comunity_solusi
            )
            addToList(
                "Berpikir positif dan berusaha mengendalikan emosi negatif",
                R.drawable.positif_thinking_solusi
            )
            addToList(
                "Sharing masalah yang dihadapi dengan kerabat dekat",
                R.drawable.sharing_solusi
            )
            addToList(
                "Ikut kegiatan sosial",
                R.drawable.sosial_activity_solusi
            )
        }
    }

}