package com.example.designmodal.edevnews.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.designmodal.edevnews.R;



/**
 * Created by compware on 6/17/2018.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder
{
    TextView titleView,descriptionView,dateView;
    CardView cardView;
    ImageView newsImg;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        titleView = itemView.findViewById(R.id.title_text);
        descriptionView = itemView.findViewById(R.id.description_text);
        dateView = itemView.findViewById(R.id.date_text);
        cardView = itemView.findViewById(R.id.cardview);
        newsImg = itemView.findViewById(R.id.news_image);
    }
}
