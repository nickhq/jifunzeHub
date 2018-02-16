package io.nkossy.jifunzeHub.FlashCards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import io.nkossy.jifunzeHub.R;

/**
 * Created by nickhq on 2/16/18.
 */

public class FlashCardAdapter extends ArrayAdapter<FlashCard> {
    public FlashCardAdapter(@NonNull Context context, @NonNull ArrayList<FlashCard> flashCards) {
        super(context, 0, flashCards);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        FlashCard card = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.flash_card_item,parent,false);

            TextView title = convertView.findViewById(R.id.card_title);
            TextView body = convertView.findViewById(R.id.card_body);

            assert card != null;
            title.setText(card.getTitle());
            body.setText(card.getBody());

        }


        return convertView;
    }
}
