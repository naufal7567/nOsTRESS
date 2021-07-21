package org.nostress.behappy.fragment_menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_account.*
import org.nostress.behappy.LoginActivity
import org.nostress.behappy.R
import org.nostress.behappy.UserStress


class AccountFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)

//        showAllData
//        showAllUserData();
    }
    private fun getUser(profile:UserStress){
        txt_username_account.text = profile.firstname + " " + profile.lastname
        txt_alamat_account.text = profile.alamat
        txt_ttl_account.text = profile.tempat + " " + profile.tanggal
        txt_email_account.text = profile.email
        txt_telpon_account.text = profile.telepon
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var auth = FirebaseAuth.getInstance().currentUser
//        database = FirebaseDatabase.getInstance()
//        dataReference = database?.getReference("profil")
//
//        loadProfil()

        val myRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("UserStress")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                dataSnapshot.children.forEach {
                    val profile = it.getValue<UserStress>()
                    if (profile != null){
                        if (profile.uid == auth!!.uid){
                            getUser(profile)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Gagal", "Failed to read value.", error.toException())
            }
        })
        btn_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            activity?.let{
                val intent = Intent(it, LoginActivity::class.java)
                it.startActivity(intent)
            }
        }
    }


//    private fun loadProfil(){
//        val user = auth.currentUser
//        val userRef = dataReference?.child(user?.uid!!)
//
//        userRef?.addValueEventListener(object: ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                txt_username_account.text = snapshot.child("username").value.toString()
//                txt_email_account.text = snapshot.child("email").value.toString()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })
//    }

}