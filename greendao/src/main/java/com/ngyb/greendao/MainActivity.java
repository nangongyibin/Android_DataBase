package com.ngyb.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.ngyb.greendao.bean.Father;
import com.ngyb.greendao.bean.PEClazz;
import com.ngyb.greendao.bean.Son;
import com.ngyb.greendao.bean.Student;
import com.ngyb.greendao.db.GreedaoService;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private GreedaoService mGreedaoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGreedaoService = new GreedaoService(this);
    }

    public void click1(View view) {
        Student student = new Student();
        student.setName("张三");
        student.setNumber("123");

        PEClazz peClazz = new PEClazz();
        peClazz.setName("AA");
        peClazz.setCredit(179);
        long peID = mGreedaoService.daoSession.getPEClazzDao().insertOrReplace(peClazz);
        mGreedaoService.daoSession.clear();
        student.setPE_Id(peID);
        mGreedaoService.daoSession.getStudentDao().insertOrReplace(student);
        mGreedaoService.daoSession.clear();
    }


    public void click2(View view) {
        List<Student> list = mGreedaoService.daoSession.getStudentDao().queryBuilder().list();
        Log.e(TAG, "click2: 11111" + new Gson().toJson(list));
        for (Student student : list) {
            PEClazz peClazz = student.getPeClazz();
            Log.e(TAG, "click2: 4444"+new Gson().toJson(peClazz) );
        }
        mGreedaoService.daoSession.clear();
    }


    public void click3(View view) {
        Son son1 = new Son();
        son1.setName("儿子1");
        Son son2 = new Son();
        son2.setName("儿子2");
        Son son3 = new Son();
        son3.setName("儿子3");
        Father father = new Father();
        father.setName("父亲");
        long fatherID = mGreedaoService.daoSession.getFatherDao().insertOrReplace(father);

        son1.setFatherID(fatherID);
        son2.setFatherID(fatherID);
        son3.setFatherID(fatherID);
        mGreedaoService.daoSession.getSonDao().insertOrReplace(son1);
        mGreedaoService.daoSession.getSonDao().insertOrReplace(son2);
        mGreedaoService.daoSession.getSonDao().insertOrReplace(son3);
        mGreedaoService.daoSession.clear();
    }


    public void click4(View view) {
        List<Father> list = mGreedaoService.daoSession.getFatherDao().queryBuilder().list();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Father father = list.get(i);
                List<Son> sons = father.getSons();
                Gson gson = new Gson();
                Log.e(TAG, "click4:222 " + gson.toJson(sons));
            }
        }
        Gson gson = new Gson();
        String s = gson.toJson(list);
        Log.e(TAG, "click4: 3333" + s);
    }
}
