package com.example.happyanimals

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.ImageButton


class TeoriaSonidos : Activity() {


    private lateinit var playButton: ImageButton
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teoria_sonidos)
        val img= findViewById<ImageButton>(R.id.playButton)
        var sonidoRecogido = 0
        val extras = intent.getExtras()
        if(extras !=null ){
            val last_pictures : Int = extras?.getInt("data")
            val transName : String = extras?.getString( "data2", "")
            sonidoRecogido = extras?.getInt( "sonido", 0)
            if(last_pictures != null && transName != "")
                img.setImageResource(last_pictures)
            img.transitionName = transName
        }
        playButton = findViewById(R.id.playButton)
        if(sonidoRecogido != 0)
            mediaPlayer = MediaPlayer.create(this, sonidoRecogido)

        setOnClickListeners(this)
        //supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Pantalla flotante

        val ventana = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(ventana)

        val ancho = ventana.widthPixels * 0.8
        val alto = ventana.heightPixels *0.7

        window.setLayout(ancho.toInt(), alto.toInt())

    }
    private fun setOnClickListeners(context: Context) {
       playButton.setOnClickListener {
            mediaPlayer.start()

        }


    }

    override fun onBackPressed(){
        mediaPlayer.stop()
    }
}