package com.example.android.silviafirdaus_1202154345_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // membuat screennya menjadi full screen
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        // handle splash screen
        final Handler handler = new Handler(); //mengirim pesan yang ajan ditampilkan
        handler.postDelayed(new Runnable() {
            @Override
            public void run() { //mengatur seberapa lama splash ditampilkan
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000L); // 3000 (dalam long) = 3 detik
    }
}
