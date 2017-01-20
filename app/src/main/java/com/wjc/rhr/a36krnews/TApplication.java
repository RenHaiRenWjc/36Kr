package com.wjc.rhr.a36krnews;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

import java.util.ArrayList;
//进程开始时先执行
//全局工作
/*
1.全局异常处理
2.创建长连接
 */

/**
 * Created by Wjc on 2017/1/13.19:${MIUNTE}
 * mail:renhairen2015@gmail.com
 */
public class TApplication extends Application {
    private ArrayList<Activity> mActivityArrayList = new ArrayList<Activity>();


    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = new CrashHandler(this);
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);

    }



    public void addActivity(Activity activity) {
        mActivityArrayList.add(activity);
    }

    public void removeActivity(Activity activity) {
        mActivityArrayList.remove(activity);
    }

    public void finishActivity() {
        for (Activity activity : mActivityArrayList) {
            activity.finish();
        }
        Process.killProcess(Process.myPid());
    }
}
