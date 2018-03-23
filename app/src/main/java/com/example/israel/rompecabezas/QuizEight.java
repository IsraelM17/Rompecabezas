package com.example.israel.rompecabezas;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizEight extends AppCompatActivity {

    private ImageView img1,img2, img3, img4, img5, img6, img7, img8, img9;
    private int imagen1, imagen2, imagen3, imagen4, imagen5, imagen6, imagen7, imagen8, imagen9;
    private static int aux=0, cont = 1;
    private Drawable drawable1, drawable2;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_eight);

        chronometer = (Chronometer) findViewById(R.id.chronometer8);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();

        img1 = (ImageView) findViewById(R.id.img8_1);
        img2 = (ImageView) findViewById(R.id.img8_2);
        img3 = (ImageView) findViewById(R.id.img8_3);
        img4 = (ImageView) findViewById(R.id.img8_4);
        img5 = (ImageView) findViewById(R.id.img8_5);
        img6 = (ImageView) findViewById(R.id.img8_6);
        img7 = (ImageView) findViewById(R.id.img8_7);
        img8 = (ImageView) findViewById(R.id.img8_8);
        img9 = (ImageView) findViewById(R.id.img8_9);

        imagen1 = R.drawable.img9_1_1;
        imagen2 = R.drawable.img9_1_2;
        imagen3 = R.drawable.img9_1_3;
        imagen4 = R.drawable.img9_2_1;
        imagen5 = R.drawable.img9_2_2;
        imagen6 = R.drawable.img9_2_3;
        imagen7 = R.drawable.img9_3_1;
        imagen8 = R.drawable.img9_3_2;
        imagen9 = R.drawable.img9_3_3;

        img1.setImageResource(imagen4);
        img2.setImageResource(imagen7);
        img3.setImageResource(imagen2);
        img4.setImageResource(imagen9);
        img5.setImageResource(imagen8);
        img6.setImageResource(imagen3);
        img7.setImageResource(imagen5);
        img8.setImageResource(imagen1);
        img9.setImageResource(imagen6);


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont == 2){
                    cont -= 1;
                    drawable2 = img2.getDrawable();
                    img2.setImageDrawable(drawable1);
                    imgBefore(aux, drawable2);
                }
                else {
                    drawable1 = img2.getDrawable();
                    aux = 2;
                    cont += 1;
                }
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont == 2){
                    cont -= 1;
                    drawable2 = img1.getDrawable();
                    img1.setImageDrawable(drawable1);
                    imgBefore(aux, drawable2);

                }else {
                    drawable1 = img1.getDrawable();
                    aux = 1;
                    cont += 1;
                }
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont == 2){
                    cont -=1;
                    drawable2 = img3.getDrawable();
                    img3.setImageDrawable(drawable1);
                    imgBefore(aux, drawable2);
                }else{
                    drawable1 = img3.getDrawable();
                    aux = 3;
                    cont += 1;
                }
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont == 2){
                    cont -= 1;
                    drawable2 = img4.getDrawable();
                    img4.setImageDrawable(drawable1);
                    imgBefore(aux, drawable2);
                }else{
                    drawable1 = img4.getDrawable();
                    aux = 4;
                    cont += 1;
                }
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont == 2){
                    cont -= 1;
                    drawable2 = img5.getDrawable();
                    img5.setImageDrawable(drawable1);
                    imgBefore(aux, drawable2);
                }else{
                    drawable1 = img5.getDrawable();
                    aux = 5;
                    cont += 1;
                }
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont == 2){
                    cont -= 1;
                    drawable2 = img6.getDrawable();
                    img6.setImageDrawable(drawable1);
                    imgBefore(aux, drawable2);
                }else{
                    drawable1 = img6.getDrawable();
                    aux = 6;
                    cont += 1;
                }
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont == 2){
                    cont -= 1;
                    drawable2 = img7.getDrawable();
                    img7.setImageDrawable(drawable1);
                    imgBefore(aux, drawable2);
                }else{
                    drawable1 = img7.getDrawable();
                    aux = 7;
                    cont += 1;
                }
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont == 2){
                    cont -= 1;
                    drawable2 = img8.getDrawable();
                    img8.setImageDrawable(drawable1);
                    imgBefore(aux, drawable2);
                }else{
                    drawable1 = img8.getDrawable();
                    aux = 8;
                    cont += 1;
                }
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont == 2){
                    cont -= 1;
                    drawable2 = img9.getDrawable();
                    img9.setImageDrawable(drawable1);
                    imgBefore(aux, drawable2);
                }else{
                    drawable1 = img9.getDrawable();
                    aux = 9;
                    cont += 1;
                }
            }
        });
    }

    public void imgBefore(int img, Drawable drawable){
        if(img == 2) {
            img2.setImageDrawable(drawable2);
            if(win())
                Toast.makeText(this, "Lo has armado", Toast.LENGTH_SHORT).show();
        }
        else if(img == 1){
            img1.setImageDrawable(drawable2);
            if(win())
                Toast.makeText(this, "Lo has armado", Toast.LENGTH_SHORT).show();
        }else if(img == 3){
            img3.setImageDrawable(drawable2);
            if(win())
                Toast.makeText(this, "Lo has armado", Toast.LENGTH_SHORT).show();
        }else if(img == 4){
            img4.setImageDrawable(drawable2);
            if(win())
                Toast.makeText(this, "Lo has armado", Toast.LENGTH_SHORT).show();
        }else if(img == 5){
            img5.setImageDrawable(drawable2);
            if(win())
                Toast.makeText(this, "Lo has armado", Toast.LENGTH_SHORT).show();
        }else if(img == 6){
            img6.setImageDrawable(drawable2);
            if(win())
                Toast.makeText(this, "Lo has armado", Toast.LENGTH_SHORT).show();
        }else if(img == 7){
            img7.setImageDrawable(drawable2);
            if(win())
                Toast.makeText(this, "Lo has armado", Toast.LENGTH_SHORT).show();
        }else if(img == 8){
            img8.setImageDrawable(drawable2);
            if(win())
                Toast.makeText(this, "Lo has armado", Toast.LENGTH_SHORT).show();
        }else if(img == 9){
            img9.setImageDrawable(drawable2);
            if(win())
                Toast.makeText(this, "Lo has armado", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean win(){
        if(imagen1 == R.drawable.img4_1_1 && imagen2 == R.drawable.img4_1_2
                && imagen3 == R.drawable.img4_2_1 && imagen4 == R.drawable.img4_2_2)
            return true;
        else
            return false;
    }
}

