package edu.csun.team5.pronounce_a_pal;
//import com..android.courtcounter.R;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
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
    private TextView txtSpeechInput;
    private ImageButton btnSpeak;

    private SpeechRecognizer mySpeechRec;
    //int that tells us if this activity that results is from the the speech recognition activity
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private String confScoresStr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        //(A)float[] confidenceScores;
        float[] confidenceScores;
        txtSpeechInput = (TextView) findViewById(R.id.textSpeechInput);
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

        btnSpeak.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                promptSpeechInput();
            }
        });
    }//onCreate

    private void promptSpeechInput()
    {
        //declare the intent as an intent to run the speech recognizer
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); //string

        //send as an extra, info to choose the best language for free form speech interpretation
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, Locale.getDefault()); //Locale.getDefault()); //(!)CTry explicitly getting en-US.
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_prompt));
        intent.putExtra(RecognizerIntent.EXTRA_PREFER_OFFLINE, true);// android.speech.extra.PREFER_OFFLINE
        //intent.putExtra("android.speech.extra.PREFER_OFFLINE", true);

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
            {
                if (resultCode == RESULT_OK && null != data)
                {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));

                    //(B)confidenceScores = data.getFloatArrayExtra(RecognizerIntent.CONFIDENCE_SCORES);

                    //(B)confScoresStr = getConfidenceScoresAsString(data.getFloatArrayExtra(RecognizerIntent.EXTRA_CONFIDENCE_SCORES));
                    //B)confidenceScoresOutput.setText(confScoresStr);
                }
                break;
            }
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

    public String getConfidenceScoresAsString(float[] confScores)
    {
        StringBuilder sb = new StringBuilder();
        String delimiter = "";

        for(int i = 0; i < confScores.length; i++)
        {
            sb.append(delimiter);
            delimiter = ", ";
            sb.append(String.valueOf(confScores[i]));
        }

        return sb.toString();
    } //getconfidence score as string

}
