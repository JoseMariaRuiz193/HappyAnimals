package com.example.happyanimals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat

class AllAnimals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_animals)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        val img = findViewById<ImageView>(R.id.imageButton)
        val source1 = R.drawable.cerdook
        img.setImageResource(source1)
        img.setOnClickListener{
            pulsarAnimal(source1, "fade1")
        }
        val img2 = findViewById<ImageView>(R.id.imageButton4)
        val source2 = R.drawable.rana
        img2.setImageResource(source2)
        img2.setOnClickListener{
            pulsarAnimal(source2, "fade2")
        }
        val img3 = findViewById<ImageView>(R.id.imageButton5)
        val source3 = R.drawable.vaca
        img3.setImageResource(source3)
        img3.setOnClickListener{
            pulsarAnimal(source3, "fade3")
        }


    }

    fun pulsarAnimal ( a:Int, b : String) {
        val pantallaTeoriaSonidos = Intent(this, TeoriaSonidos::class.java)
        pantallaTeoriaSonidos.putExtra( "data", a)
        pantallaTeoriaSonidos.putExtra( "data2", b)

        startActivity(pantallaTeoriaSonidos)
    }

    fun onClickTeoriaSonidos(view: View) {
        irPantallaTeoriaSonidos()
    }
    fun irPantallaTeoriaSonidos() {
        val pantallaTeoriaSonidos = Intent(this, TeoriaSonidos::class.java)
        startActivity(pantallaTeoriaSonidos)
    }

    fun ranaActivity(view: View) {
        val pantallaRana = Intent(this, RanaActivity::class.java)
        startActivity(pantallaRana)
    }
    fun vacaActivity (view: View) {
        val pantallaVaca = Intent(this, VacaActivity::class.java)
        startActivity(pantallaVaca)
    }
}