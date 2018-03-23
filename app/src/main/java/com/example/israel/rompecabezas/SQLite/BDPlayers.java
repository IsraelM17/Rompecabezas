package com.example.israel.rompecabezas.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by israel on 3/22/18.
 */

public class BDPlayers extends SQLiteOpenHelper {

    String sql_player = "CREATE TABLE players (" +
            "id_player INTEGER PRIMARY KEY, " +
            "nickname VARCHAR(50), " +
            "score VARCHAR(20))";

    public BDPlayers(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql_player);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
