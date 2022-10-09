package com.example.madd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madd.databinding.ActivityComputingBinding
import com.example.madd.databinding.ActivityDashboardUserBinding

class computing : AppCompatActivity() {
    private lateinit var binding: ActivityComputingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComputingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pythonbutton.setOnClickListener {
            val intent = Intent (this, UserBookItemView::class.java)
            startActivity(intent)
        }


    }


}