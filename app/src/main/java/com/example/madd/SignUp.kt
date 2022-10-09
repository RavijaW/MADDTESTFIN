package com.example.madd

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.madd.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import android.util.Patterns.EMAIL_ADDRESS

class SignUp : AppCompatActivity() {

    private lateinit var binding:ActivitySignUpBinding

    //firebase auth

    private lateinit var firebaseAuth: FirebaseAuth

    //progress dialog
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog= ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setCanceledOnTouchOutside(false)

        //signup button
        binding.btnSignUp.setOnClickListener {
            validaedata()

        }
    }

    private var name =""
    private var email =""
    private var password =""

    private fun validaedata() {

        name = binding.nameET.text.toString().trim()
        email = binding.emailEt.text.toString().trim()
        password =binding.passwordEt1.text.toString().trim()
        val cPassword = binding.passwordet2.text.toString().trim()


//        Log.i("CLS_AAAA", "Hello World")
//
//        firebaseAuth.createUserWithEmailAndPassword("kamal@gmail.com","123555675")

        //validate data
        if (name.isEmpty()){
            Toast.makeText(this, "enter name", Toast.LENGTH_SHORT).show()
        }
//        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            Toast.makeText(this, "enter email", Toast.LENGTH_SHORT).show()
//        }
                else if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "enter email", Toast.LENGTH_SHORT).show()
        }



//        else if(email.isEmpty()){
//            Toast.makeText(this, "enter email", Toast.LENGTH_SHORT).show()
//        }
        else if(password.isEmpty()){
            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show()
        }

        else if(cPassword.isEmpty()){
            Toast.makeText(this, "confirm password ", Toast.LENGTH_SHORT).show()
        }

        else if(password != cPassword){
            Toast.makeText(this, "password does not match", Toast.LENGTH_SHORT).show()
        }

        else{
            createUserAccount()
        }


    }

    private  fun createUserAccount() {

        //progress text
        progressDialog.setMessage("creating Account")
        progressDialog.show()

        //firebase auth
         firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                updateUserInfo()


            }
            .addOnFailureListener {e->
                progressDialog.dismiss()
                Toast.makeText(this, "creating account failed : ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateUserInfo() {
        progressDialog.setMessage("saving user info")

        val timestamp = System.currentTimeMillis()

        //user id
        val uid = firebaseAuth.uid

        //set up data to add to db
        val hashMap:HashMap<String, Any?> = HashMap()
        hashMap["uid"] = uid
        hashMap["email"] = email
        hashMap["name"] = name
        hashMap["profileImage"] = ""
        hashMap["userType"] = "user"
        hashMap["timeStamp"] = timestamp

        //set data to db
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid!!)
            .setValue(hashMap)
            .addOnSuccessListener {
                progressDialog.dismiss()
                Toast.makeText(this,"Account created",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@SignUp,Dashboard_user::class.java))
                finish()

            }
            .addOnFailureListener { e->
                progressDialog.dismiss()
                Toast.makeText(this, "failed saving user info : ${e.message}", Toast.LENGTH_SHORT).show()

            }

    }

}