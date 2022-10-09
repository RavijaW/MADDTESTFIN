package com.example.madd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash2)

        Handler().postDelayed(Runnable {
            startActivity(Intent(this,MainActivity::class.java))

        },2000) //2 second delay in splash screen
    }
}