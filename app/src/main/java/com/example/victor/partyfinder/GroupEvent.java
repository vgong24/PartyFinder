package com.example.victor.partyfinder;

import android.location.Location;

import java.util.Date;

/**
 * Created by Victor on 2/5/2015.
 *
 * Should have a PublicEvent and PrivateEvent Subclasses?
 */
public class GroupEvent {
    private String activity = "";
    private String host = "";
    private Date timeOfEvent;
    private Location locOfEvent;
    private int numOfPlayers;

    public GroupEvent (String activity, String hostName, Location eventArea,Date time, int numOfPlayersNeeded){
        this.activity = activity;
        host = hostName;
        locOfEvent = eventArea;
        numOfPlayers = numOfPlayersNeeded;
        timeOfEvent = time;
    }


}
