package io.nkossy.jifunzeHub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class ResultActivity extends AppCompatActivity {
    TextView correct, incorrect, attempted, score, you;
    int cor = 0, incorr = 0, attempt = 0, scor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        cor = intent.getIntExtra("correct", 0);
        attempt = intent.getIntExtra("attempt", 1);
        incorr = attempt - cor;
        scor = 10 * cor;
        correct = findViewById(R.id.correct);
        incorrect = findViewById(R.id.incorrect);
        attempted = findViewById(R.id.attempted);
        score = findViewById(R.id.score);
        you = findViewById(R.id.you);

        attempted.setText(String.valueOf(attempt));
        correct.setText(String.valueOf(cor));
        incorrect.setText(String.valueOf(incorr));
        score.setText(String.format(getString(R.string.form), scor));
        float x1 = (cor * 100) / attempt;
        if (x1 < 40)
            you.setText(R.string.result_low);
        else if (x1 < 70)
            you.setText(R.string.result_average);
        else if (x1 < 90)
            you.setText(R.string.result_above_average);
        else
            you.setText(R.string.result_good);
    }
}

