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

import io.nkossy.jifunzeHub.BaseActivity;
import io.nkossy.jifunzeHub.R;


public class QuizActivity extends BaseActivity implements View.OnClickListener {


    public final static String MESSAGE_INTENT_EXTRA = "io.nkossy.jiFunzeHub.MESSAGE";

    CardView cardMath;
    CardView cardEnglish;
    CardView cardSwahili;

    CardView cardPhysics;
    CardView cardChemistry;
    CardView cardBiology;

    CardView cardComputer;
    CardView cardBusiness;
    CardView cardAgriculture;

    CardView cardHistory;
    CardView cardCre;
    CardView cardGeograpy;

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

        cardMath = findViewById(R.id.quiz_card_math);
        cardEnglish = findViewById(R.id.quiz_card_english);
        cardSwahili = findViewById(R.id.quiz_card_swahili);

        cardChemistry = findViewById(R.id.quiz_card_chemistry);
        cardBiology = findViewById(R.id.quiz_card_biology);
        cardPhysics = findViewById(R.id.quiz_card_physics);

        cardComputer = findViewById(R.id.quiz_card_computer);
        cardBusiness = findViewById(R.id.quiz_card_business);
        cardAgriculture = findViewById(R.id.quiz_card_agriculture);

        cardCre = findViewById(R.id.quiz_card_cre);
        cardHistory = findViewById(R.id.quiz_card_history);
        cardGeograpy = findViewById(R.id.quiz_card_geography);

        cardMath.setOnClickListener(this);
        cardEnglish.setOnClickListener(this);
        cardSwahili.setOnClickListener(this);

        cardChemistry.setOnClickListener(this);
        cardBiology.setOnClickListener(this);
        cardPhysics.setOnClickListener(this);

        cardComputer.setOnClickListener(this);
        cardBusiness.setOnClickListener(this);
        cardAgriculture.setOnClickListener(this);

        cardCre.setOnClickListener(this);
        cardHistory.setOnClickListener(this);
        cardGeograpy.setOnClickListener(this);
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
        if (sp.getInt("Sound", 0) == 0) ;
        //mediaPlayer.start();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.quiz_card_math:
                setAndShowProgressBar();
                launchQuizActivity(MATH_INTENT);
                break;
            case R.id.quiz_card_english:
                setAndShowProgressBar();
                launchQuizActivity(ENGLISH_INTENT);
                break;

            case R.id.quiz_card_swahili:

                break;

            case R.id.quiz_card_biology:
                break;

            case R.id.quiz_card_chemistry:
                break;

            case R.id.quiz_card_physics:
                break;

            case R.id.quiz_card_computer:
                setAndShowProgressBar();
                launchQuizActivity(COMPUTER_INTENT);
                break;

            case R.id.quiz_card_business:
                break;

            case R.id.quiz_card_agriculture:
                break;

            case R.id.quiz_card_history:
                break;

            case R.id.quiz_card_geography:
                break;

            case R.id.quiz_card_cre:
                break;

        }
    }

    public static final String MATH_INTENT = "mathIntent";
    public static final String ENGLISH_INTENT = "englishIntent";
    public static final String SWAHILI_INTENT = "swahiliIntent";

    public static final String BIOLOGY_INTENT = "biologyIntent";
    public static final String CHEMISTRY_INTENT = "chemistryIntent";
    public static final String PHYSICS_INTENT = "physicsIntent";

    public static final String COMPUTER_INTENT = "computerIntent";
    public static final String BUSINESS_INTENT = "businessIntent";
    public static final String AGRICULTURE_INTENT = "agricultureIntent";

    public static final String HISTORY_INTENT = "historyIntent";
    public static final String GEOGRAPHY_INTENT = "geographyIntent";
    public static final String CRE_INTENT = "creIntent";
}

