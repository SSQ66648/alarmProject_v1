package com.example.alarmproject_v1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmCard_Adapter extends RecyclerView.Adapter<AlarmCard_Adapter.CardViewHolder> {
    private static final String TAG = "CardAdapterDevice";

    /*--------------------------------------
        MEMBER VARIABLES
    --------------------------------------*/
    //---VARIABLES---
    private ArrayList<AlarmCard> cardList;
    private OnItemClickListener clickListener;


    /*--------------------------------------
        CONSTRUCTOR(S)
    --------------------------------------*/
    public AlarmCard_Adapter(ArrayList<AlarmCard> exampleList) {
        cardList = exampleList;
    }


    /*--------------------------------------
        INTERFACE
    --------------------------------------*/
    //-listens for card click in recyclerView
    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    /*--------------------------------------
        INNER CLASS(ES)
    --------------------------------------*/
    public static class CardViewHolder extends RecyclerView.ViewHolder {

        //---VIEWS---
        public TextView alarmDate;
        public TextView alarmTime;

        //---CONSTRUCTOR---
        public CardViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            //references to views (pass values in onBindViewHolder)
            alarmDate = itemView.findViewById(R.id.txt_val_date);
            alarmDate = itemView.findViewById(R.id.txt_val_time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }


    /*--------------------------------------
        CREATE
    --------------------------------------*/
    @NonNull
    @Override
    public AlarmCard_Adapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alarm_card, parent, false);
        CardViewHolder cvh = new CardViewHolder(v, clickListener);
        return cvh;
    }


    /*--------------------------------------
        LISTENERS
    --------------------------------------*/
    @Override
    public void onBindViewHolder(@NonNull AlarmCard_Adapter.CardViewHolder holder, int position) {
        //pass information to item currently looked at (position)
        AlarmCard currentItem = cardList.get(position); //item at position
// TODO: 28/10/2020 figure out how to set values from internal data

        // TODO: 28/10/2020 set repeat checkboxes from array(list?)
    }


    /*--------------------------------------
        METHODS
    --------------------------------------*/
    //-get number of items in list
    @Override
    public int getItemCount() {
        return cardList
                .size();
    }


    //-sets the desired click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        clickListener = listener;
    }


    //-attempt to access list from outside class
    public ArrayList<AlarmCard> getCardList() {
        return cardList;
    }


    //-replace the list with new version
    //todo: test this
    public void updateDataset(ArrayList<AlarmCard> newList) {
        cardList
                .clear();
        cardList
                .addAll(newList);
        this.notifyDataSetChanged();
    }


}