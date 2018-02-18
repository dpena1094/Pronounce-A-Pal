package edu.csun.team5.pronounce_a_pal;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SystemClock.sleep(2000);

        Intent intent = new Intent(this, LandingActivity.class);
        startActivity(intent);
        finish();
    }
}
