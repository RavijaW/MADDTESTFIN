package com.example.madd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madd.databinding.ActivityDashboardAdminBinding

class Add_new_category_admin : AppCompatActivity() {

    private lateinit var binding : ActivityDashboardAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_category_admin)
    }
}