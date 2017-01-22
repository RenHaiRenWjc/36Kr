package com.wjc.rhr.a36krnews.ui;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.wjc.rhr.a36krnews.R;
import com.wjc.rhr.a36krnews.TApplication;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity {
    @BindView(R.id.welcome_videoview)
    VideoView welcomeVideoView;
    @BindView(R.id.welcome_button)
    Button welcomBtn;
    TApplication mTApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mTApplication = (TApplication) this.getApplication();
        mTApplication.addActivity(this);
        ButterKnife.bind(this);
        welcomeVideoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.kr36));
        welcomeVideoView.start();
        //循环播放
        welcomeVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                welcomeVideoView.start();
            }
        });
        welcomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (welcomeVideoView.isPlaying()) {
                    welcomeVideoView.stopPlayback();
                    welcomeVideoView = null;
                }
//                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
//                startActivity(intent);
                openActivity(MainActivity.class);
                WelcomeActivity.this.finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTApplication.removeActivity(this);
    }
}
