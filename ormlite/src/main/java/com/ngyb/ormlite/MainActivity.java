package com.ngyb.ormlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            MyDbHelper myDbHelper = new MyDbHelper(this);
            Dao<Student, Integer> dao = myDbHelper.getDao(Student.class);
            dao.create(new Student("ngyb", 18));
            Student student = dao.queryForAll().get(0);
            if (student != null) {
                student.name = "ltz";
                student.age = 23;
                dao.update(student);
            }
//            dao.deleteById(1);
            List<Student> students = dao.queryForAll();
            for (Student student1 : students) {
                Log.e(TAG, "onCreate: " + student1.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
