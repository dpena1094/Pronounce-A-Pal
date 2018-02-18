package edu.csun.team5.pronounce_a_pal;
//import com..android.courtcounter.R;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class TrainingActivity extends AppCompatActivity
{
    private TextView confidenceScoresOutput;
    private TextView textSpeechInput;
    private ImageButton btnSpeak;

    private SpeechRecognizer mySpeechRec;
    //int that tells us if this activity that results is from the the speech recognition activity
    private final static int REQ_CODE_SPEECH_INPUT = 100;
    private String confScoresStr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        //(A)float[] confidenceScores;
        float[] confidenceScores;
        textSpeechInput = (TextView) findViewById(R.id.textSpeechInput);
        confidenceScoresOutput = (TextView) findViewById(R.id.textSpeechOutput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);

		/*(A)
		mySpeechRec = SpeechRecognizer.CreateSpeechRecognizer(this);

		mySpeechRec.setRecognitionListener(new RecognizerListener()
		{
			@Override
			onResults(Bundle results)
			{
				confidenceScores = results.getFloatArray(CONFIDENCE_SCORES);
			}
		});
		*/

        // hide the action bar
        //getActionBar().hide();

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    0); //app-defined requestcode to id on resultreturned

        }


        btnSpeak.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                promptSpeechInput(v);
            }
        });
    }//onCreate

    private void promptSpeechInput(View view) {

        //declare the intent as an intent to run the speech recognizer
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); //string

        //send as an extra, info to choose the best language for free form speech interpretation
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault()); //Locale.getDefault()); //(!)CTry explicitly getting en-US.
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_prompt));
        intent.putExtra(RecognizerIntent.EXTRA_PREFER_OFFLINE, true);// android.speech.extra.PREFER_OFFLINE
        //intent.putExtra("android.speech.extra.PREFER_OFFLINE", true);

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        else
            Toast.makeText(this, "Your Device Does Not Support Speech Input", Toast.LENGTH_SHORT).show();


        /*(D)
        try
        {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        }
        catch (ActivityNotFoundException a)
        {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
        */
    }

    /**
     * Receiving speech input
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case REQ_CODE_SPEECH_INPUT:

                if (resultCode == RESULT_OK && data != null)
                {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textSpeechInput.setText(result.get(0));

                    //(B)
                    //confidenceScores = data.getFloatArrayExtra(RecognizerIntent.CONFIDENCE_SCORES);

                    //(B)
                    confScoresStr = getConfidenceScoresAsString(data.getFloatArrayExtra(RecognizerIntent.EXTRA_CONFIDENCE_SCORES));
                    //(B)
                    confidenceScoresOutput.setText(confScoresStr);
                }
                break;
        }
    } //onActivityResult

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    */

    //(D)
    public String getConfidenceScoresAsString(float[] confScores)
    {
        /*
        StringBuilder sb = new StringBuilder();

        String delimiter = "";

        for(int i = 0; i < confScores.length; i++)
        {
            sb.append(delimiter);
            delimiter = ", ";
            sb.append(String.valueOf(confScores[i]));
        }

        return sb.toString();
        */
        return String.valueOf(confScores[0]);//since there is ~only 1 value > 0 in the array~
    } //getconfidence score as string


}
