package com.example.madd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madd.databinding.ActivityDashboardAdminBinding
import com.example.madd.databinding.ActivityDashboardUserBinding

class Dashboard_user : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.profileUserbtn.setOnClickListener {
            val intent = Intent (this, UserProfile_edit::class.java)
            startActivity(intent)
        }

        binding.settingdbtn.setOnClickListener {
            val intent = Intent (this, UserProfile_settings::class.java)
            startActivity(intent)
        }

        binding.securitybtn.setOnClickListener {
            val intent = Intent (this, UserProfile_security::class.java)
            startActivity(intent)
        }

        binding.logoutuserbtn.setOnClickListener {
            val intent = Intent (this, UserProfile_Logout::class.java)
            startActivity(intent)
        }
    }
}