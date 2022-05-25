package com.example.happyanimals


import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

class MenuJuegosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_menu_juegos)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }

    fun onClickJuegoMemory(view: View) {
        val pantallaJuegoMemory = Intent ( this, JuegoMemoryActivity::class.java)
        startActivity(pantallaJuegoMemory)
    }
    fun onClickJuegoImagenSonido(view: View) {
        val pantallaJuegoSonido = Intent ( this, JuegoImagenSonido::class.java)
        startActivity(pantallaJuegoSonido)
    }
    fun returnVolver(view: View){
        irPantallaMenuJuegos()
        mediaPlayer = MediaPlayer.create(this, R.raw.musicafondo)
        mediaPlayer.start()
    }

    fun irPantallaMenuJuegos() {
        val pantallaJuegoSonidos = Intent(this, MainActivity2::class.java)
        startActivity(pantallaJuegoSonidos)
    }

}