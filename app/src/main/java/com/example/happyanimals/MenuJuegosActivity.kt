package com.example.happyanimals

import android.content.Intent
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
    fun returnVolver(view: View){
        irPantallaJuegoSonidos()
    }

    fun irPantallaJuegoSonidos() {
        val pantallaJuegoSonidos = Intent(this, MainActivity2::class.java)
        startActivity(pantallaJuegoSonidos)
    }

}