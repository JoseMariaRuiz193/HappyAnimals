package com.example.happyanimals

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


    }

    fun onClickTeoriaSonidos(view: View){
        irPantallaTeoriaSonidos()
    }

    fun irPantallaTeoriaSonidos() {
        val pantallaTeoriaSonidos = Intent(this, TeoriaSonidos::class.java)
        startActivity(pantallaTeoriaSonidos)
    }

    fun onClickJuegoSonidos(view: View){
        irPantallaTeoriaSonidos()
    }

    fun irPantallaJuegoSonidos() {
        val pantallaJuegoSonidos = Intent(this, JuegoSonidos::class.java)
        startActivity(pantallaJuegoSonidos)
    }
}