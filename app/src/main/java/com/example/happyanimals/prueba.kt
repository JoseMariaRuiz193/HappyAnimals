package com.example.happyanimals

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.happyanimals.R
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.example.happyanimals.prueba
import java.util.*

class prueba : AppCompatActivity() {
    var tv_p1: TextView? = null
    var tv_p2: TextView? = null
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
    var turn = 1
    var playerPoints = 0
    var cpuPoints = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_memory)
      //  tv_p1 = findViewById<View>(R.id.tv_p1) as TextView
       // tv_p2 = findViewById<View>(R.id.tv_p2) as TextView
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

        //barajar imagenes
        Collections.shuffle(Arrays.asList(cartasArray))

        // cambiar color player 2 (inactivo)
       tv_p2!!.setTextColor(Color.BLUE)


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
        // imagen correcta con el imagen view
        if (cartasArray[card] == 101) {
            iv!!.setImageResource(image101)
        } else if (cartasArray[card] == 102) {
            iv!!.setImageResource(image102)
        } else if (cartasArray[card] == 103) {
            iv!!.setImageResource(image103)
        } else if (cartasArray[card] == 104) {
            iv!!.setImageResource(image104)
        } else if (cartasArray[card] == 105) {
            iv!!.setImageResource(image105)
        } else if (cartasArray[card] == 106) {
            iv!!.setImageResource(image106)
        } else if (cartasArray[card] == 201) {
            iv!!.setImageResource(image201)
        } else if (cartasArray[card] == 202) {
            iv!!.setImageResource(image202)
        } else if (cartasArray[card] == 203) {
            iv!!.setImageResource(image203)
        } else if (cartasArray[card] == 204) {
            iv!!.setImageResource(image204)
        } else if (cartasArray[card] == 205) {
            iv!!.setImageResource(image205)
        } else if (cartasArray[card] == 206) {
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
        }
    }

    private fun calculate() {
        //Si la imagen es igual borrar la carta y añadir punto
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

            //añadir punto al jugador correcto
            if (turn == 1) {
                playerPoints++
                tv_p1!!.text = "P1: $playerPoints"
            } else if (turn == 2) {
                cpuPoints++
                tv_p2!!.text = "P2: $cpuPoints"
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
            question11!!.setImageResource(R.drawable.cartajuego)
            question12!!.setImageResource(R.drawable.cartajuego)
            //cambiar el turno de jugadores
            if (turn == 1) {
                turn = 2
                tv_p1!!.setTextColor(Color.GRAY)
                tv_p2!!.setTextColor(Color.BLUE)
            } else if (turn == 2) {
                turn = 1
                tv_p1!!.setTextColor(Color.GRAY)
                tv_p2!!.setTextColor(Color.BLUE)
            }
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

        checkEnd();
    }

    private fun checkEnd() {
        if (question1!!.visibility == View.INVISIBLE && question2!!.visibility == View.INVISIBLE && question3!!.visibility == View.INVISIBLE && question4!!.visibility == View.INVISIBLE && question5!!.visibility == View.INVISIBLE && question6!!.visibility == View.INVISIBLE && question7!!.visibility == View.INVISIBLE && question8!!.visibility == View.INVISIBLE && question9!!.visibility == View.INVISIBLE && question10!!.visibility == View.INVISIBLE && question11!!.visibility == View.INVISIBLE && question12!!.visibility == View.INVISIBLE) {
            val alertDialogBuilder = AlertDialog.Builder(this@prueba)
            alertDialogBuilder
                .setMessage("GAME OVER!\n P1: $playerPoints\nP2: $cpuPoints")
                .setCancelable(false)
                .setPositiveButton("NEW") { dialogInterface, i ->
                    val intent = Intent(applicationContext, prueba::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("EXIT") { dialogInterface, i -> finish() }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }

    private fun frontOfCardsResources() {
        image101 = R.drawable.perro
        image102 = R.drawable.gato
        image103 = R.drawable.vaca
        image104 = R.drawable.cerdo
        image105 = R.drawable.gallo
        image106 = R.drawable.oveja
        image201 = R.drawable.perro
        image202 = R.drawable.gato
        image203 = R.drawable.vaca
        image204 = R.drawable.cerdo
        image205 = R.drawable.gallo
        image206 = R.drawable.oveja
    }
}