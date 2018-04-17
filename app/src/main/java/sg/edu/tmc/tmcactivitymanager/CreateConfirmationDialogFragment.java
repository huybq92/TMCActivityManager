package sg.edu.tmc.tmcactivitymanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by huybq on 25/2/2018.
 *
 * REFERENCES: http://www.vogella.com/tutorials/AndroidDialogs/article.html
 */

public class CreateConfirmationDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Get entered info from inputs of hosting activity
        TextView create_text_date = getActivity().findViewById(R.id.create_text_date);
        TextView create_text_time = getActivity().findViewById(R.id.create_text_time);
            // Format: YYYY-MM-DD HH:MM to insert to database column
            final String datetime = CreateActivity.getYear() + "-" + CreateActivity.getMonth()
                                + "-" + CreateActivity.getDay() + " "
                                + CreateActivity.getHour() + ":"
                                + CreateActivity.getMinute();
        EditText create_edit_act_name = getActivity().findViewById(R.id.create_edit_act_name);
            final String act_name = create_edit_act_name.getText().toString();
        EditText create_edit_act_location = getActivity().findViewById(R.id.create_edit_act_location);
            final String act_location = create_edit_act_location.getText().toString();
        EditText create_edit_act_volunteer_name = getActivity().findViewById(R.id.create_edit_act_volunteer_name);
            final String act_volunteer_name = create_edit_act_volunteer_name.getText().toString();


        // Build message string
        String message = "Activity name: " + create_edit_act_name.getText().toString() + "\n" +
                            "Venue: " + create_edit_act_location.getText().toString() + "\n" +
                            "Date: " + create_text_date.getText().toString() + "\n";

        // If time hasn't been set, then default value is 00:00
        if (create_text_time.getText().toString().equals("Not set!"))
            message += "Time: 00:00 \n";
        else
            message += "Time: " + create_text_time.getText().toString() + "\n";

        // Finish the message building
        message += "Volunteer name: " + create_edit_act_volunteer_name.getText().toString();

        // Finally return dialog object
        return new AlertDialog.Builder(getActivity())
                // set dialog icon
                .setIcon(android.R.drawable.stat_notify_error)
                // set Dialog Title
                .setTitle("Are the info correct?")
                // Set Dialog Message
                .setMessage(message)

                // POSITIVE Button
                // - dismiss the dialog
                // - insert data to the database
                .setPositiveButton("CREATE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // insert data
                        boolean isInserted = MainActivity.db.addActivity(act_name, act_location, datetime, act_volunteer_name);
                        if ( isInserted )
                            Toast.makeText(getActivity(),"Inserted successfully!", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(),"Inserting failed. Try again later !", Toast.LENGTH_SHORT).show();
                    }
                })

                // NEGATIVE Button
                // - dismiss the dialog
                // - display cancel toast message
                .setNegativeButton("Retype", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Cancel", Toast.LENGTH_SHORT).show();
                    }
                }).create();
    }

// class ends
}