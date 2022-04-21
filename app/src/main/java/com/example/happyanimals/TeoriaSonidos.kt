package com.example.happyanimals

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.Toast


class TeoriaSonidos : AppCompatActivity() {


    private lateinit var cerdoPlayButton: ImageButton
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teoria_sonidos)

        cerdoPlayButton = findViewById(R.id.cerdoPlayButton)
        mediaPlayer = MediaPlayer.create(this, R.raw.cerdo)

        setOnClickListeners(this)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
    private fun setOnClickListeners(context: Context) {
       cerdoPlayButton.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(context, "Reproduciendo...", Toast.LENGTH_SHORT).show()
        }


    }
}