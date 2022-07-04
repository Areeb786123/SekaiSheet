package com.areeb.sekaisheet.Activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.areeb.sekaisheet.MainActivity
import com.areeb.sekaisheet.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            var splashIntent = Intent(this,MainActivity::class.java)
            startActivity(splashIntent)
        },1500)
    }
}