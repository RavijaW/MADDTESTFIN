package com.example.madd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash1)

        Handler().postDelayed(Runnable {
            startActivity(Intent(this,SplashActivity::class.java))

        },2000) //2 second delay in splash screen
    }
}