package edu.csun.team5.pronounce_a_pal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class RecordInitial2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_initial2);

        final Button startSpeechButton = findViewById(R.id.toggleButtonRecordInitial4Button);

        startSpeechButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(RecordInitial2Activity.this, RecordInitial5Activity.class);//view.getContext(), TrainingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
