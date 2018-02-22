package sg.edu.tmc.tmcactivitymanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by huybq on 22/2/2018.
 *
 * REFERENCE:   https://www.numetriclabz.com/android-date-picker-tutorial/
 *              https://neurobin.org/docs/android/android-date-picker-example/
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    // Method from DialogFragment class
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    // Must-have method from OnDateSetListener class
    // Where to get the date set by user
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Save the chosen date to the private variables day, month, year of CreateActivity class
        CreateActivity.setDay( view.getDayOfMonth() );
        CreateActivity.setMonth( view.getMonth() + 1); // by default, month starts counting from 0 => need to plus 1
        CreateActivity.setYear( view.getYear() );

        // Display the set date to the textview object of CreateActivity class object
        TextView create_text_date = getActivity().findViewById(R.id.create_text_date); //get the TextView from host activity (Create Activitys)
        String date = Integer.toString(CreateActivity.getDay()) + "/" +
                        Integer.toString(CreateActivity.getMonth()) + "/" +
                        Integer.toString(CreateActivity.getYear());
        create_text_date.setText(date);
    }

// class ends
}
