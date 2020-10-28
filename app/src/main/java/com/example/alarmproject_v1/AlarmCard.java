// TODO: 28/10/2020 add comment header
package com.example.alarmproject_v1;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AlarmCard {

    //===== MEMBER VARIABLES =====//
    // TODO: 28/10/2020 change out placeholder strings for ACTUAL datatypes for storing these values
    private String alarmDate;
    private String alarmTime;
    private ArrayList alarmRepeatList;
    // TODO: 28/10/2020 add all data items ie alarm name
    // TODO: 28/10/2020 add custom icon for delete button (eg icon in circle background)


    //===== CONSTRUCTOR =====//
    public AlarmCard(String aDate, String aTime) {
        this.alarmDate = aDate;
        this.alarmTime = aTime;

        // TODO: 28/10/2020 get checked boxes for repeat-days
        alarmRepeatList = new ArrayList();

    }

    //===== ACCESSORS =====//
    public String getAlarmDate() {
        return alarmDate;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public ArrayList getAlarmRepeatList() {
        return alarmRepeatList;
    }


    //========== METHODS ==========//
    @NonNull
    @Override
    public String toString() {
        String repeatDays = "";
        for (int i = 0; i < alarmRepeatList.size(); i++) {
            repeatDays = repeatDays + alarmRepeatList.get(i) + ", ";
        }
        return "Alarm:\n" +
                "\tdate: " + alarmDate + "\n" +
                "\ttime: " + alarmTime + "\n" +
                "\trepeat: " + repeatDays;
    }
}
