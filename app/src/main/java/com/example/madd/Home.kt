package com.example.madd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madd.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.computingbtntemp.setOnClickListener {
            val intent = Intent (this,computing::class.java)
            startActivity(intent)
        }

        binding.profilepic.setOnClickListener {
            val intent = Intent (this,Dashboard_user::class.java)
            startActivity(intent)
        }

        binding.navDow.setOnClickListener {
            val intent = Intent (this,Downloads::class.java)
            startActivity(intent)
        }
        binding.navFav.setOnClickListener {
            val intent = Intent (this,Favourites::class.java)
            startActivity(intent)
        }
    }
}