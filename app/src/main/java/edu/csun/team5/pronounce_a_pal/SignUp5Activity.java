package edu.csun.team5.pronounce_a_pal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up5);

        final Button continueButton = findViewById(R.id.Signup5ContinueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp5Activity.this, RecordInitial1Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
