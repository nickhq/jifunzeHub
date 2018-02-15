package io.nkossy.collapsingtoolbar;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView nav_header_nam, nav_header_emal;
    ImageView nav_header_imag;
    public final static String Message = "com.kvikesh800gmail.relativlayoutjava.MESSAGE";
    Button btnComputer, c2, c3, btnGeneral, btnScience, btnEnglish, c7, btnMath, c9, c10;
    private ProgressDialog progressBar;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getSharedPreferences("Content_main", Context.MODE_PRIVATE);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        //To play background sound
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.abc);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }

        //Set name,email,image in  the navigation side drawer to those we enter in the login page
        String nav_header_name = sharedPreferences.getString("name", "xyz");
        String nav_header_email = sharedPreferences.getString("email", "abc@gmail.com");
        String nav_header_gender = sharedPreferences.getString("gender", "Male");
        View header = navigationView.getHeaderView(0);//Used to get a reference to navigation header
        nav_header_nam = header.findViewById(R.id.nav_header_name);
        nav_header_emal = header.findViewById(R.id.nav_header_email);
        nav_header_imag = header.findViewById(R.id.nav_header_image);
        nav_header_nam.setText(nav_header_name);
        nav_header_emal.setText(nav_header_email);
        if (nav_header_gender.equals("Male")) {
            nav_header_imag.setImageResource(R.drawable.man);
        } else {
            nav_header_imag.setImageResource(R.drawable.female);
        }
        btnComputer = findViewById(R.id.btnComputer);
        c2 = (Button) findViewById(R.id.b2);
        c3 = (Button) findViewById(R.id.b3);
        btnGeneral = findViewById(R.id.btnGeneral);
        btnScience = findViewById(R.id.btnScience);
        btnEnglish =  findViewById(R.id.btnEnglish);
        c7 = (Button) findViewById(R.id.b7);
        btnMath = (Button) findViewById(R.id.btnMath);
        c9 = (Button) findViewById(R.id.b9);
        c10 = (Button) findViewById(R.id.b10);


        btnComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 400);


                //Create new object of progress bar type
                progressBar = new ProgressDialog(v.getContext());
                //Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setCancelable(false);
                //Title shown in the progress bar
                progressBar.setMessage("Getting QuestionActivity Ready ...");
                //Style of the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                //attributes
                progressBar.setProgress(0);
                //attributes
                progressBar.setMax(100);
                //show the progress bar
                progressBar.show();
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                        intent.putExtra(Message, "computerIntent");//by this statement we are sending the name of the button that invoked the new QuestionActivity.java activity "Message" is defined by the name of the package + MESSAGE
                        startActivity(intent);
                    }
                }, 2000);
            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 400);

                progressBar = new ProgressDialog(v.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting QuestionActivity Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                        intent.putExtra(Message, "c2");
                        startActivity(intent);
                    }
                }, 2000);
            }
        });


        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 400);

                progressBar = new ProgressDialog(v.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting QuestionActivity Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                        intent.putExtra(Message, "c3");
                        startActivity(intent);
                    }
                }, 2000);
            }
        });


        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 400);

                progressBar = new ProgressDialog(v.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting QuestionActivity Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                        intent.putExtra(Message, "generalIntent");
                        startActivity(intent);
                    }
                }, 2000);
            }
        });


        btnScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 400);

                progressBar = new ProgressDialog(v.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting QuestionActivity Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                        intent.putExtra(Message, "scienceIntent");
                        startActivity(intent);
                    }
                }, 2000);
            }
        });


        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 400);

                progressBar = new ProgressDialog(v.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting QuestionActivity Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                        intent.putExtra(Message, "englishIntent");
                        startActivity(intent);
                    }
                }, 2000);
            }
        });


        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 400);

                progressBar = new ProgressDialog(v.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting QuestionActivity Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                        intent.putExtra(Message, "c7");
                        startActivity(intent);
                    }
                }, 2000);
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

                progressBar = new ProgressDialog(v.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting QuestionActivity Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                        intent.putExtra(Message, "mathIntent");
                        startActivity(intent);
                    }
                }, 2000);
            }
        });


        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 400);

                progressBar = new ProgressDialog(v.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting QuestionActivity Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                        intent.putExtra(Message, "c9");
                        startActivity(intent);
                    }
                }, 2000);
            }
        });


        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //To show button click
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 400);

                progressBar = new ProgressDialog(v.getContext());//Create new object of progress bar type
                progressBar.setCancelable(false);//Progress bar cannot be cancelled by pressing any wher on screen
                progressBar.setMessage("Getting QuestionActivity Ready ...");//Title shown in the progress bar
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);//Style of the progress bar
                progressBar.setProgress(0);//attributes
                progressBar.setMax(100);//attributes
                progressBar.show();//show the progress bar
                //This handler will add a delay of 3 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Intent start to open the navigation drawer activity
                        progressBar.cancel();//Progress bar will be cancelled (hide from screen) when this run function will execute after 3.5seconds
                        Intent intent = new Intent(NavigationActivity.this, QuestionActivity.class);
                        intent.putExtra(Message, "c10");
                        startActivity(intent);
                    }
                }, 2000);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_scorecard) {
            Intent intent = new Intent(this, ScoreCard.class);
            startActivity(intent);

        } else if (id == R.id.nav_Setting) {
              *//*  startActivity(new Intent(this,Setting.class));*//*
            startActivity(new Intent(this, Setting_activity.class));

        } else if (id == R.id.nav_share) {
            //shareApplication();
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_SUBJECT, "QuizBook");
            System.out.println("" + R.string.email_content);
            intent.putExtra(Intent.EXTRA_TEXT, "" + getText(R.string.email_content) + getText(R.string.link) + getText(R.string.last_content));
            Intent chooser = Intent.createChooser(intent, "Share using");
            startActivity(chooser);


        } else if (id == R.id.nav_feedback) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] recipents = {"kvikesh800@gmail.com"};
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, recipents);
            intent.putExtra(Intent.EXTRA_SUBJECT, "QuizBook Reviews");
            Intent chooser = Intent.createChooser(intent, "Send Feedback Via");
            startActivity(chooser);

        } else if (id == R.id.nav_Help) {
            Intent i = new Intent(this, Help.class);
            startActivity(i);

        } else if (id == R.id.nav_aboutus) {
            Intent i = new Intent(this, AboutUs.class);
            startActivity(i);
        }
*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
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
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.start();
    }

}

