package com.example.happyanimals;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class pruebajava extends AppCompatActivity{

    TextView tv_p1, tv_p2;

    ImageView question1, question2, question3,question4,
            question5,question6,question7,question8,
            question9, question10, question11, question12 ;

    //array de imagenes
    Integer [] cartasArray = {101,102,103,104,105,106,201,202,203,204,205,206};

    //imagenes actuales
    int image101, image102, image103, image104, image105, image106,
            image201, image202, image203, image204, image205, image206;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn =1;
    int playerPoints = 0 , cpuPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_memory);

      //  tv_p1 = (TextView) findViewById(R.id.tv_p1);
       // tv_p2 = (TextView) findViewById(R.id.tv_p2);

        question1 = (ImageView) findViewById(R.id.question1);
        question2 = (ImageView) findViewById(R.id.question2);
        question3 = (ImageView) findViewById(R.id.question3);
        question4 = (ImageView) findViewById(R.id.question4);
        question5 = (ImageView) findViewById(R.id.question5);
        question6 = (ImageView) findViewById(R.id.question6);
        question7 = (ImageView) findViewById(R.id.question7);
        question8 = (ImageView) findViewById(R.id.question8);
        question9 = (ImageView) findViewById(R.id.question9);
        question10 = (ImageView) findViewById(R.id.question10);
        question11 = (ImageView) findViewById(R.id.question11);
        question12 = (ImageView) findViewById(R.id.question12);

        question1.setTag("0");
        question2.setTag("1");
        question3.setTag("2");
        question4.setTag("3");
        question5.setTag("4");
        question6.setTag("5");
        question7.setTag("6");
        question8.setTag("7");
        question9.setTag("8");
        question10.setTag("9");
        question11.setTag("10");
        question12.setTag("11");

        //cargar las imagenes de las cartas
        frontOfCardsResources();

        //barajar imagenes
        Collections.shuffle(Arrays.asList(cartasArray));

        // cambiar color player 2 (inactivo)
        tv_p2.setTextColor(Color.BLUE);

        question1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question1, theCard);
            }
        });
        question2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question2, theCard);
            }
        });
        question3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question3, theCard);
            }
        });
        question4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question4, theCard);
            }
        });
        question5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question5, theCard);
            }
        });
        question6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question6, theCard);
            }
        });
        question7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question7, theCard);
            }
        });
        question8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question8, theCard);
            }
        });
        question9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question9, theCard);
            }
        });
        question10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question10, theCard);
            }
        });
        question11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question11, theCard);
            }
        });
        question12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(question12, theCard);
            }
        });

    }

    private void doStuff(ImageView iv, int card){
        // imagen correcta con el imagen view
        if(cartasArray[card]== 101){
            iv.setImageResource(image101);
        }else if(cartasArray[card]== 102){
            iv.setImageResource(image102);
        }else if(cartasArray[card]== 103){
            iv.setImageResource(image103);
        }else if(cartasArray[card]== 104){
            iv.setImageResource(image104);
        }else if(cartasArray[card]== 105){
            iv.setImageResource(image105);
        }else if(cartasArray[card]== 106){
            iv.setImageResource(image106);
        }else if(cartasArray[card]== 201){
            iv.setImageResource(image201);
        }else if(cartasArray[card]== 202){
            iv.setImageResource(image202);
        }else if(cartasArray[card]== 203){
            iv.setImageResource(image203);
        }else if(cartasArray[card]== 204){
            iv.setImageResource(image204);
        }else if(cartasArray[card]== 205){
            iv.setImageResource(image205);
        }else if(cartasArray[card]== 206){
            iv.setImageResource(image206);
        }

        //comprobar imagen seleccionada y guardarla temporalmente
        if (cardNumber == 1){
            firstCard =cartasArray[card];
            if(firstCard > 200){
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);

        }else if (cardNumber == 2){
            secondCard = cartasArray[card];
            if(secondCard > 200){
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            question1.setEnabled(false);
            question2.setEnabled(false);
            question3.setEnabled(false);
            question4.setEnabled(false);
            question5.setEnabled(false);
            question6.setEnabled(false);
            question7.setEnabled(false);
            question8.setEnabled(false);
            question9.setEnabled(false);
            question10.setEnabled(false);
            question11.setEnabled(false);
            question12.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //comprobar si la imagen seleccionada es igual
                    calculate();
                }
            }, 1000);

        }
    }

    private void calculate (){
        //Si la imagen es igual borrar la carta y añadir punto
        if(firstCard == secondCard){
            if(clickedFirst == 0){
                question1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 1){
                question2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 2){
                question3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 3){
                question4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 4){
                question5.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 5){
                question6.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 6){
                question7.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 7){
                question8.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 8){
                question9.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 9){
                question10.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 10){
                question11.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 11){
                question12.setVisibility(View.INVISIBLE);
            }
            if(clickedSecond == 0){
                question1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 1){
                question2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 2){
                question3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 3){
                question4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 4){
                question5.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 5){
                question6.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 6){
                question7.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 7){
                question8.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 8){
                question9.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 9){
                question10.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 10){
                question11.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 11){
                question12.setVisibility(View.INVISIBLE);
            }

            //añadir punto al jugador correcto
            if (turn ==1) {
                playerPoints++;
                tv_p1.setText("P1: "+ playerPoints);
            } else if (turn ==2){
                cpuPoints++;
                tv_p2.setText("P2: "+ cpuPoints);
            }
        } else {
            question1.setImageResource(R.drawable.cartajuego);
            question2.setImageResource(R.drawable.cartajuego);
            question3.setImageResource(R.drawable.cartajuego);
            question4.setImageResource(R.drawable.cartajuego);
            question5.setImageResource(R.drawable.cartajuego);
            question6.setImageResource(R.drawable.cartajuego);
            question7.setImageResource(R.drawable.cartajuego);
            question8.setImageResource(R.drawable.cartajuego);
            question9.setImageResource(R.drawable.cartajuego);
            question11.setImageResource(R.drawable.cartajuego);
            question12.setImageResource(R.drawable.cartajuego);
//cambiar el turno de jugadores
            if (turn == 1) {
                turn = 2;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.BLUE);
            } else if (turn == 2) {
                turn = 1;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.BLUE);
            }
        }

        question1.setEnabled(true);
        question2.setEnabled(true);
        question3.setEnabled(true);
        question4.setEnabled(true);
        question5.setEnabled(true);
        question6.setEnabled(true);
        question7.setEnabled(true);
        question8.setEnabled(true);
        question9.setEnabled(true);
        question10.setEnabled(true);
        question11.setEnabled(true);
        question12.setEnabled(true);

        //checkEnd();
    }

    private void checkEnd(){
        if (question1.getVisibility() == View.INVISIBLE &&
                question2.getVisibility() == View.INVISIBLE &&
                question3.getVisibility() == View.INVISIBLE &&
                question4.getVisibility() == View.INVISIBLE &&
                question5.getVisibility() == View.INVISIBLE &&
                question6.getVisibility() == View.INVISIBLE &&
                question7.getVisibility() == View.INVISIBLE &&
                question8.getVisibility() == View.INVISIBLE &&
                question9.getVisibility() == View.INVISIBLE &&
                question10.getVisibility() == View.INVISIBLE &&
                question11.getVisibility() == View.INVISIBLE &&
                question12.getVisibility() == View.INVISIBLE
        ) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(pruebajava.this);
            alertDialogBuilder
                    .setMessage("GAME OVER!\n P1: " + playerPoints + "\nP2: "+cpuPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), pruebajava.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
    private void frontOfCardsResources(){
        image101 = R.drawable.perro;
        image102 = R.drawable.gato;
        image103 = R.drawable.vaca;
        image104 = R.drawable.cerdo;
        image105 = R.drawable.gallo;
        image106 = R.drawable.oveja;
        image201 = R.drawable.perro;
        image202 = R.drawable.gato;
        image203 = R.drawable.vaca;
        image204 = R.drawable.cerdo;
        image205 = R.drawable.gallo;
        image206 = R.drawable.oveja;

    }
}
