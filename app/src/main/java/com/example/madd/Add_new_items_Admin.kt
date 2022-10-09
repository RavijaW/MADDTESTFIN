package com.example.madd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madd.databinding.ActivityDashboardAdminBinding


class Add_new_items_Admin : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardAdminBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_add_new_items_admin)
    }
}