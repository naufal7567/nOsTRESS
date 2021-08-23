package org.nostress.behappy.fragment_menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_test.*
import org.nostress.behappy.*
import org.nostress.behappy.R


class TestFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    private fun getScore(scores : ArrayList<UserScore>, dates : ArrayList<UserScore>){

            val size = scores.size
            val date = dates.size

            if (size >= 3){
                tvSkor1.text = "Tanggal " + dates.get(size-1).date.toString() +"\n Skor " + scores.get(size-1).score.toString()
                tvSkor2.text ="Tanggal " + dates.get(size-2).date.toString() +"\n Skor " +  scores.get(size-2).score.toString()
                tvSkor3.text = "Tanggal " + dates.get(size-3).date.toString() +"\n Skor " + scores.get(size-3).score.toString()
                tvBelum.visibility = View.INVISIBLE
                tvSkor1.visibility = View.VISIBLE
                tvSkor2.visibility = View.VISIBLE
                tvSkor3.visibility = View.VISIBLE
            }
            else if (size >= 2){

                tvSkor1.text = "Tanggal " + dates.get(size-1).date.toString() +"\n Skor " + scores.get(size-1).score.toString()
                tvSkor2.text = "Tanggal " + dates.get(size-2).date.toString() +"\n Skor " + scores.get(size-2).score.toString()
                tvBelum.visibility = View.INVISIBLE
                tvSkor1.visibility = View.VISIBLE
                tvSkor2.visibility = View.VISIBLE
                tvSkor3.visibility = View.INVISIBLE
            }
            else if (size >= 1){
                tvSkor1.text = "Tanggal " + dates.get(size-1).date.toString() +"\n Skor " + scores.get(size-1).score.toString()
                tvBelum.visibility = View.INVISIBLE
                tvSkor1.visibility = View.VISIBLE
                tvSkor2.visibility = View.INVISIBLE
                tvSkor3.visibility = View.INVISIBLE
            }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var auth = FirebaseAuth.getInstance().currentUser
        val arrayListScore = ArrayList<UserScore>()
        val arrayListDate = ArrayList<UserScore>()

        btn_mulai_tes.setOnClickListener {
            val intent = Intent (getActivity(), ScreeningTestActivity::class.java)
            getActivity()?.startActivity(intent)
        }

        val myRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("UserScore")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                dataSnapshot.children.forEach {
                    val score = it.getValue<UserScore>()
                    val date = it.getValue<UserScore>()
                    if (score != null){
                        if (score.uid == auth!!.uid){
                            arrayListScore.add(score)
                        }
                        if (date?.uid == auth!!.uid){
                            arrayListDate.add(date)
                        }
                    }
                }
                getScore(arrayListScore, arrayListDate)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Gagal", "Failed to read value.", error.toException())
            }
        })
    }

}