package io.nkossy.jifunzeHub;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.nkossy.jifunzeHub.FlashCards.FlashCardsActivity;
import io.nkossy.jifunzeHub.Quiz.QuizActivity;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected DrawerLayout mDrawerLayout;
    TextView navHeaderName, navHeaderEmail;
    ImageView navHeaderImage;
    protected NavigationView mNavigationView;
    private SharedPreferences mUserPrefInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_base);

        //Set name,email,image in  the navigation side drawer to those we enter in the login page
        mUserPrefInfo = getSharedPreferences("Content_main", Context.MODE_PRIVATE);


    }

    @Override
    protected void onStart() {
        super.onStart();


        String userName = mUserPrefInfo.getString("name", "Your Name");
        String userEmail = mUserPrefInfo.getString("email", "youremail@domain.com");
        String userGender = mUserPrefInfo.getString("gender", "Male");
        //get a reference to navigation header
        View header = mNavigationView.getHeaderView(0);
        navHeaderName = header.findViewById(R.id.nav_header_name);
        navHeaderEmail = header.findViewById(R.id.nav_header_email);
        navHeaderImage = header.findViewById(R.id.nav_header_image);
        navHeaderName.setText(userName);
        navHeaderEmail.setText(userEmail);
        if (userGender.equals("Male")) {
            navHeaderImage.setImageResource(R.drawable.male);
        } else {
            navHeaderImage.setImageResource(R.drawable.female);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_flash_cards:
                if (getClass() == FlashCardsActivity.class) {
                    Toast.makeText(this, "You are Here", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, FlashCardsActivity.class));
                    finish();
                }
                break;
            case R.id.nav_quiz:
                if (getClass() == QuizActivity.class) {
                    Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, QuizActivity.class));
                    finish();
                }
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
                startActivity(new Intent(this, BaseActivity.class));
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
}
