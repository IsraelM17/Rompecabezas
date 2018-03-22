package com.example.israel.rompecabezas;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ProgressBar;

/**
 * Created by israel on 3/20/18.
 */

public class Hilo extends AsyncTask<Void, Integer, Void>{

    private ProgressBar pgrBar;
    private Context     context;

    public Hilo(ProgressBar pgrBar, Context context){
        this.pgrBar     = pgrBar;
        this.context    = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 1; i <= 4; i++){
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        context.startActivity(new Intent(this.context, RompeCabezas.class));
    }
}
