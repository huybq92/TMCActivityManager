package sg.edu.tmc.tmcactivitymanager;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by huybq on 7/2/2018.
 */

public class ShowActivity extends AppCompatActivity {
    private ListView show_listview;
    private Cursor all_activity;
    private SimpleCursorAdapter myAdapter;
    // Database object
    protected DatabaseTable db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        // Create db object
        db = new DatabaseTable(this);

        // initiate the list view
        show_listview = (ListView) findViewById(R.id.show_listview);

        // get all data from activity table
        all_activity = MainActivity.db.getAllActivity();
        String[] from = new String[] {"_id"};
        int[]  to = new int[] { R.id.show_listview_item_textview };

        myAdapter = new SimpleCursorAdapter(this, R.layout.show_listview_item, all_activity, from, to, 0);

        // set adapter to list view
        show_listview.setAdapter(myAdapter);
    }
}
