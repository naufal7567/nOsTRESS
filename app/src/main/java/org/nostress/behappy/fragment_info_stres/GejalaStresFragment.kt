package org.nostress.behappy.fragment_info_stres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_gejala_stres.*
import me.relex.circleindicator.CircleIndicator3
import org.nostress.behappy.R
import org.nostress.behappy.viewpager.ViewPagerAdapter_Gejala_Stres

class GejalaStresFragment : Fragment() {

    private var titleList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gejala_stres, container, false)
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

    private fun postToList (){
        for (i in 0..0){
            addToList("Sering mengamuk tanpa sebab jelas",R.drawable.mengamuk_stres)
            addToList("Mimpi buruk",R.drawable.mimpiburuk_stres)
            addToList("Tidak dapat berkonsentrasi",R.drawable.konsentrasi_stres)
            addToList("Mudah sekali bangun tidur",R.drawable.insomnia_stres)
            addToList("Sedih dan perasaan berdaya yang tidak menetap",R.drawable.sedih_stres)
            addToList("Memiliki rasa takut yang tidak wajar",R.drawable.takut_stres)
            addToList("Menarik diri dari pergaulan",R.drawable.penyendiri_stres)
        }
    }

}