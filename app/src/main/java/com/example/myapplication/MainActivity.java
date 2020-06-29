package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
public class MainActivity extends AppCompatActivity  {
    public static FragmentManager mFragmentManager;
    public static MyAppDatabase mAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        mAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"Mydb").allowMainThreadQueries().build();
        if (findViewById(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return;
            }
            mFragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
        }
    }

}
