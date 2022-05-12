package com.example.happyanimals

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class pruebakt : AppCompatActivity(){

    var tv_1: TextView? = null
    var tv_2:TextView? = null
    var tv_3:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_memory)
    }
}