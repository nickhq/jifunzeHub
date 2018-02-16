package io.nkossy.jifunzeHub.FlashCards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Collections;

import io.nkossy.jifunzeHub.R;

public class BiologyFlashCardActivity extends AppCompatActivity {

    ArrayList<FlashCard> al;
    FlashCardAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards_biology);


        //add the view via xml or programmatically
        SwipeFlingAdapterView flingContainer = findViewById(R.id.frame);

        al = new ArrayList<>();

        int length = title.length - 1;
        for (int s = 0; s < length; s++) {
            al.add(new FlashCard(title[s], body[s]));
        }

        Collections.shuffle(al);
        //choose your favorite adapter
        // arrayAdapter = new ArrayAdapter<>(this, R.layout.flash_card_item, R.id.textView, al );
        adapter = new FlashCardAdapter(this, al);

        //set the listener and the adapter
        flingContainer.setAdapter(adapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                al.remove(0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
              //  Toast.makeText(BiologyFlashCardActivity.this, "Left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                //Toast.makeText(BiologyFlashCardActivity.this, "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                al.add(new FlashCard("The End", "You Have Reached The End"));
                adapter.notifyDataSetChanged();
                Log.d("LIST", "notified");

            }

            @Override
            public void onScroll(float v) {

            }
        });

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(BiologyFlashCardActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    String[] title = {
            "Active transport",
            "Adaptation",
            "Aerobic respiration",
            "AIDS",
            "Alleles",
            "Anaerobic respiration",
            "Anaesthetics",
            "Arteries",
            " Artificial selection",
            " Asexual reproduction",
            " Assimilation",
            " Axon",
            "Bioaccumulation",
            "Breathing",
            " Capillaries",
    };

    String[] body = {
            " The process in which energy is used to move the particles of a substance against a concentration gradient, that is, from a region where they are of lower concentration to a region where they are of higher concentration.",
            "Any characteristic of an organism that improves its chances of surviving in its environment.",
            "Respiration with oxygen. It’s the oxidation of food substances in the presence of oxygen with the release of a large amount of energy. Carbon dioxide and water are released as waste products.",
            "An abbreviation for Acquired Immune Deficiency Syndrome.",
            "Different forms of a gene which occupy the same relative positions on a pair of homologous chromosomes.",
            "Drugs that make the body unable to feel pain.",
            "Blood vessels which carry blood away from the heart.",
            " A method used by human beings to produce plants and animals with desired qualities",

            "The process resulting in the production of genetically identical offspring from one parent, without the fusion of gametes",

            "The process whereby some of the absorbed food materials are converted into new protoplasm or used to provide energy",

            " A nerve fibre that transmits impulses away from the cell body of a neurone",

            "The process by which substances collect in all parts or part of a living organism",

            "The process that brings about an exchange of gases between an organism and its environment",

            "Microscopic thin-walled (one cell thick) blood vessels which carry blood from a small artery (arteriole) to a small vein (venule)",

    };

}


