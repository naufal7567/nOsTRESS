package org.nostress.behappy.fragment_info_stres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_gejala_stres.*
import org.nostress.behappy.R
import org.nostress.behappy.viewpager.ViewPagerAdapter_Gejala_Stres
import org.nostress.behappy.viewpager.ViewPagerAdapter_Tingkatan_Stres

class TingkatanStresFragment : Fragment() {

    private var titleList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tingkatan_stres, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postToList()

        viewpager_gejala_stres.adapter = ViewPagerAdapter_Tingkatan_Stres(titleList,descList,imageList)
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
                "Tingkat Rendah",
                "Stres rendah adalah stresor yang dihadapi setiap orang secara teratur, seperti terlalu banyak tidur, kemacetan lalu lintas, kritikan dari atasan. Situasi seperti ini biasanya berlangsung beberapa menit atau jam. Stresor rendah biasanya tidak disertai dengan gejala yang berat.",
                    R.drawable.stres_ringan
            )
            addToList(
                "Tingkat Sedang",
                "Berlangsung lebih lama dari beberapa jam sampai beberapa hari. Situasi perselisihan yang tidak terselesaikan dengan rekan, anak yang sakit, atau ketidakhadiran dari anggota keluarga merupakan penyebab stres sedang. Ciri-ciri dari stres sedang, yakni sakit perut, otot-otot terasa tegang, perasaan tegang, dan gangguan tidur.",
                R.drawable.stres_sedang)
            addToList(
                "Tingkat Tinggi",
                "Stres pada kategori tinggi adalah situasi yang lama dirasakan oleh seseorang dapat berlangsung beberapa minggu sampai beberapa bulan, seperti perselisihan perkawinan secara terus menerus, kesulitan finansial yang berlangsung karena tidak ada perbaikan, berpisah dengan keluarga, berpindah tempat tinggal, dan memiliki penyakit kronis.",
                R.drawable.stres_berat)
        }
    }

}