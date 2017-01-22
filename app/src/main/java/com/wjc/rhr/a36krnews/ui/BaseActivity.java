package com.wjc.rhr.a36krnews.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by admin on 2017/1/22.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
    protected  void openActivity(Class<?> pClass){
        Intent intent=new Intent(this,pClass);
        this.startActivity(intent);
    }
}
