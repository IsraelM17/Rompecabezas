package com.example.israel.rompecabezas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {

    @BindView(R.id.imgLogo) ImageView   imgLogo;
    @BindView(R.id.pgrBar)  ProgressBar progressBar;

    Hilo hilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ButterKnife.bind(this);

        hilo = new Hilo(progressBar, this);
        hilo.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        hilo.cancel(true);
        finish();
    }
}
