package com.example.happyanimals

import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide
public  lateinit var mediaPlayer: MediaPlayer

class MainActivity : AppCompatActivity() {

    val DURACION: Long = 4500;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Poner full la pantalla
        supportActionBar?.hide()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }
        else{
            this.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        }
        val logo = findViewById<ImageView>(R.id.giflogo)
        Glide.with(this).load(R.drawable.splashhappyanimals).into(logo)
        cambiarActivity()

        mediaPlayer = MediaPlayer.create(this, R.raw.musicafondo)
        mediaPlayer.start()
    }

    private fun cambiarActivity(){
        Handler().postDelayed(Runnable {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        },DURACION)
    }
}