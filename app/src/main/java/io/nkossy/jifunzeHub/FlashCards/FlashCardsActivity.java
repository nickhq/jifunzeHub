package io.nkossy.jifunzeHub.FlashCards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import io.nkossy.jifunzeHub.BaseActivity;
import io.nkossy.jifunzeHub.R;

public class FlashCardsActivity extends BaseActivity implements View.OnClickListener {



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

        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);


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
