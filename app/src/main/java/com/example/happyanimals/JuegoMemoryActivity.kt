package com.example.happyanimals

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.random.Random


class JuegoMemoryActivity : AppCompatActivity() {

   // var tv_p1: TextView? = null
   // var tv_p2: TextView? = null


    var question1: ImageView? = null
    var question2: ImageView? = null
    var question3: ImageView? = null
    var question4: ImageView? = null
    var question5: ImageView? = null
    var question6: ImageView? = null
    var question7: ImageView? = null
    var question8: ImageView? = null
    var question9: ImageView? = null
    var question10: ImageView? = null
    var question11: ImageView? = null
    var question12: ImageView? = null

    //array de imagenes
   // var cartasArray1 =
    var cartasArray = arrayOf(101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206)

    //imagenes actuales
    var image101 = 0
    var image102 = 0
    var image103 = 0
    var image104 = 0
    var image105 = 0
    var image106 = 0
    var image201 = 0
    var image202 = 0
    var image203 = 0
    var image204 = 0
    var image205 = 0
    var image206 = 0
    var firstCard = 0
    var secondCard = 0
    var clickedFirst = 0
    var clickedSecond = 0
    var cardNumber = 1
   // var turn = 1
 //   var playerPoints = 0
  //  var cpuPoints = 0
   //Sonidos animales recogidos en variables
//   val sBurro = R.raw.burro
    val sGato = R.raw.gato
    val sPerro = R.raw.perro
    val sOveja = R.raw.oveja
    val sGallo = R.raw.gallo
    val sPato = R.raw.pato
    val sVaca = R.raw.vaca
  //  val sCerdo = R.raw.cerdo

    private lateinit var mediaPlayer101: MediaPlayer
    private lateinit var mediaPlayer102: MediaPlayer
    private lateinit var mediaPlayer103: MediaPlayer
    private lateinit var mediaPlayer104: MediaPlayer
    private lateinit var mediaPlayer105: MediaPlayer
    private lateinit var mediaPlayer106: MediaPlayer

    private lateinit var mediaPlayer201: MediaPlayer
    private lateinit var mediaPlayer202: MediaPlayer
    private lateinit var mediaPlayer203: MediaPlayer
    private lateinit var mediaPlayer204: MediaPlayer
    private lateinit var mediaPlayer205: MediaPlayer
    private lateinit var mediaPlayer206: MediaPlayer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_memory)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
       // tv_p1 = findViewById<View>(R.id.tv_p1) as TextView
       // tv_p2 = findViewById<View>(R.id.tv_p2) as TextView
        cartasArray.shuffle()
        crearJuego()

        val botonRecarga = findViewById<ImageButton>(R.id.preguntasonido3)
        botonRecarga.visibility = View.INVISIBLE

    }

    private fun crearJuego(){

     /*   val rndn = (1..7).random()
        //barajar imagenes

        for(i in 0..rndn){
            cartasArray.shuffle()
        }*/





        question1 = findViewById<View>(R.id.question1) as ImageView
        question2 = findViewById<View>(R.id.question2) as ImageView
        question3 = findViewById<View>(R.id.question3) as ImageView
        question4 = findViewById<View>(R.id.question4) as ImageView
        question5 = findViewById<View>(R.id.question5) as ImageView
        question6 = findViewById<View>(R.id.question6) as ImageView
        question7 = findViewById<View>(R.id.question7) as ImageView
        question8 = findViewById<View>(R.id.question8) as ImageView
        question9 = findViewById<View>(R.id.question9) as ImageView
        question10 = findViewById<View>(R.id.question10) as ImageView
        question11 = findViewById<View>(R.id.question11) as ImageView
        question12 = findViewById<View>(R.id.question12) as ImageView
        question1!!.tag = "0"
        question2!!.tag = "1"
        question3!!.tag = "2"
        question4!!.tag = "3"
        question5!!.tag = "4"
        question6!!.tag = "5"
        question7!!.tag = "6"
        question8!!.tag = "7"
        question9!!.tag = "8"
        question10!!.tag = "9"
        question11!!.tag = "10"
        question12!!.tag = "11"

        //cargar las imagenes de las cartas
        frontOfCardsResources()




        question1!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question1, theCard)
        }
        question2!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question2, theCard)
        }
        question3!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question3, theCard)
        }
        question4!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question4, theCard)
        }
        question5!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question5, theCard)
        }
        question6!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question6, theCard)
        }
        question7!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question7, theCard)
        }
        question8!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question8, theCard)
        }
        question9!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question9, theCard)
        }
        question10!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question10, theCard)
        }
        question11!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question11, theCard)
        }
        question12!!.setOnClickListener { v ->
            val theCard: Int = Integer.parseInt(v.tag as String?)
            doStuff(question12, theCard)
        }
    }

    private fun doStuff(iv: ImageView?, card: Int) {
        if (cardNumber == 2) {
            stopSounds()
        }

        // imagen correcta con el imagen view
        if (cartasArray[card] == 101) {
            mediaPlayer101.start()
            iv!!.setImageResource(image101)
        } else if (cartasArray[card] == 102) {
            mediaPlayer102.start()
            iv!!.setImageResource(image102)
        } else if (cartasArray[card] == 103) {
            mediaPlayer103.start()
            iv!!.setImageResource(image103)
        } else if (cartasArray[card] == 104) {
            mediaPlayer104.start()
            iv!!.setImageResource(image104)
        } else if (cartasArray[card] == 105) {
            mediaPlayer105.start()
            iv!!.setImageResource(image105)
        } else if (cartasArray[card] == 106) {
            mediaPlayer106.start()
            iv!!.setImageResource(image106)
        } else if (cartasArray[card] == 201) {
            mediaPlayer101.start()
            iv!!.setImageResource(image201)
        } else if (cartasArray[card] == 202) {
            mediaPlayer102.start()
            iv!!.setImageResource(image202)
        } else if (cartasArray[card] == 203) {
            mediaPlayer103.start()
            iv!!.setImageResource(image203)
        } else if (cartasArray[card] == 204) {
            mediaPlayer104.start()
            iv!!.setImageResource(image204)
        } else if (cartasArray[card] == 205) {
            mediaPlayer105.start()
            iv!!.setImageResource(image205)
        } else if (cartasArray[card] == 206) {
            mediaPlayer106.start()
            iv!!.setImageResource(image206)
        }

        //comprobar imagen seleccionada y guardarla temporalmente
        if (cardNumber == 1) {
            firstCard = cartasArray[card]
            if (firstCard > 200) {
                firstCard = firstCard - 100
            }
            cardNumber = 2
            clickedFirst = card
            iv!!.isEnabled = false
        } else if (cardNumber == 2) {

            secondCard = cartasArray[card]
            if (secondCard > 200) {
                secondCard = secondCard - 100
            }
            cardNumber = 1
            clickedSecond = card
            question1!!.isEnabled = false
            question2!!.isEnabled = false
            question3!!.isEnabled = false
            question4!!.isEnabled = false
            question5!!.isEnabled = false
            question6!!.isEnabled = false
            question7!!.isEnabled = false
            question8!!.isEnabled = false
            question9!!.isEnabled = false
            question10!!.isEnabled = false
            question11!!.isEnabled = false
            question12!!.isEnabled = false
            val handler = Handler()
            handler.postDelayed({ //comprobar si la imagen seleccionada es igual
                calculate()
            }, 1000)
            //stopSounds();
        }
    }

    private fun calculate() {
        //Si la imagen es igual borrar la carta
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                question1!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 1) {
                question2!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 2) {
                question3!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 3) {
                question4!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 4) {
                question5!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 5) {
                question6!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 6) {
                question7!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 7) {
                question8!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 8) {
                question9!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 9) {
                question10!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 10) {
                question11!!.visibility = View.INVISIBLE
            } else if (clickedFirst == 11) {
                question12!!.visibility = View.INVISIBLE
            }


            if (clickedSecond == 0) {
                question1!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 1) {
                question2!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 2) {
                question3!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 3) {
                question4!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 4) {
                question5!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 5) {
                question6!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 6) {
                question7!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 7) {
                question8!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 8) {
                question9!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 9) {
                question10!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 10) {
                question11!!.visibility = View.INVISIBLE
            } else if (clickedSecond == 11) {
                question12!!.visibility = View.INVISIBLE
            }


        } else {
            question1!!.setImageResource(R.drawable.cartajuego)
            question2!!.setImageResource(R.drawable.cartajuego)
            question3!!.setImageResource(R.drawable.cartajuego)
            question4!!.setImageResource(R.drawable.cartajuego)
            question5!!.setImageResource(R.drawable.cartajuego)
            question6!!.setImageResource(R.drawable.cartajuego)
            question7!!.setImageResource(R.drawable.cartajuego)
            question8!!.setImageResource(R.drawable.cartajuego)
            question9!!.setImageResource(R.drawable.cartajuego)
            question10!!.setImageResource(R.drawable.cartajuego)
            question11!!.setImageResource(R.drawable.cartajuego)
            question12!!.setImageResource(R.drawable.cartajuego)
            //cambiar el turno de jugadores
           /* if (turn == 1) {
                turn = 2
                tv_p1!!.setTextColor(Color.GRAY)
                tv_p2!!.setTextColor(Color.BLUE)
            } else if (turn == 2) {
                turn = 1
                tv_p1!!.setTextColor(Color.GRAY)
                tv_p2!!.setTextColor(Color.BLUE)
            }*/


        }
        question1!!.isEnabled = true
        question2!!.isEnabled = true
        question3!!.isEnabled = true
        question4!!.isEnabled = true
        question5!!.isEnabled = true
        question6!!.isEnabled = true
        question7!!.isEnabled = true
        question8!!.isEnabled = true
        question9!!.isEnabled = true
        question10!!.isEnabled = true
        question11!!.isEnabled = true
        question12!!.isEnabled = true
        stopSounds()
        checkEnd();
    }

    private fun stopSounds(){
        if(mediaPlayer101.isPlaying){
            mediaPlayer101.pause()
        }
        if(mediaPlayer102.isPlaying){
            mediaPlayer102.pause()
        }
        if(mediaPlayer103.isPlaying){
            mediaPlayer103.pause()
        }
        if(mediaPlayer104.isPlaying){
            mediaPlayer104.pause()
        }
        if(mediaPlayer105.isPlaying){
            mediaPlayer105.pause()
        }
        if(mediaPlayer106.isPlaying){
            mediaPlayer106.pause()
        }

    }

    private fun checkEnd() {
        if (question1!!.visibility == View.INVISIBLE && question2!!.visibility == View.INVISIBLE && question3!!.visibility == View.INVISIBLE && question4!!.visibility == View.INVISIBLE && question5!!.visibility == View.INVISIBLE && question6!!.visibility == View.INVISIBLE && question7!!.visibility == View.INVISIBLE && question8!!.visibility == View.INVISIBLE && question9!!.visibility == View.INVISIBLE && question10!!.visibility == View.INVISIBLE && question11!!.visibility == View.INVISIBLE && question12!!.visibility == View.INVISIBLE) {

            val botonBien2 = findViewById<ImageView>(R.id.imageOk)
            botonBien2.visibility = View.VISIBLE

            val botonRecarga = findViewById<ImageButton>(R.id.preguntasonido3)
            botonRecarga.visibility = View.VISIBLE

        }
    }

    private fun frontOfCardsResources() {

      //  val sonidos = mutableListOf(sPerro,sGato,sPato,sOveja,sVaca,sBurro,sCerdo,sGallo)

        image101 = R.drawable.dogcard
        mediaPlayer101 = MediaPlayer.create(this, sPerro)

        image102 = R.drawable.catcard
        mediaPlayer102 = MediaPlayer.create(this, sGato)

        image103 = R.drawable.cowcard
        mediaPlayer103 = MediaPlayer.create(this, sVaca)

        image104 = R.drawable.duckcard
        mediaPlayer104 = MediaPlayer.create(this, sPato)

        image105 = R.drawable.chickencard
        mediaPlayer105 = MediaPlayer.create(this, sGallo)

        image106 = R.drawable.sheepcard
        mediaPlayer106 = MediaPlayer.create(this, sOveja)

        image201 = R.drawable.dogcard
        mediaPlayer201 = MediaPlayer.create(this, sPerro)

        image202 = R.drawable.catcard
        mediaPlayer202 = MediaPlayer.create(this, sGato)

        image203 = R.drawable.cowcard
        mediaPlayer203 = MediaPlayer.create(this, sVaca)

        image204 = R.drawable.duckcard
        mediaPlayer204 = MediaPlayer.create(this, sPato)

        image205 = R.drawable.chickencard
        mediaPlayer205 = MediaPlayer.create(this, sGallo)

        image206 = R.drawable.sheepcard
        mediaPlayer206 = MediaPlayer.create(this, sOveja)


    }
    fun returnVolver(view: View){
        mediaPlayer101.stop()
        mediaPlayer102.stop()
        mediaPlayer103.stop()
        mediaPlayer104.stop()
        mediaPlayer105.stop()
        mediaPlayer106.stop()

        mediaPlayer201.stop()
        mediaPlayer202.stop()
        mediaPlayer203.stop()
        mediaPlayer204.stop()
        mediaPlayer205.stop()
        mediaPlayer206.stop()

        irPantallaMenuJuegos()
    }

    fun irPantallaMenuJuegos() {
        val pantallaMenuJuegos = Intent(this, MenuJuegosActivity::class.java)
        startActivity(pantallaMenuJuegos)
        mediaPlayer = MediaPlayer.create(this, R.raw.musicafondo)
        mediaPlayer.start()
    }
    fun recargaDePantalla(view: View){
        val pantallaJuegoMemoria = Intent ( this, JuegoMemoryActivity::class.java)
        startActivity(pantallaJuegoMemoria)
    }


}