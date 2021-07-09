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
import org.nostress.behappy.viewpager.ViewPagerAdapter_Pengertian_Stres

class PengertianStresFragment : Fragment() {

    private var titleList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pengertian_stres, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postToList()

        viewpager_gejala_stres.adapter = ViewPagerAdapter_Pengertian_Stres(titleList,descList,imageList)
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
                "Hans Selye",
                "Hans Selye (dalam Grandjean, 2000) pada tahun 1930 yang mendefinisikan stres sebagai reaksi organisme dalam menghadapi situasi yang membahayakan atau mengancam.",
                R.drawable.hans_selye
            )
            addToList(
                "Edward P. Sarafino",
                "Menurut Sarafino (dalam Smet, 1994) stres adalah suatu kondisi yang disebabkan oleh transaksi antara individu dengan lingkungan yang menimbulkan persepsi jarak antara tuntutan-tuntutan yang berasal dari situasi dengan sumber-sumber daya sistem biologis, psikologis, dan sosial seseorang. ",
                R.drawable.sarafino
            )
            addToList(
                "Agus M. Hardjana",
                "Menurut Hardjana (dalam Stres Tanpa Distres Seni Mengelola Stres 1994) stres dapat didefinisikan sebagai suatu keadaan atau kondisi yang disebabkan oleh transaksi individu dan menyebabkan individu melihat ketidaksepadanan, baik keadaan atau kondisi nyata maupun tidak nyata, selain itu individu juga melihat ketidaksepadanan dari sistem sumber daya biologis, psikologis, dan sosial.",
                R.drawable.hardjana
            )
        }
    }

}