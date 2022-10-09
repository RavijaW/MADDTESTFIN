package com.example.madd

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.madd.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.intellij.lang.annotations.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private lateinit var firebaseAuth: FirebaseAuth

    //progress dialog
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog= ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setCanceledOnTouchOutside(false)



        //handle click login
        binding.loginbtn.setOnClickListener {

            //valdateData()
        }

        //handle click continue to home
        binding.skipToHome.setOnClickListener {
            val intent =Intent(this,Home::class.java)
            startActivity(intent)

        }

        binding.signupbtn.setOnClickListener {
            val intent = Intent (this, SignUp::class.java)
            startActivity(intent)
        }
        binding.adminLogBtnTemp.setOnClickListener {
            val intent = Intent (this, Dashboard_admin::class.java)
            startActivity(intent)
        }
        binding.userLogBtnTemp.setOnClickListener {
            val intent = Intent (this, Home::class.java)
            startActivity(intent)
        }

    }
/*
    private var email=""
    private var password=""


    private fun valdateData() {
        email = binding.emailEt.text.toString().trim()
        password= binding.passwordEt.text.toString().trim()

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "invalid email type", Toast.LENGTH_SHORT).show()
        }
        else if (password.isEmpty()){
            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show()
        }
        else{
            loginuser()
        }

    }

    private fun loginuser() {

        progressDialog.setMessage("logging in")
        progressDialog.show()

        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                checkuser()

            }
            .addOnFailureListener {
                Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show()
            }

    }

    private fun checkuser() {
        progressDialog.setMessage("checking user")

        val firebaseUser = firebaseAuth.currentUser!!

        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseUser.uid)
            .addListenerForSingleValueEvent(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    progressDialog.dismiss()

                    //get user type user / admin
                    val userType = snapshot.child("userType").value

                    if (userType=="user"){
                        startActivity(Intent(this@MainActivity,Dashboard_user::class.java))
                        finish()

                    }
                    else if (userType=="admin"){
                        startActivity(Intent(this@MainActivity,Dashboard_admin::class.java))
                        finish()
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })

    }*/
}