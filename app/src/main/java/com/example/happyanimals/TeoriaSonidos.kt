package com.example.happyanimals

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView


class TeoriaSonidos : Activity() {


    private lateinit var playButton: ImageButton
    private lateinit var playButton2: ImageButton
    private lateinit var playButton3: ImageButton
    private lateinit var mediaPlayer: MediaPlayer
   private lateinit var mediaPlayer2: MediaPlayer
    private lateinit var mediaPlayer3: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teoria_sonidos)
        val img= findViewById<ImageButton>(R.id.playButton)
        val cajaNombre = findViewById<ImageView>(R.id.textViewNombreAnimal)
        var sonidoRecogido = 0
        var soundVoz = 0
        var coupleSound = 0
        val extras = intent.getExtras()
        if(extras !=null ){
            val last_pictures : Int = extras?.getInt("data")!!
            val last_pictures2 : Int = extras?.getInt("nombresAnimals")!!
            val transName : String = extras?.getString( "data2", "")!!
            sonidoRecogido = extras?.getInt( "sonido", 0)!!
            soundVoz = extras?.getInt( "soundVoz", 0)!!
            coupleSound = extras?.getInt( "coupleSound", 0)!!
           // val nombreAnimal : String = extras?.getString( "nombresAnimals", "")
            if(last_pictures != null && transName != "" && last_pictures2 !=null){
                img.setImageResource(last_pictures)
                cajaNombre.setImageResource(last_pictures2)
            }

            img.transitionName = transName
        }
        playButton = findViewById(R.id.playButton)
        if(sonidoRecogido != 0)
            mediaPlayer3 = MediaPlayer.create(this, sonidoRecogido)

        setOnClickListeners(this)

        playButton2 = findViewById(R.id.volumenButton)
        if(coupleSound != 0)
            mediaPlayer = MediaPlayer.create(this, coupleSound)

        setOnClickListeners2(this)

        playButton3 = findViewById(R.id.playButton3)
        if(soundVoz != 0)
            mediaPlayer2 = MediaPlayer.create(this, soundVoz)
        setOnClickListeners3(this)
        //supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Pantalla flotante

        val ventana = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(ventana)

        val ancho = ventana.widthPixels * 0.9
        val alto = ventana.heightPixels *0.9

        window.setLayout(ancho.toInt(), alto.toInt())

    }
    private fun setOnClickListeners(context: Context) {
       playButton.setOnClickListener {
            mediaPlayer3.start()

        }


    }

    private fun setOnClickListeners2(context: Context) {
        playButton2.setOnClickListener {
            mediaPlayer.start()

        }


    }
   fun setOnClickListeners3(context: Context) {
        playButton3.setOnClickListener {
            mediaPlayer2.start()

        }


    }
    fun returnVolver(view: View){
        onBackPressed()

    }

    override fun onBackPressed(){
        super.onBackPressed()
      //  mediaPlayer.stop()
    }

    override fun onPause(){
        super.onPause()
        mediaPlayer.stop()
    }
}