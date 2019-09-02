package com.ngyb.database;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {
        Intent intent = new Intent(this, SqlActivity.class);
        startActivity(intent);
    }

    public void click2(View view) {
        Intent intent = new Intent(this, SqliteActivity.class);
        startActivity(intent);
    }

    public void click3(View view) {
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into info (name,money) values ('a',100)");
        db.execSQL("insert into info (name,money) values ('b',100)");
        db.beginTransaction();
        db.execSQL("update info set money =money -20 where name = 'a'");
        db.execSQL("update info set money =money +20 where name = 'b'");
        db.setTransactionSuccessful();
        db.endTransaction();
    }
}
