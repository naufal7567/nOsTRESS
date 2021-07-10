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
import kotlinx.android.synthetic.main.fragment_account.*
import org.nostress.behappy.LoginActivity
import org.nostress.behappy.R
import org.nostress.behappy.UserStress


class AccountFragment : Fragment() {
    //(val mCtx : Context, val layoutResId : Int, val userStressList: List<UserStress>) : ArrayAdapter<UserStress>(mCtx,layoutResId, userStressList) {
// (REFERENSI Lukman)

//    lateinit var auth : FirebaseAuth
//    var dataReference : DatabaseReference? = null
//    var database : FirebaseDatabase? = null


//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val LayoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
//
//        val view : View = LayoutInflater.inflate(layoutResId, null)
//
//        val txt_username_account : TextView =  view.findViewById(R.id.txt_email_account)
//        val txt_email_account : TextView =  view.findViewById(R.id.txt_email_account)
//
//        val userStress : UserStress = userStressList [position]
//
//        txt_username_account.text = userStress.username_edittext_register
//        txt_email_account.text = userStress.email_edittext_register
//
//        return view
//    }
// (REFERENSI Lukman)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        auth = FirebaseAuth.getInstance()
//        database = FirebaseDatabase.getInstance()
//        dataReference = database?.getReference("profil")
//
//        loadProfil()
//
        val myRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("UserStress")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(UserStress::class.java)
                Log.d("Success", "Value is: $value")
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