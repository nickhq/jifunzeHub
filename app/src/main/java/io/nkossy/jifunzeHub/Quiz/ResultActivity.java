package io.nkossy.jifunzeHub.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.nkossy.jifunzeHub.R;


public class ResultActivity extends AppCompatActivity {
    TextView txtCorrect, txtIncorrect, txtAttempted, txtScore;
    TextView txtMessage;
    int correct = 0, incorrect = 0, attempt = 0, score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        correct = intent.getIntExtra("txtCorrect", 0);
        attempt = intent.getIntExtra("attempt", 1);
        incorrect = attempt - correct;
        score = 10 * correct;
        txtCorrect = findViewById(R.id.correct);
        txtIncorrect = findViewById(R.id.incorrect);
        txtAttempted = findViewById(R.id.attempted);
        txtScore = findViewById(R.id.score);
        txtMessage = findViewById(R.id.message);

        txtAttempted.setText(String.valueOf(attempt));
        txtCorrect.setText(String.valueOf(correct));
        txtIncorrect.setText(String.valueOf(incorrect));
        txtScore.setText(String.format(getString(R.string.form), score));
        float x1 = (correct * 100) / attempt;
        if (x1 < 40)
            txtMessage.setText(R.string.result_low);
        else if (x1 < 70)
            txtMessage.setText(R.string.result_average);
        else if (x1 < 90)
            txtMessage.setText(R.string.result_above_average);
        else
            txtMessage.setText(R.string.result_good);
    }
}

