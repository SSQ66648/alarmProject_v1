/* =================================================================================================
 * PROJECT:     AlarmProject_v1
 * FILE:        MainActivity2.java
 * DESCRIPTION: Main activity of repeating, short-duration alarm app.
 *              Contains list of alarms (recyclerView of CardViews) and add-alarm function.
 * =================================================================================================
 * REQUIREMENTS:
 *      1: accurate alarm time
 *      2: silence self after n-seconds
 *      3: weekly repetition of set alarms
 *      4: multiple alarms set at once
 *      5: alarm list easily added-to or deleted-from
 * =================================================================================================
 * NOTES:
 * =================================================================================================
 * TO DO:
 *   todo: add cards to recycler on button
 *   todo: add alarm names (and text input -perhaps on time modal, default: "")
 *   todo: add modal dialog to button for input of alarm datetime before creating card (handle cancel)
 *   todo: delete cards on button press
 *   todo: create and store alarm choice in persistent memory (and delete on button press- after confirm dialog)
 *   todo: add repeating functionality via checkboxes
 *   todo: test alarms trigger at correct time (even in doze mode)
 *   todo: consider expanding card on button to choose repeating days (default single use alarm)
 *   todo: add functionality of period-of-repetition (default 1 week)?
 *      -note: may not include this as falling into calendar territory
 * ============================================================================================== */

package com.example.alarmproject_v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    public static final String TAG = MainActivity2.class.getSimpleName();

    //todo: add formatting for standard items again after Android studios reinstall eg:
    //===== CONSTANTS =====//

    //===== MEMBER VARIABLES =====//
    //only provide items currently needed (performance)
    private AlarmCard_Adapter alarmCard_Adapter;
    private RecyclerView.LayoutManager recycler_LayoutManager;
    private ArrayList<AlarmCard> alarmCardList;

    //- LAYOUT VIEWS -//
    private RecyclerView alarmList_recycler;
    private FloatingActionButton addAlarm_fab;


    //========== LIFECYCLE ==========//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //- INITIALISE LAYOUT -//
        alarmList_recycler = findViewById(R.id.recycler_alarmcards);
        addAlarm_fab = findViewById(R.id.fab_addAlarm);
        addAlarm_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "tbc: use button to add alarm card to list", Toast.LENGTH_SHORT).show();

                //test of card creation-add-to-recycler
                testCardCreation();
            }
        });

        //(re)create /clear list
        alarmCardList = new ArrayList<>();

    }


    //========== METHODS ==========//
    public void buildRecyclerView(final ArrayList<AlarmCard> cardList, RecyclerView recyclerView) {
        Log.v(TAG, "buildRecyclerView: ");

        recycler_LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recycler_LayoutManager);

        alarmCard_Adapter = new AlarmCard_Adapter(cardList);
        recyclerView.setAdapter(alarmCard_Adapter);

        //task to carry out when clicking a card item
        alarmCard_Adapter.setOnItemClickListener(new AlarmCard_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position) {
                Log.v(TAG, "onItemClick: ");

                final Dialog dialog = new Dialog(MainActivity2.this);
                // TODO: 28/10/2020 open alarm details modal
                // TODO: 28/10/2020 create detail modal (with ability to edit)
                Toast.makeText(MainActivity2.this, "tbc: open alarm details modal", Toast.LENGTH_SHORT).show();

            }
        });

    }


    //========== TEST METHODS ==========//
//    creates test alarmCard and adds it to the recylcer view
    public void testCardCreation() {
        Log.d(TAG, "testCardCreation: ");

        //create test cards v1 (placeholder strings)
        AlarmCard testCard_1 = new AlarmCard("DATE_1", "TIME_1");
        AlarmCard testCard_2 = new AlarmCard("DATE_2", "TIME_2");
        //add test cards to cardList
        alarmCardList.add(testCard_1);
        alarmCardList.add(testCard_2);

        //build recyclerView using cardList
        buildRecyclerView(alarmCardList, alarmList_recycler);
    }


}