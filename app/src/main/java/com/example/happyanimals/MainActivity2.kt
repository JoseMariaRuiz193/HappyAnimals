package com.example.happyanimals

import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager

class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }

        }

    fun onClickTeoriaSonidos(view: View){
        irPantallaTeoriaSonidos()
        mediaPlayer.stop()

    }

    fun irPantallaTeoriaSonidos() {
        val pantallaTeoriaSonidos = Intent(this, AllAnimals::class.java)
        startActivity(pantallaTeoriaSonidos)
        mediaPlayer.stop()

    }

    fun onClickJuegoSonidos(view: View){
        irPantallaJuegoSonidos()
        mediaPlayer.stop()

    }

    fun irPantallaJuegoSonidos() {
        val pantallaJuegoSonidos = Intent(this, MenuJuegosActivity::class.java)
        startActivity(pantallaJuegoSonidos)
        mediaPlayer.stop()

    }
}