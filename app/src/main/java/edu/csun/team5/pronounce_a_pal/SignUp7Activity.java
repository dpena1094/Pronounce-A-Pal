package edu.csun.team5.pronounce_a_pal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up7);

        final Button continueButton = findViewById(R.id.Signup7ContinueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp7Activity.this, SignUp8Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
