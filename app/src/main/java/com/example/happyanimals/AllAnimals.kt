package com.example.happyanimals

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView

class AllAnimals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_animals)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        val img = findViewById<ImageView>(R.id.imageButtonCerdo)
        val source1 = R.drawable.cerdo
        img.setImageResource(source1)
        val sonidoCerdo =  R.raw.cerdo
        img.setOnClickListener{ pulsarAnimal(source1, "fade1",sonidoCerdo)  }


        val img2 = findViewById<ImageView>(R.id.imageButtonRana)
        val source2 = R.drawable.rana
        val sonidoRana =  R.raw.rana
        img2.setImageResource(source2)
        img2.setOnClickListener{
            pulsarAnimal(source2, "fade2", sonidoRana)
        }
        val img3 = findViewById<ImageView>(R.id.imageButtonVaca)
        val source3 = R.drawable.vaca
        val sonidoVaca = R.raw.vaca
        img3.setImageResource(source3)
        img3.setOnClickListener{
            pulsarAnimal(source3, "fade3", sonidoVaca)
        }
        val img4 = findViewById<ImageView>(R.id.imageButtonPerro)
        val source4 = R.drawable.perro
        val sonidoPerro = R.raw.perro
        img4.setImageResource(source4)
        img4.setOnClickListener{
            pulsarAnimal(source4, "fade4", sonidoPerro)
        }
        val img5 = findViewById<ImageView>(R.id.imageButtonGato)
        val source5 = R.drawable.gato
        val sonidoGato =  R.raw.gato
        img5.setImageResource(source5)
        img5.setOnClickListener{
            pulsarAnimal(source5, "fade5", sonidoGato)
        }
        val img6 = findViewById<ImageView>(R.id.imageButtonPato)
        val source6 = R.drawable.pato
        val sonidoPato = R.raw.patodonald
        img6.setImageResource(source6)
        img6.setOnClickListener{
            pulsarAnimal(source6, "fade6", sonidoPato)
        }
        val img7 = findViewById<ImageView>(R.id.imageButtonBurro)
        val source7 = R.drawable.burro
        val sonidoBurro = R.raw.burro
        img7.setImageResource(source7)
        img7.setOnClickListener{
            pulsarAnimal(source7, "fade7", sonidoBurro)
        }
        val img8 = findViewById<ImageView>(R.id.imageButtonGallo)
        val source8 = R.drawable.gallo
        val sonidoGallo = R.raw.gallo
        img8.setImageResource(source8)
        img8.setOnClickListener{
            pulsarAnimal(source8, "fade8", sonidoGallo)
        }
        val img9 = findViewById<ImageView>(R.id.imageButtonOveja)
        val source9 = R.drawable.oveja
        val sonidoOveja = R.raw.oveja
        img9.setImageResource(source9)
        img9.setOnClickListener{
            pulsarAnimal(source9, "fade9", sonidoOveja)
        }


    }

    fun pulsarAnimal ( a:Int, b : String, c : Int) {
        val pantallaTeoriaSonidos = Intent(this, TeoriaSonidos::class.java)
        pantallaTeoriaSonidos.putExtra( "data", a)
        pantallaTeoriaSonidos.putExtra( "data2", b)
        pantallaTeoriaSonidos.putExtra( "sonido", c)

        startActivity(pantallaTeoriaSonidos)
    }

    fun returnVolver(view: View){
        irPantallaJuegoSonidos()
    }

    fun irPantallaJuegoSonidos() {
        val pantallaJuegoSonidos = Intent(this, MainActivity2::class.java)
        startActivity(pantallaJuegoSonidos)
    }



}