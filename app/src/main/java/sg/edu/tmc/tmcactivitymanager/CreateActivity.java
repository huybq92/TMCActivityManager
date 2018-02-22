package sg.edu.tmc.tmcactivitymanager;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by huybq on 7/2/2018.
 *
 * REFERENCE:
 *  - For the DatePicker: https://www.numetriclabz.com/android-date-picker-tutorial/
 */

public class CreateActivity extends AppCompatActivity {

    // Views declaration
    private Toolbar createToolbar;
    private Button create_button_confirm, create_button_date, create_button_time;
    private TextView create_text_inform;

    // Private variables
    private static int day,month,year;
    private static int hour,minute;

    // Listener for the DatePicker button
    private View.OnClickListener datePickerButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Show date picker dialog
            DialogFragment newDatePickerFragment = new DatePickerFragment();
            newDatePickerFragment.show(getSupportFragmentManager(), "datePicker");
        }
    };

    // Listener for the TimePicker button
    private View.OnClickListener timePickerButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Show time picker dialog
            DialogFragment newTimePickerFragment = new TimePickerFragment();
            newTimePickerFragment.show(getSupportFragmentManager(), "timePicker");
        }
    };

    // Methods to set private variables
    protected static void setDay(int d) {
        CreateActivity.day = d;
    }
    protected static void setMonth(int m) {
        CreateActivity.month = m;
    }
    protected static void setYear(int y) {
        CreateActivity.year = y;
    }
    protected static void setHour(int h) {
        CreateActivity.hour = h;
    }
    protected static void setMinute(int M) {
        CreateActivity.minute = M;
    }

    // Methods to get private variables
    protected static int getDay() {
        return CreateActivity.day;
    }
    protected static int getMonth() {
        return CreateActivity.month;
    }
    protected static int getYear() {
        return CreateActivity.year;
    }
    protected static int getHour() {
        return CreateActivity.hour;
    }
    protected static int getMinute() {
        return CreateActivity.minute;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //Initiate the toolbar and set properties
        createToolbar = findViewById(R.id.create_toolbar);
        createToolbar.setTitle(R.string.create_toolbar_title);
        setSupportActionBar(createToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Enable Up action

        // Initiate the Buttons and set Listeners
        create_button_date = findViewById(R.id.create_button_date);
            create_button_date.setOnClickListener(datePickerButtonListener);
        create_button_time = findViewById(R.id.create_button_time);
            create_button_time.setOnClickListener(timePickerButtonListener);
        create_button_confirm = findViewById(R.id.create_button_confirm);

        //Initiate the TextView
        create_text_inform = findViewById(R.id.create_text_inform);

    }
}
