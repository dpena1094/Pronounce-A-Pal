package edu.csun.team5.pronounce_a_pal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {

    Button startSpeechButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

<<<<<<< HEAD
        startSpeechButton = (Button) findViewById(R.id.myButton);

        startSpeechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starter = new Intent(LandingActivity.this, TrainingActivity.class);//view.getContext(), TrainingActivity.class);

                startActivity(starter);
=======
        final Button signupButton = findViewById(R.id.SignupButton);
        final Button loginButton = findViewById(R.id.LoginButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
>>>>>>> c8e951168f8cb4572e26046c17451c8a7d931e6b
            }
        });
    }
}
