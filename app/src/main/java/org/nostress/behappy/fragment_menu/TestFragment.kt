package org.nostress.behappy.fragment_menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_test.*
import org.nostress.behappy.R
import org.nostress.behappy.TestK10Activity


class TestFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_mulai_tes.setOnClickListener {
            val intent = Intent (getActivity(), TestK10Activity::class.java)
            getActivity()?.startActivity(intent)
        }
    }

}