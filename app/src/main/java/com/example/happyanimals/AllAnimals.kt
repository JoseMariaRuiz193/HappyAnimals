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
        val sonidoCerdo =  R.raw.cerdo
        val nombreCerdo = R.drawable.pig
        val pigVoz = R.raw.pigvoz
       val couplepig = R.raw.couplepig
        img.setImageResource(source1)
        img.setOnClickListener{ pulsarAnimal(source1, "fade1",sonidoCerdo,nombreCerdo, pigVoz, couplepig)
        }


        val img3 = findViewById<ImageView>(R.id.imageButtonVaca)
        val source3 = R.drawable.vaca
        val sonidoVaca = R.raw.vaca
        val nombreVaca = R.drawable.cow
        val cowVoz = R.raw.cowvoz
         val couplecow = R.raw.couplecow
        img3.setImageResource(source3)
        img3.setOnClickListener{
            pulsarAnimal(source3, "fade3", sonidoVaca, nombreVaca,cowVoz,couplecow)
        }
        val img4 = findViewById<ImageView>(R.id.imageButtonPerro)
        val source4 = R.drawable.perro
        val sonidoPerro = R.raw.perro
        val nombrePerro = R.drawable.dog
        val dogVoz = R.raw.dogvoz
        val coupledog = R.raw.coupledog
        img4.setImageResource(source4)
        img4.setOnClickListener{
            pulsarAnimal(source4, "fade4", sonidoPerro, nombrePerro, dogVoz,coupledog)
        }
        val img5 = findViewById<ImageView>(R.id.imageButtonGato)
        val source5 = R.drawable.gato
        val sonidoGato =  R.raw.gato
        val nombreGato = R.drawable.cat
        val catVoz = R.raw.catvoz
        val couplecat = R.raw.couplecat
        img5.setImageResource(source5)
        img5.setOnClickListener{
            pulsarAnimal(source5, "fade5", sonidoGato, nombreGato, catVoz,couplecat)
        }
        val img6 = findViewById<ImageView>(R.id.imageButtonPato)
        val source6 = R.drawable.pato
        val sonidoPato = R.raw.pato
        val nombrePato = R.drawable.duck
        val duckVoz = R.raw.duckvoz
        val coupleduck = R.raw.coupleduck
        img6.setImageResource(source6)
        img6.setOnClickListener{
            pulsarAnimal(source6, "fade6", sonidoPato, nombrePato,duckVoz, coupleduck)
        }
        val img7 = findViewById<ImageView>(R.id.imageButtonBurro)
        val source7 = R.drawable.burro
        val sonidoBurro = R.raw.burro
        val nombreBurro = R.drawable.donkey
        val donkeyVoz = R.raw.donkeyvoz
        val coupledonkey = R.raw.coupledonkey
        img7.setImageResource(source7)
        img7.setOnClickListener{
            pulsarAnimal(source7, "fade7", sonidoBurro, nombreBurro, donkeyVoz, coupledonkey)
        }
        val img8 = findViewById<ImageView>(R.id.imageButtonGallo)
        val source8 = R.drawable.gallo
        val sonidoGallo = R.raw.gallo
        val nombreGallo = R.drawable.rooster
        val roosterVoz = R.raw.roostervoz
        val couplerooster = R.raw.couplerooster
        img8.setImageResource(source8)
        img8.setOnClickListener{
            pulsarAnimal(source8, "fade8", sonidoGallo, nombreGallo, roosterVoz, couplerooster)
        }
        val img9 = findViewById<ImageView>(R.id.imageButtonOveja)
        val source9 = R.drawable.oveja
        val sonidoOveja = R.raw.oveja
        val nombreOveja = R.drawable.sheep
        val sheepVoz = R.raw.sheepvoz
        val couplesheep = R.raw.couplesheep
        img9.setImageResource(source9)
        img9.setOnClickListener{
            pulsarAnimal(source9, "fade9", sonidoOveja, nombreOveja, sheepVoz, couplesheep)
        }


    }



    fun pulsarAnimal (a:Int, b: String, c: Int, d: Int, e: Int, f: Int) {
        val pantallaTeoriaSonidos = Intent(this, TeoriaSonidos::class.java)
        pantallaTeoriaSonidos.putExtra( "data", a)
        pantallaTeoriaSonidos.putExtra( "data2", b)
        pantallaTeoriaSonidos.putExtra( "sonido", c)
        pantallaTeoriaSonidos.putExtra( "nombresAnimals", d)
        pantallaTeoriaSonidos.putExtra( "soundVoz", e)
        pantallaTeoriaSonidos.putExtra("coupleSound", f)
        mediaPlayer.pause()

        startActivity(pantallaTeoriaSonidos)
    }

    fun returnVolver(view: View){
        irPantallaJuegoSonidos()
        mediaPlayer = MediaPlayer.create(this, R.raw.musicafondo)
        mediaPlayer.start()
    }

    fun irPantallaJuegoSonidos() {
        val pantallaJuegoSonidos = Intent(this, MainActivity2::class.java)
        pantallaJuegoSonidos.putExtra("musica", 1)
        startActivity(pantallaJuegoSonidos)
    }

}