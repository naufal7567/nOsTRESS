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

class DampakStresFragment : Fragment() {

    private var titleList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dampak_stres, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postToList()

        viewpager_gejala_stres.adapter = ViewPagerAdapter_Dampak_Stres(titleList,descList,imageList)
        viewpager_gejala_stres.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        indicator.setViewPager(viewpager_gejala_stres)

    }

    private fun addToList(title: String, desc: String, image: Int){
        titleList.add(title)
        descList.add(desc)
        imageList.add(image)
    }

    private fun postToList (){
        for (i in 0..0){
            addToList(
                "Fisik",
                "Detak jantung meningkat, pencernaan melambat, paru-paru mengembang, dan tangan berkeringat",
                R.drawable.fisik_stres
            )
            addToList(
                "Psikis",
                "Bingung, khawatir, perubahan pola makan, psikosomatis",
                R.drawable.psikis_stres
            )
            addToList(
                "Sosial",
                "Menarik diri dari kegiatan sosial, kehilangan minat berinteraksi, mudah tersinggung, dan kemampuan komunikasi memburuk",
                R.drawable.sosial_stres
            )
            addToList(
                "Spritual",
                "Putus asa, sering mengeluh dan malas beribadah",
                R.drawable.spritual_stres
            )
        }
    }

}