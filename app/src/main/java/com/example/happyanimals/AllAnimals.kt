package com.example.happyanimals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

class AllAnimals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_animals)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }

    fun onClickTeoriaSonidos(view: View) {
        irPantallaTeoriaSonidos()
    }
    fun irPantallaTeoriaSonidos() {
        val pantallaTeoriaSonidos = Intent(this, TeoriaSonidos::class.java)
        startActivity(pantallaTeoriaSonidos)
    }
}