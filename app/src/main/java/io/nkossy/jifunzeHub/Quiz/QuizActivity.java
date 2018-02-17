package io.nkossy.jifunzeHub.Quiz;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import io.nkossy.jifunzeHub.BaseActivity;
import io.nkossy.jifunzeHub.R;


public class QuizActivity extends BaseActivity {


    public final static String MESSAGE_INTENT_EXTRA = "io.nkossy.jiFunzeHub.MESSAGE";
    Button btnComputer, btnGeneral, btnScience, btnEnglish, btnMath, btnMore;
    CardView cardBiology;
    CardView cardComputer;
    private ProgressDialog progressBar;
    MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        toolbar.setTitle(R.string.quiz_title);
        toolbar.setSubtitle(R.string.quiz_description);


        mDrawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);


        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        //To play background sound
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.abc);
           // mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }


        cardBiology = findViewById(R.id.quiz_card_biology);
        cardComputer = findViewById(R.id.quiz_card_computer);

        cardBiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndShowProgressBar();
                launchQuizActivity("scienceIntent");
            }
        });
        cardComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAndShowProgressBar();
                launchQuizActivity("computerIntent");
            }
        });
        /*
        btnComputer = findViewById(R.id.btnComputer);
        btnMore = findViewById(R.id.btnMore);
        btnGeneral = findViewById(R.id.btnGeneral);
        btnScience = findViewById(R.id.btnScience);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnMath = findViewById(R.id.btnMath);*/


      /*  btnComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setAndShowProgressBar();
                launchQuizActivity("computerIntent");
            }
        });


        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndShowProgressBar();
                launchQuizActivity("generalIntent");
            }
        });


        btnScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setAndShowProgressBar();
                launchQuizActivity("scienceIntent");
            }
        });


        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setAndShowProgressBar();
                launchQuizActivity("englishIntent");
            }
        });


        btnMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 400);

                setAndShowProgressBar();
                launchQuizActivity("mathIntent");

            }
        });

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizActivity.this, "We are working on ability to add more", Toast.LENGTH_LONG).show();
            }
        });
        */

    }

    private void setAndShowProgressBar() {
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(false);
        progressBar.setMessage("Getting Questions Ready ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
    }

    private void launchQuizActivity(final String intentExtra) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent start to open the navigation drawer activity
                progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                Intent intent = new Intent(QuizActivity.this, QuestionActivity.class);
                intent.putExtra(MESSAGE_INTENT_EXTRA, intentExtra);
                startActivity(intent);
            }
        }, 2000);
    }


    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0);
            //mediaPlayer.start();
    }

}

