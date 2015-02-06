package com.example.victor.partyfinder;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *  Profiler class that contain information regarding an individual
 * Created by Victor on 2/5/2015.
 */


/*
phone number would be the unique key in database so probably shouldn't be a String value
or I guess it could?
 */
public class Player {
    protected String name, phoneNum;
    protected Date dob;
    protected ArrayList<String> activityPreference;

    public Player (String pname, Date bday, String phoneNumber){
        name = pname;
        dob = bday;
        phoneNum = phoneNumber;
        activityPreference = new ArrayList<String>();
    }
    public Player (String pname, int iYear, int iMonth, int iDay, String phoneNumber){
        name = pname;
        dob = toDate(iYear, iMonth, iDay);
        phoneNum = phoneNumber;
        activityPreference = new ArrayList<String>();
    }

    public String getName(){
        return name;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    public int getAge(){
        Calendar dob = Calendar.getInstance();
        dob.setTime(this.dob);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR))
            age--;
        return age;
    }

    public void addActivity(String activity) {
        activityPreference.add(activity);
        //add to cloud storage database under your profile
    }


    public static Date toDate(int iYear, int iMonth, int iDay){
        Calendar cal = Calendar.getInstance();
        cal.set(iYear, iMonth, iDay);
        Date date = cal.getTime();
        return date;
    }






}
