package edu.csun.team5.pronounce_a_pal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);

        final Button maleButton = findViewById(R.id.Signup1MaleButton);
        final Button femaleButton = findViewById(R.id.Signup1FemaleButton);
        final Button otherButton = findViewById(R.id.Signup1OtherButton);

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp1Activity.this, SignUp2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp1Activity.this, SignUp2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp1Activity.this, SignUp2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
