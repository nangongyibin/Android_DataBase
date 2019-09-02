package com.ngyb.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/8/30 16:41
 */
public class SqlActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SqlActivity";
    private Button mBtn1, mBtn2, mBtn3, mBtn4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        mBtn1 = findViewById(R.id.btn1);
        mBtn2 = findViewById(R.id.btn2);
        mBtn3 = findViewById(R.id.btn3);
        mBtn4 = findViewById(R.id.btn4);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MySQLiteOpenHelper msoh = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = msoh.getWritableDatabase();
        switch (v.getId()) {
            case R.id.btn1:
                db.execSQL("insert into ngyb(id,name,age) values (1,'ngyb',12)");
                db.execSQL("insert into ngyb(id,name,age) values (2,'cqq',12)");
                break;
            case R.id.btn2:
                db.execSQL("delete from ngyb where name = 'ngyb'");
                break;
            case R.id.btn3:
                db.execSQL("update ngyb set age = 25 where name = 'ngyb'");
                break;
            case R.id.btn4:
//                Cursor cursor = db.rawQuery("select * from ngyb", null);
                Cursor cursor = db.rawQuery("select * from info", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(0);
                        String name = cursor.getString(1);
                        int age = cursor.getInt(2);
                        Log.e(TAG, "id:" + id + "=name:" + name + "=age:" + age);
                    }
                    cursor.close();
                }
                break;
        }
        db.close();
        msoh.close();
    }
}
