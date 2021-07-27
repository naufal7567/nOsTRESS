package org.nostress.behappy.fragment_menu

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_account.*
import org.nostress.behappy.*
import org.nostress.behappy.EditUserActivity.Companion.EXTRA_DATA
import org.nostress.behappy.EditUserActivity.Companion.EXTRA_ID
import org.nostress.behappy.R
import java.io.ByteArrayOutputStream


class AccountFragment : Fragment() {

    private var user : UserStress? = null
    companion object{
        const val REQUEST_CAMERA = 100
    }
    private lateinit var imageUri : Uri

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user_img.setOnClickListener {
            intentCamera()
        }


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
                            profile.idUser = it.key.toString()
                            getUser(profile)
                            user = profile
//                            Log.d("gagal",profile.idUser)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Gagal", "Failed to read value.", error.toException())
            }
        })

        btn_edit_data.setOnClickListener {
            activity?.let {
                val intentEdit = Intent(it, EditUserActivity::class.java)
                intentEdit.putExtra(EXTRA_DATA, user)
                intentEdit.putExtra(EXTRA_ID, user!!.idUser)
                it.startActivity(intentEdit)
            }
        }

        btn_edit_password.setOnClickListener {
            activity?.let {
                val intentEdit = Intent(it, EditPasswordActivity::class.java)
                it.startActivity(intentEdit)
            }
        }

        btn_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            activity?.let{
                val intent = Intent(it, LoginActivity::class.java)
                it.startActivity(intent)
            }
        }
    }

    private fun getUser(profile:UserStress){
        txt_username_account.text = profile.firstname + " " + profile.lastname
        txt_alamat_account.text = profile.alamat
        txt_ttl_account.text = profile.tempat + " " + profile.tanggal
        txt_email_account.text = profile.email
        txt_telpon_account.text = profile.telepon
        Log.d("gagal",profile.idUser)
    }

    private fun intentCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {intent ->
            activity?.packageManager?.let { it1 ->
                intent.resolveActivity(it1).also {
                    startActivityForResult(intent, REQUEST_CAMERA)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK){
            val imgBitMap = data?.extras?.get("data") as Bitmap
            uploadImage(imgBitMap)
        }

    }

    private fun uploadImage(imgBitMap: Bitmap) {
        val baos = ByteArrayOutputStream()
        val ref = FirebaseStorage.getInstance().reference.child("img/${FirebaseAuth.getInstance().currentUser?.uid}")

        imgBitMap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val image = baos.toByteArray()

        ref.putBytes(image)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        ref.downloadUrl.addOnCompleteListener {
                            it.result?.let {
                                imageUri = it
                                user_img.setImageBitmap(imgBitMap)
                            }
                        }
                    }
                }
    }
}