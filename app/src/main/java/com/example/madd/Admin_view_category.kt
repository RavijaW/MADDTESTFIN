package com.example.madd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madd.databinding.ActivityAdminViewCategoryBinding
import com.example.madd.databinding.ActivityComputingBinding


class Admin_view_category : AppCompatActivity() {
    private lateinit var binding: ActivityAdminViewCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminViewCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.computingcat.setOnClickListener {
            val intent = Intent (this, Admin_Computing::class.java)
            startActivity(intent)
        }
    }
}