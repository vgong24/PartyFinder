package com.example.victor.partyfinder;

import android.app.Dialog;

import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    private static final int TIME_DIALOG_ID = 0 ;
    TextView timeView;
    Button timeBtn;
    private TextView timeText;
    int mHour, mMinute = 15;

    Handler mHandler = new Handler(){
        public void handleMessage(Message m){
            Bundle b = m.getData();
            mHour = b.getInt("set_hour");
            mMinute = b.getInt("set_minute");
            Toast.makeText(getBaseContext(), b.getString("set_time"), Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeView = (TextView) findViewById(R.id.timeView);
        timeBtn = (Button) findViewById(R.id.timeBtn);
        timeBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new mytimepicker(timeView);
                newFragment.show(getFragmentManager(), "timePicker");
            }


        });


    }


    //initialize variables
    private void initVariables(){
        //mDateTextView = (TextView) findViewById(R.id.timeView);
    }






    //source http://www.sanfoundry.com/java-android-program-time-picker-dialog/

    /**
     * Time picker code
     */
    public static class mytimepicker extends DialogFragment implements
            TimePickerDialog.OnTimeSetListener {
        TextView timeTxt;

        public mytimepicker(TextView txtview){
            timeTxt = txtview;
        }


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);


            TimePickerDialog timeDialog =  new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
            timeDialog.setTitle("Test");

            return timeDialog;
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // do something with the time chosen. http://stackoverflow.com/questions/2659954/timepickerdialog-and-am-or-pm/2660148#2660148
            String am_pm = "";

            Calendar datetime = Calendar.getInstance();
            datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            datetime.set(Calendar.MINUTE, minute);

            if (datetime.get(Calendar.AM_PM) == Calendar.AM)
                am_pm = "AM";
            else if (datetime.get(Calendar.AM_PM) == Calendar.PM)
                am_pm = "PM";

            String strHrsToShow = (datetime.get(Calendar.HOUR) == 0) ?"12":datetime.get(Calendar.HOUR)+"";

            timeTxt.setText(strHrsToShow + ":" + datetime.get(Calendar.MINUTE)+" " + am_pm);

        }
    }
    //==============================================================================================
    //EXTRA ========================================================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
