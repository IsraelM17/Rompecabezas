package com.example.israel.rompecabezas;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Quiz_four extends AppCompatActivity{

    private ImageView img1,img2, img3, img4;
    private int imagen1, imagen2, imagen3, imagen4;
    private static int select1, select2, aux=0, cont = 1;
    private Drawable drawable1, drawable2;

    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_four);

        img1 = (ImageView) findViewById(R.id.img1_1);
        img2 = (ImageView) findViewById(R.id.img1_2);
        img3 = (ImageView) findViewById(R.id.img1_3);
        img4 = (ImageView) findViewById(R.id.img1_4);

        imagen1 = R.drawable.img4_1_1;
        imagen2 = R.drawable.img4_1_2;
        imagen3 = R.drawable.img4_2_1;
        imagen4 = R.drawable.img4_2_2;

        img1.setImageResource(imagen4);
        img2.setImageResource(imagen1);
        img3.setImageResource(imagen2);
        img4.setImageResource(imagen3);

        imagen1 = 0;

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont == 2){
                    cont -= 1;
                    drawable2 = img2.getDrawable();
                    img2.setImageDrawable(drawable1);
                    Toast.makeText(Quiz_four.this, ""+--imagen2, Toast.LENGTH_SHORT).show();
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
