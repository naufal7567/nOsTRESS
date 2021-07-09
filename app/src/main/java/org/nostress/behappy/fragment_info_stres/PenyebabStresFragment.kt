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
import org.nostress.behappy.viewpager.ViewPagerAdapter_Penyebab_Stres

class PenyebabStresFragment : Fragment() {

    private var titleList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_penyebab_stres, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postToList()

        viewpager_gejala_stres.adapter = ViewPagerAdapter_Penyebab_Stres(titleList,descList,imageList)
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
                "Stresor",
                "Sumber stres atau penyebab stres dikenali sebagai stresor. Stresor adalah segala situasi atau pemicu yang menyebabkan individu merasa tertekan atau terancam. Penyebab stresor di bagi menjadi dua, yaitu stresor eksternal dan stresor internal. ",
                R.drawable.stresor
            )
            addToList(
                "Stresor Internal",
                "Stresor internal merupakan stresor yang berasal dari dalam individu seperti stresor psikologis dan stresor biologis. Stresor psikologis yaitu tekanan dari dalam diri individu yang biasanya bersifat negatif seperti frustasi, kecemasan, rasa bersalah, kuatir berlebihan, marah, benci, sedih, cemburu, rasa kasihan pada diri sendiri, serta rasa rendah diri. Stresor biologis seperti pelepasan neurotransmiiters saat stres dari kelenjar adrenal, medula yaitu epinefri dan norepinefrin dalam respon terhadap stres. Pelepasan neurotransmitter menyebabkan efek fisiologis seperti denyut jantung meningkat, peningkatan kewaspadaan, dan lain-lain.",
                R.drawable.stresor_internal
            )
            addToList(
                "Stresor Eksternal",
                "Stresor eksternal merupakan stresor yang berasal dari luar individu seperti stresor yang berada di lingkungan dan stresor sosial yaitu tekanan dari luar yang disebabkan oleh interaksi individu dengan lingkungannya. Banyak stresor sosial yang bersifat traumatic yang tak dapat dihindari, seperti kehilangan orang yang dicintai, kehilangan pekerjaan, pensiun dari pekerjaan, masalah keuangan dan lain-lain.",
                R.drawable.penyendiri_stres
            )
        }
    }

}