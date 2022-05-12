package com.example.happyanimals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView

class JuegoMemoryActivity : AppCompatActivity() {

    private lateinit var textView1: TextView
    private lateinit var textView2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_memory)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)

    }

    fun returnVolver(view: View){
        irPantallaJuegoSonidos()
    }

    fun irPantallaJuegoSonidos() {
        val pantallaJuegoSonidos = Intent(this, MenuJuegosActivity::class.java)
        startActivity(pantallaJuegoSonidos)
    }
}