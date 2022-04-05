package com.example.happyanimals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    val DURACION: Long = 3000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Poner full la pantalla
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val logo = findViewById<ImageView>(R.id.giflogo)
        Glide.with(this).load(R.drawable.splash).into(logo)
        cambiarActivity()
    }

    private fun cambiarActivity(){
        Handler().postDelayed(Runnable {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        },DURACION)
    }
}