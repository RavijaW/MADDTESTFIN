package com.example.madd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madd.databinding.ActivityDashboardAdminBinding
import com.google.firebase.auth.FirebaseAuth

class Dashboard_admin : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardAdminBinding

    //  private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //firebase Aut
        //  firebaseAuth = FirebaseAuth.getInstance()
        //  checkUser()

        //logout
        // binding.logoutAdminbtn.setOnClickListener {
        //     firebaseAuth.signOut()
        //     checkUser()
        //}

        //go to add items
         binding.addItemBtnAdmin.setOnClickListener {
             val intent = Intent (this, Add_new_items_Admin::class.java)
             startActivity(intent)
        }

        binding.addCategoryAdmn.setOnClickListener {
            val intent = Intent (this, Add_new_category_admin::class.java)
            startActivity(intent)
        }
        binding.viewCategoriesbtnadmn.setOnClickListener {
            val intent = Intent (this, Admin_view_category::class.java)
            startActivity(intent)
        }

        binding.viewAdminProfileBtn.setOnClickListener {
            val intent = Intent (this, Admin_profile::class.java)
            startActivity(intent)
        }









    }



    private fun checkUser() {
        //get current user
        //val firebaseUser = firebaseAuth.currentUser
        //if(firebaseUser == null){
        //    startActivity(Intent(this,MainActivity::class.java))
        // }
        //else{
        //  val email = firebaseUser.email

        //binding.adminEmail.text = email

        //}
        //}
    }
}

