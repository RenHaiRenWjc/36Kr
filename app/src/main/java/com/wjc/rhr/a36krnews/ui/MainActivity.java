package com.wjc.rhr.a36krnews.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wjc.rhr.a36krnews.R;
import com.wjc.rhr.a36krnews.TApplication;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv) TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TApplication tApplication = (TApplication) this.getApplication();
        tApplication.addActivity(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TApplication tApplication = (TApplication) this.getApplication();
        tApplication.removeActivity(this);

    }
}
