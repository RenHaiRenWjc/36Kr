package com.wjc.rhr.a36krnews;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.widget.Toast;

import com.wjc.rhr.a36krnews.ui.MainActivity;

import java.io.PrintWriter;
import java.io.StringWriter;

/*获取全局异常
/**
 * Created by Wjc on 2017/1/13.20:${MIUNTE}
 * mail:renhairen2015@gmail.com
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    TApplication mTApplication;

    public CrashHandler(TApplication mTApplication) {
        this.mTApplication = mTApplication;
    }


    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        //得到异常的详细信息
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);


        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(mTApplication, "很抱歉，程序即将重启", Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }.start();
        //休眠5s再重启
        try {
            Thread.currentThread().sleep(3000);
        } catch (Exception e) {
        }
        //自动重启
        Intent intent = new Intent(mTApplication, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mTApplication, 100, intent,0);
        //定时器
        AlarmManager alarmManager = (AlarmManager) mTApplication.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, pendingIntent);
        mTApplication.finishActivity();

    }


}
