package edu.csun.team5.pronounce_a_pal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class RecordInitial24Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_initial25);

        final Button startSpeechButton = findViewById(R.id.toggleButtonRecordInitia124Button);

        startSpeechButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(RecordInitial24Activity.this, RecordInitial25Activity.class);//view.getContext(), TrainingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
