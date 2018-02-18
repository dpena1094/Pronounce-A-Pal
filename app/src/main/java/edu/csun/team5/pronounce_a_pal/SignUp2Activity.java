package edu.csun.team5.pronounce_a_pal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        final Button adultButton = findViewById(R.id.Signup2AdultButton);
        final Button childButton = findViewById(R.id.Signup2ChildButton);

        adultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp2Activity.this, SignUp3Activity.class);
                startActivity(intent);
                finish();
            }
        });

        childButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp2Activity.this, SignUp3Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
