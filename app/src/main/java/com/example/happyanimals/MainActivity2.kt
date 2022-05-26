package com.example.happyanimals

import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()

        val extras = intent.getExtras()
        if(extras !=null ){
            val venimosDeAbajo : Int = extras?.getInt("musica")!!
            if(venimosDeAbajo == 1){
             // no se crea nueva musica
            }
            else{
                mediaPlayer = MediaPlayer.create(this, R.raw.musicafondo)
                mediaPlayer.start()
            }
        }
        else{
            mediaPlayer = MediaPlayer.create(this, R.raw.musicafondo)
            mediaPlayer.start()
        }


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // HERE WE ARE TAKING THE REFERENCE OF OUR IMAGE
        // SO THAT WE CAN PERFORM ANIMATION USING THAT IMAGE
        val backgroundImage: ImageView = findViewById(R.id.SplashScreenImage2)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        backgroundImage.startAnimation(slideAnimation)

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.



        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }

    }

    fun onClickTeoriaSonidos(view: View){
        irPantallaTeoriaSonidos()
      //  mediaPlayer.stop()

    }

    fun irPantallaTeoriaSonidos() {
        val pantallaTeoriaSonidos = Intent(this, AllAnimals::class.java)

        startActivity(pantallaTeoriaSonidos)
        mediaPlayer.stop()

    }

    fun onClickJuegoSonidos(view: View){
        irPantallaJuegoSonidos()
     //   mediaPlayer.stop()

    }

    fun irPantallaJuegoSonidos() {
        val pantallaJuegoSonidos = Intent(this, MenuJuegosActivity::class.java)
        startActivity(pantallaJuegoSonidos)
     //   mediaPlayer.stop()

    }
}