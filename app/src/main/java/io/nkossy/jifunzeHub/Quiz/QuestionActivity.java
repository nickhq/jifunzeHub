package io.nkossy.jifunzeHub.Quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;
import java.util.Collections;

import io.nkossy.jifunzeHub.R;
import io.nkossy.jifunzeHub.data.SubjectDb;

import static io.nkossy.jifunzeHub.Quiz.QuizActivity.INTENT_COMPUTER;
import static io.nkossy.jifunzeHub.Quiz.QuizActivity.INTENT_ENGLISH;
import static io.nkossy.jifunzeHub.Quiz.QuizActivity.INTENT_MATH;

public class QuestionActivity extends AppCompatActivity {

    public static final String KEY_MATH = "math";
    public static final String KEY_ENGLISH = "english";
    public static final String KEY_COMPUTER = "computer";


    DonutProgress donutProgress;
    boolean killActivity = true;
    TextView txtQuestion;
    Button btnOptA, btnOptB, btnOptC, btnOptD;
    Button playButton;
    String get;

    int visibility = 0;
    boolean populateFields = true;
    int attemptedQuestions = 0;
    int correctQuestions = 0;
    int j = 0;

    ArrayList<Integer> list = new ArrayList<>();


    String global = null;
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //receiving the intent send by the Navigation activity
        Intent intent = getIntent();
        //converting that intent message to string using the getStringExtra() method
        get = intent.getStringExtra(QuizActivity.MESSAGE_INTENT_EXTRA);
        toast = new Toast(this);


        //attribute of the circular progress bar
        donutProgress = findViewById(R.id.donut_progress);
        donutProgress.setMax(100);
        donutProgress.setFinishedStrokeColor(Color.parseColor("#FFFB385F"));
        donutProgress.setTextColor(Color.parseColor("#FFFB385F"));
        donutProgress.setKeepScreenOn(true);


        //Till here we are linking the database file
        btnOptA = findViewById(R.id.OptionA);
        btnOptB = findViewById(R.id.OptionB);
        btnOptC = findViewById(R.id.OptionC);
        btnOptD = findViewById(R.id.OptionD);
        txtQuestion = findViewById(R.id.Questions);
        //Play button to start the quiz
        playButton = findViewById(R.id.play_button);

    }

    //When this method is executed then there will be new question came and also same method for
    // play button
    public void onClick(View v) {

        attemptedQuestions++;
        if (visibility == 0) {
            //showing the buttons which were previously invisible
            btnOptA.setVisibility(View.VISIBLE);
            btnOptB.setVisibility(View.VISIBLE);
            btnOptC.setVisibility(View.VISIBLE);
            btnOptD.setVisibility(View.VISIBLE);
            playButton.setVisibility(View.GONE);
            donutProgress.setVisibility(View.VISIBLE);
            visibility = 1;
            // run and start the timer
            countDownTimer();
        }

        // show snackbar notification
        showSnackBar(v);


        switch (get) {
            case INTENT_COMPUTER:

                if (populateFields) {
                    for (int i = 1; i < 90; i++) {
                        list.add(i);
                    }
                    Collections.shuffle(list);
                    populateFields = false;
                }
                SubjectDb computer = new SubjectDb(this, "computer.db", "computer");
                computer.open();

                question = computer.readQuestion(list.get(j));
                optionA = computer.readOptionA(list.get(j));
                optionB = computer.readOptionB(list.get(j));
                optionC = computer.readOptionC(list.get(j));
                optionD = computer.readOptionD(list.get(j));
                global = computer.readAnswer(list.get(j++));

                computer.close();
                break;
            case INTENT_ENGLISH:
                if (populateFields) {
                    for (int i = 1; i < 27; i++) {
                        list.add(i);
                    }
                    Collections.shuffle(list);
                    populateFields = false;
                }
                SubjectDb english = new SubjectDb(this, "english.db", "english");
                english.open();

                question = english.readQuestion(list.get(j));
                optionA = english.readOptionA(list.get(j));
                optionB = english.readOptionB(list.get(j));
                optionC = english.readOptionC(list.get(j));
                optionD = english.readOptionD(list.get(j));
                if (j == list.size() - 2) {
                    startResult();
                }
                global = english.readAnswer(list.get(j++));

                english.close();
                break;
            case INTENT_MATH:
                if (populateFields) {
                    for (int i = 1; i < 26; i++) {
                        list.add(i);
                    }
                    Collections.shuffle(list);
                    populateFields = false;
                }
                SubjectDb math = new SubjectDb(this, "maths.db", "maths");
                math.open();

                question = math.readQuestion(list.get(j));
                optionA = math.readOptionA(list.get(j));
                optionB = math.readOptionB(list.get(j));
                optionC = math.readOptionC(list.get(j));
                optionD = math.readOptionD(list.get(j));
                if (j == list.size() - 2) {
                    startResult();
                }
                global = math.readAnswer(list.get(j++));
                math.close();
                break;
        }
        txtQuestion.setText(question);
        btnOptA.setText(optionA);
        btnOptB.setText(optionB);
        btnOptC.setText(optionC);
        btnOptD.setText(optionD);

    }

    private void showSnackBar(View v) {
        if (global != null) {
            switch (global) {
                case "A":
                    if (v.getId() == R.id.OptionA) {
                        //Here we use the snack bar because if we use the toast then they will be
                        // stacked an user cannot identify which questions answer is it showing
                        Snackbar.make(v, "         Correct ☺", Snackbar.LENGTH_SHORT).show();

                        correctQuestions++;
                    } else {
                        Snackbar.make(v, "Incorrect\t      Answer :" + optionA + "", Snackbar.LENGTH_SHORT).show();
                    }

                    break;
                case "B":
                    if (v.getId() == R.id.OptionB) {
                        Snackbar.make(v, "          Correct ☺", Snackbar.LENGTH_SHORT).show();
                        correctQuestions++;
                    } else {
                        Snackbar.make(v, "Incorrect\t      Answer :" + optionB + "", Snackbar.LENGTH_SHORT).show();
                    }

                    break;
                case "C":
                    if (v.getId() == R.id.OptionC) {

                        Snackbar.make(v, "         Correct ☺", Snackbar.LENGTH_SHORT).show();
                        correctQuestions++;
                    } else {
                        Snackbar.make(v, "Incorrect\tAnswer :" + optionC + "", Snackbar.LENGTH_SHORT).show();
                    }
                    break;
                case "D":
                    if (v.getId() == R.id.OptionD) {
                        Snackbar.make(v, "        Correct ☺", Snackbar.LENGTH_SHORT).show();
                        correctQuestions++;
                    } else {

                        Snackbar.make(v, "Incorrect\tAnswer :" + optionD + "", Snackbar.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }

    private void countDownTimer() {

        new CountDownTimer(50000, 1000) {
            int i = 100;

            @Override
            public void onTick(long millisUntilFinished) {
                i = i - 2;
                donutProgress.setProgress(i);


            }

            @Override
            public void onFinish() {
                toast.cancel();
                //here we are saving the data when the countdown timer will finish
                // and it is saved in shared preference file that is defined in
                // onCreate method as txtScore

                if (get.equals(INTENT_COMPUTER) && getScore(KEY_COMPUTER) < correctQuestions)
                    saveScore(KEY_COMPUTER, calculateScore(correctQuestions));
                else if (get.equals(INTENT_ENGLISH) && getScore(KEY_ENGLISH) < calculateScore(correctQuestions)) {
                    saveScore(KEY_ENGLISH, calculateScore(correctQuestions));
                } else if (get.equals(INTENT_MATH) && getScore(KEY_MATH) < calculateScore(correctQuestions)) {
                    saveScore(KEY_MATH, calculateScore(correctQuestions));
                }

                donutProgress.setProgress(0);
                if (killActivity) {
                    startResult();
                    finish();
                }
            }
        }.start();
    }

    private void startResult() {
        Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
        intent.putExtra("txtCorrect", correctQuestions);
        intent.putExtra("attempt", attemptedQuestions);
        startActivity(intent);
    }

    private void saveScore(String name, int value) {
        SharedPreferences shared = getSharedPreferences("Score", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();
        // save number of questions done
        editor.putInt(name, value).apply();
    }

    private int getScore(String name) {
        SharedPreferences sharedPref = getSharedPreferences("Score", Context.MODE_PRIVATE);

        return sharedPref.getInt(name, 0);
    }

    private int calculateScore(int points) {
        return points * 10;
    }

    @Override
    protected void onPause() {
        super.onPause();
        killActivity = false;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        killActivity = false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        killActivity = false;
        finish();
    }

}

