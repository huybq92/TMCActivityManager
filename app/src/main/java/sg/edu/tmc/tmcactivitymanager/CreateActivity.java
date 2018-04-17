package sg.edu.tmc.tmcactivitymanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by huybq on 7/2/2018.
 *
 * REFERENCES:
 *  - For the DatePicker: https://www.numetriclabz.com/android-date-picker-tutorial/
 *  - For the TimePicker: https://android--examples.blogspot.sg/2015/04/timepickerdialog-in-android.html
 *  - For the Database: http://www.codebind.com/android-tutorials-and-examples/android-sqlite-tutorial-example/
 */

public class CreateActivity extends AppCompatActivity {

    // Views declaration
    private Toolbar createToolbar;
    private Button create_button_confirm, create_button_date, create_button_time;
    private TextView create_text_date, create_text_time;
    private EditText create_edit_act_name, create_edit_act_location, create_edit_act_volunteer_name;

    // Private static variables
    private static int day,month,year;
    private static int hour,minute;

    // Listener object for the DatePicker button
    private View.OnClickListener datePickerButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Show date picker dialog
            DialogFragment newDatePickerFragment = new DatePickerFragment();
            newDatePickerFragment.show(getSupportFragmentManager(), "datePicker");
        }
    };

    // Listener object for the TimePicker button
    private View.OnClickListener timePickerButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Show time picker dialog
            DialogFragment newTimePickerFragment = new TimePickerFragment();
            newTimePickerFragment.show(getSupportFragmentManager(), "timePicker");
        }
    };

    // Listener object for CREATE button
    private View.OnClickListener createButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Make sure all the required fields are filled
            if ( validateCreateForm() ) {
                if (!isDuplicate()) {
                    DialogFragment newCreateConfirmationDialogFragment = new CreateConfirmationDialogFragment();
                    newCreateConfirmationDialogFragment.show(getSupportFragmentManager(), "createConfirmation");
                } else {
                    Toast.makeText(getApplicationContext(), "Activity duplicates !", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Otherwise, display toast message to user
                Toast.makeText(getApplicationContext(), "Please fill in all the required forms !", Toast.LENGTH_SHORT).show();
            }
        }
    };

    // Method to validate the form inputs
    // - Activity name, date and volunteer name are compulsory
    protected boolean validateCreateForm () {
        return !(create_edit_act_name.getText().toString().matches("")
                || create_edit_act_volunteer_name.getText().toString().matches("")
                || create_text_date.getText().toString().equals("Not set!"));
    }

    // Method to validate the form inputs
    // - Activity name, date and volunteer name are compulsory
    protected boolean isDuplicate () {
        Cursor c = MainActivity.db.getAllActivity();
        while(c.moveToNext())
        {
            if ( create_edit_act_name.getText().toString().matches(c.getString(c.getColumnIndex("_id")) ) ) {
                return true;
            }
        }
        return false;
    }

    // Methods to SET private variables
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

    // Methods to GET private variables
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


    // MUST-HAVE DEFAULT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //Initiate the toolbar and set properties
        createToolbar = findViewById(R.id.create_toolbar);
            createToolbar.setTitle(R.string.create_toolbar_title);
        setSupportActionBar(createToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // enable Up action in the toolbar

        // Initiate the Buttons and set Listeners
        create_button_date = findViewById(R.id.create_button_date);
            create_button_date.setOnClickListener(datePickerButtonListener);
        create_button_time = findViewById(R.id.create_button_time);
            create_button_time.setOnClickListener(timePickerButtonListener);
        create_button_confirm = findViewById(R.id.create_button_confirm);
            create_button_confirm.setOnClickListener(createButtonListener);

        // Initiate the EditTexts
        create_edit_act_name = findViewById(R.id.create_edit_act_name);
        create_edit_act_location = findViewById(R.id.create_edit_act_location);
        create_edit_act_volunteer_name = findViewById(R.id.create_edit_act_volunteer_name);

        // Initiate the date + time TextViews
        create_text_date = findViewById(R.id.create_text_date);
        create_text_time = findViewById(R.id.create_text_time);
    }

// class ends
}
