package io.nkossy.collapsingtoolbar.FlashCards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import io.nkossy.collapsingtoolbar.R;

public class FlashCardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);

        CardView cardBiology = findViewById(R.id.card_biology);

        cardBiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), BiologyFlashCardActivity.class));
            }
        });
    }
}
