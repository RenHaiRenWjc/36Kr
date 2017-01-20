package com.wjc.rhr.a36krnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TApplication tApplication=(TApplication)this.getApplication();
        tApplication.addActivity(this);
        setContentView(R.layout.activity_main);
    }

}
