package com.example.happyanimals

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class JuegoImagenSonido : AppCompatActivity() {

   // private lateinit var playButton: ImageButton
    private lateinit var mediaPlayer2: MediaPlayer
    private lateinit var mediaPlayerGood: MediaPlayer
    private lateinit var mediaPlayerBad: MediaPlayer
    //Imagenes animales recogidas en variables
    val i1 = R.drawable.burro
    val i2 = R.drawable.gato
    val i3 = R.drawable.perro
    val i4 = R.drawable.oveja
    val i5 = R.drawable.gallo
    val i6 = R.drawable.pato
    val i7 = R.drawable.vaca
    val i8 = R.drawable.cerdo
    //Sonidos animales recogidos en variables
    val s1 = R.raw.burro
    val s2 = R.raw.gato
    val s3 = R.raw.perro
    val s4 = R.raw.oveja
    val s5 = R.raw.gallo
    val s6 = R.raw.pato
    val s7 = R.raw.vaca
    val s8 = R.raw.cerdo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_imagen_sonido)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        crearJuego()
        mediaPlayer2.start()
        val botonRecarga = findViewById<ImageButton>(R.id.preguntasonido2)
        botonRecarga.visibility = View.INVISIBLE
    }

    private fun error() {
        /*val builder = AlertDialog.Builder(this)
        builder.setTitle("INCORRECTO")
        builder.setMessage("PRUEBA OTRA VEZ")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()*/
        mediaPlayerBad = MediaPlayer.create(this, R.raw.soundbad)
        mediaPlayerBad.start()

    }

    private fun acierto() {
        /*val builder = AlertDialog.Builder(this)
        builder.setTitle("CORRECTO")
        builder.setMessage("HAS ACERTADO!")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()*/

        mediaPlayerGood = MediaPlayer.create(this, R.raw.soundgood)
        mediaPlayerGood.start()
        val botonRecarga = findViewById<ImageButton>(R.id.preguntasonido2)
        botonRecarga.visibility = View.VISIBLE
        val botonAudio = findViewById<ImageButton>(R.id.preguntasonido)
        botonAudio.visibility = View.INVISIBLE
    }

    private fun crearJuego() {
        val imagenes = mutableListOf(i1,i2,i3,i4,i5,i6,i7,i8)
        val sonidos = mutableListOf(s1,s2,s3,s4,s5,s6,s7,s8)

        //ocultar boton de recarga de pantalla
        val botonRecarga = findViewById<ImageButton>(R.id.preguntasonido2)
        botonRecarga.visibility = View.INVISIBLE

        val botonAudio = findViewById<ImageButton>(R.id.preguntasonido)
        botonAudio.visibility = View.VISIBLE

        //ocultar imagenes bien y mal

        val botonBien1 = findViewById<ImageView>(R.id.imageOk1)
        botonBien1.visibility = View.INVISIBLE

        val botonBien2 = findViewById<ImageView>(R.id.imageOk2)
        botonBien2.visibility = View.INVISIBLE

        val botonBien3 = findViewById<ImageView>(R.id.imageOk3)
        botonBien3.visibility = View.INVISIBLE

        val botonMal1 = findViewById<ImageView>(R.id.imageNo1)
        botonMal1.visibility = View.INVISIBLE

        val botonMal2 = findViewById<ImageView>(R.id.imageNo2)
        botonMal2.visibility = View.INVISIBLE


        val botonMal3 = findViewById<ImageView>(R.id.imageNo3)
        botonMal3.visibility = View.INVISIBLE


        //coger sonido aleatorio y colocarlo

        val rnds = (0..7).random()

        val imagencogida = imagenes.get(rnds)
        // imagenes= imagencogida
        val sonidoRecogido = sonidos.get(rnds)

        val preguntasonido = findViewById<ImageView>(R.id.preguntasonido)
        //preguntasonido.setImageResource(imagencogida)
        if(sonidoRecogido != 0)
            mediaPlayer2 = MediaPlayer.create(this, sonidoRecogido)


        preguntasonido.setOnClickListener{
            mediaPlayer2.start()
        }

        //Colocar imagenes en opciones

        val opcion1 = findViewById<ImageView>(R.id.imageopcion1)
        val opcion2 = findViewById<ImageView>(R.id.imageopcion2)
        val opcion3 = findViewById<ImageView>(R.id.imageopcion3)
        val opciones = mutableListOf(opcion1,opcion2,opcion3)

        //Colocar imagen buena en opcion aleatoria
        val opcale = (0..2).random()
        val opcioncogida = opciones.get(opcale)
        opcioncogida.setImageResource(imagencogida)
        imagenes.removeAt(rnds)
        opciones.removeAt(opcale)

        //Rellenar otras dos opciones con imagenes idferentes y posiciones diferentes
        val opcale1= (0..1).random()
        val rnds1= (0..6).random()
        val imagencogida1 = imagenes.get(rnds1)
        val opcioncogida1 = opciones.get(opcale1)
        opcioncogida1.setImageResource(imagencogida1)
        imagenes.removeAt(rnds1)
        opciones.removeAt(opcale1)


        val opcale2= (0)
        val rnds2= (0..5).random()
        val imagencogida2 = imagenes.get(rnds2)
        val opcioncogida2 = opciones.get(opcale2)
        opcioncogida2.setImageResource(imagencogida2)

        opcion1.setOnClickListener{
            if (opcioncogida==opcion1){
                acierto()
                val botonBien1 = findViewById<ImageView>(R.id.imageOk1)
                botonBien1.visibility = View.VISIBLE
                //crearJuego()

            }else{
                error()
                val botonMal1 = findViewById<ImageView>(R.id.imageNo1)
                botonMal1.visibility = View.VISIBLE
            }
        }
        opcion2.setOnClickListener{
            if (opcioncogida==opcion2){
                acierto()
                val botonBien2 = findViewById<ImageView>(R.id.imageOk2)
                botonBien2.visibility = View.VISIBLE
                //crearJuego()
            }else{
                error()
                val botonMal2 = findViewById<ImageView>(R.id.imageNo2)
                botonMal2.visibility = View.VISIBLE
            }
        }
        opcion3.setOnClickListener{
            if (opcioncogida==opcion3){
                acierto()
                val botonBien3 = findViewById<ImageView>(R.id.imageOk3)
                botonBien3.visibility = View.VISIBLE
            //crearJuego()
            }else{
                error()
                val botonMal3 = findViewById<ImageView>(R.id.imageNo3)
                botonMal3.visibility = View.VISIBLE
            }
        }

    }

    fun recargaDePantalla(view: View){
        crearJuego()
        mediaPlayer2.start()
    }

    fun returnVolver(view: View){
        mediaPlayerBad.stop()
        mediaPlayerGood.stop()
        mediaPlayer2.stop()
        irPantallaMenuJuegos()
    }

    fun irPantallaMenuJuegos() {
        val pantallaMenuJuegos = Intent(this, MenuJuegosActivity::class.java)
        startActivity(pantallaMenuJuegos)
        mediaPlayer = MediaPlayer.create(this, R.raw.musicafondo)
        mediaPlayer.start()
    }
}
