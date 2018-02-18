package edu.csun.team5.pronounce_a_pal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class RecordInitial5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_initial5);

        final Button startSpeechButton = findViewById(R.id.toggleButtonRecordInitial5Button);

        startSpeechButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(RecordInitial5Activity.this, RecordInitial4Activity.class);//view.getContext(), TrainingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        final Button startSpeechButton2 = findViewById(R.id.toggleButton3RecordInitial5Button);

        startSpeechButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(RecordInitial5Activity.this, RecordInitial6Activity.class);//view.getContext(), TrainingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}