package io.nkossy.jifunzeHub.FlashCards;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import io.nkossy.jifunzeHub.NavigationActivity;
import io.nkossy.jifunzeHub.R;

public class FlashCardsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(R.string.flash_card_title);
        toolbar.setSubtitle(R.string.flash_card_description);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        CardView cardBiology = findViewById(R.id.card_biology);
        CardView cardChemistry = findViewById(R.id.card_chemistry);
        CardView cardComputer = findViewById(R.id.card_computer);
        CardView cardBusiness = findViewById(R.id.card_business);
        CardView addSubject = findViewById(R.id.card_add);


        cardBiology.setOnClickListener(this);
        cardChemistry.setOnClickListener(this);
        cardComputer.setOnClickListener(this);
        cardBusiness.setOnClickListener(this);
        addSubject.setOnClickListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_flash_cards:
                Toast.makeText(this, "You are here", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_quiz:
                startActivity(new Intent(this, NavigationActivity.class));
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_biology:
                startActivity(new Intent(getBaseContext(), BiologyFlashCardActivity.class));
                break;
            default:
                Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
