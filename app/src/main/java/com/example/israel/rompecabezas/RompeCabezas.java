package com.example.israel.rompecabezas;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RompeCabezas extends AppCompatActivity{

    private EditText    edtNickname;
    private CircleMenu  circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rompe_cabezas);

        //ButterKnife.bind(this); Con ButterKnife Erronea circleMenu

        circleMenu  = (CircleMenu) findViewById(R.id.circleMenu);

        createMenu();
        createDialog();

    }

    public void createMenu(){

        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenuButton menuButton) {

                if(menuButton.getId() == R.id.four_pieces)
                    Toast.makeText(RompeCabezas.this, "4 piezas", Toast.LENGTH_SHORT).show();
                else if(menuButton.getId() == R.id.six_pieces){
                    Toast.makeText(RompeCabezas.this, "6 piezas", Toast.LENGTH_SHORT).show();
                }
                else if(menuButton.getId() == R.id.eigth_pieces){
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
                        Toast.makeText(RompeCabezas.this, "Bienvenido "+edtNickname.getText().toString(), Toast.LENGTH_SHORT).show();
                    }

                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(RompeCabezas.this, "Jugaras sin acceso a puntuación", Toast.LENGTH_SHORT).show();
            }

        });
        alert.show();
    }

}
