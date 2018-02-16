package io.nkossy.jifunzeHub;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.nkossy.jifunzeHub.FlashCards.FlashCardsActivity;


public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView navHeaderName, navHeaderEmail;
    ImageView navHeaderImage;
    public final static String Message = "com.kvikesh800gmail.relativlayoutjava.MESSAGE";
    Button btnComputer, btnGeneral, btnScience, btnEnglish, btnMath, btnMore;
    private ProgressDialog progressBar;
    MediaPlayer mediaPlayer;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        toolbar.setTitle(R.string.quiz_title);
        toolbar.setSubtitle(R.string.quiz_description);
        SharedPreferences sharedPreferences = getSharedPreferences("Content_main", Context.MODE_PRIVATE);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        //To play background sound
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.abc);
           // mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }

        //Set name,email,image in  the navigation side drawer to those we enter in the login page
        String nav_header_name = sharedPreferences.getString("name", "xyz");
        String nav_header_email = sharedPreferences.getString("email", "abc@gmail.com");
        String nav_header_gender = sharedPreferences.getString("gender", "Male");
        View header = navigationView.getHeaderView(0);//Used to get a reference to navigation header
        navHeaderName = header.findViewById(R.id.nav_header_name);
        navHeaderEmail = header.findViewById(R.id.nav_header_email);
        navHeaderImage = header.findViewById(R.id.nav_header_image);
        navHeaderName.setText(nav_header_name);
        navHeaderEmail.setText(nav_header_email);
        if (nav_header_gender.equals("Male")) {
            navHeaderImage.setImageResource(R.drawable.male);
        } else {
            navHeaderImage.setImageResource(R.drawable.female);
        }
        btnComputer = findViewById(R.id.btnComputer);

        btnMore = findViewById(R.id.btnMore);
        btnGeneral = findViewById(R.id.btnGeneral);
        btnScience = findViewById(R.id.btnScience);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnMath = findViewById(R.id.btnMath);


        btnComputer.setOnClickListener(new View.OnClickListener() {
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
                Toast.makeText(NavigationActivity.this, "We are working on ability to add more", Toast.LENGTH_LONG).show();
            }
        });


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
                Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                intent.putExtra(Message, intentExtra);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_flash_cards:
                startActivity(new Intent(this, FlashCardsActivity.class));
                break;
            case R.id.nav_quiz:
                Toast.makeText(this, "You are here", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_leader_board:
                Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_setting:
                Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_feedback:
                Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_help:
                Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about:
                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle("About Developers")
                        .setMessage("We Students Building Android Apps for Students")
                        .setIcon(R.drawable.ic_info_24dp)
                        .setCancelable(true)
                        .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // leave this empty
                            }
                        });
                builder.show();
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
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

