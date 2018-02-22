package sg.edu.tmc.tmcactivitymanager;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by huybq on 22/2/2018.
 *
 * REFERENCE: https://android--examples.blogspot.sg/2015/04/timepickerdialog-in-android.html
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //Create and return a new instance of TimePickerDialog
        return new TimePickerDialog(getActivity(),this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    //onTimeSet() callback method
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        //Do something with the user chosen time
        // Save the chosen time to the private variables hour, minute of CreateActivity class
        CreateActivity.setHour( hourOfDay );
        CreateActivity.setMinute( minute );

        //Get reference of host activity (XML Layout File) TextView widget
        //Display the user changed time on TextView
        TextView create_text_time = getActivity().findViewById(R.id.create_text_time);
        String time = new String();
        // Firstly, check if the hour contains a single number
        if (hourOfDay < 10) {
            time = "0" + String.valueOf(hourOfDay); // add a zero before hour
        } else {
            // If the hour contains 2 numbers
            time = String.valueOf(hourOfDay);
        }

        // Then, check for the minute
        if (minute < 10) {
            // If the minute contains only 1 number
            time += ":0" + String.valueOf(minute);
        } else {
            //If the minute contains 2 numbers
            time += ":" + String.valueOf(minute);
        }

        //Finally, set the String to the TextView
        create_text_time.setText(time);
    }
}
