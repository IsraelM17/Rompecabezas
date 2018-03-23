package com.example.israel.rompecabezas;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.israel.rompecabezas.SQLite.BDPlayers;
import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;
import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

public class RompeCabezas extends AppCompatActivity{

    BDPlayers bdPlayers;
    SQLiteDatabase sqLiteDatabase;

    private EditText    edtNickname;
    private CircleMenu  circleMenu;
    private TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rompe_cabezas);


        txtWelcome = (TextView) findViewById(R.id.edtWelcome);
        //ButterKnife.bind(this); Con ButterKnife Erronea circleMenu
        bdPlayers = new BDPlayers(this,"PLAYERS",null, 1);
        sqLiteDatabase  = bdPlayers.getReadableDatabase();
        circleMenu  = (CircleMenu) findViewById(R.id.circleMenu);

        createMenu();
        createDialog();

    }

    public void createMenu(){

        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenuButton menuButton) {

                if(menuButton.getId() == R.id.four_pieces) {
                    Intent intent = new Intent(RompeCabezas.this, QuizFour.class);
                    startActivity(intent);
                    Toast.makeText(RompeCabezas.this, "4 piezas", Toast.LENGTH_SHORT).show();
                }
                else if(menuButton.getId() == R.id.six_pieces){
                    Intent intent = new Intent(RompeCabezas.this, QuizSix.class);
                    startActivity(intent);
                    Toast.makeText(RompeCabezas.this, "6 piezas", Toast.LENGTH_SHORT).show();
                }
                else if(menuButton.getId() == R.id.eigth_pieces){
                    Intent intent = new Intent(RompeCabezas.this, QuizEight.class);
                    startActivity(intent);
                    Toast.makeText(RompeCabezas.this, "8 piezas", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    /**
     * En este método se crea un alert para pedir al usuario un NickName.
     * El NickName lo meteremos a la base de datos SQLite
     */

    public void createDialog(){

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().inflate(R.layout.nick_name, null);

        final EditText edtNickname = (EditText) view.findViewById(R.id.edtNickname);
        alert.setView(view);
        alert.setTitle("Nickname")
                .setMessage("Ingresa tu Nickname")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!searchPlayer(edtNickname.toString()))
                            insertPlayer(edtNickname.getText().toString());
                        else
                            Toast.makeText(RompeCabezas.this, "Jugaras sin Ranking", Toast.LENGTH_SHORT).show();
                    }

                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(RompeCabezas.this, "Jugaras sin acceso a puntuación", Toast.LENGTH_SHORT).show();
            }

        });
        alert.show();
    }

    public void insertPlayer(String player){
        String query = "INSERT INTO players (nickname, score) VALUES ('" + player + "', null)";
        try{
            sqLiteDatabase.execSQL(query);
            SuperActivityToast.create(this, new Style(), Style.TYPE_BUTTON)
                    .setText("Bienvenido "+player)
                    .setDuration(Style.DURATION_MEDIUM)
                    .setFrame(Style.FRAME_LOLLIPOP)
                    .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_ORANGE))
                    .setAnimations(Style.ANIMATIONS_FADE).show();
        }catch(Exception e){
            Toast.makeText(this, "Error Jugador", Toast.LENGTH_SHORT).show();
            e.toString();
            e.printStackTrace();
        }
    }

    private boolean searchPlayer(String nickname){
        String query    = "SELECT * FROM players WHERE nickname = '"+nickname+"'";
        Cursor cursor   = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst())
            return true;
        else
            return false;
    }
}
