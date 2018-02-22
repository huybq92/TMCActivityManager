package sg.edu.tmc.tmcactivitymanager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by huybq on 7/2/2018.
 */

public class CreateActivity extends AppCompatActivity {

    //Views declaration
    private Toolbar createToolbar;
    private Button create_button_confirm, create_button_date, create_button_time;
    private TextView create_text_inform, create_text_date, create_text_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //Initiate the toolbar and set properties
        createToolbar = (Toolbar) findViewById(R.id.create_toolbar);
        setSupportActionBar(createToolbar);
        getSupportActionBar().setTitle(R.string.create_toolbar_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Enable Up action

        // Initiate the Buttons
        create_button_date = (Button) findViewById(R.id.create_button_date);
        create_button_time = (Button) findViewById(R.id.create_button_time);
        create_button_confirm = (Button) findViewById(R.id.create_button_confirm);

        //Initiate the TextViews
        create_text_date = (TextView) findViewById(R.id.create_text_date);
        create_text_time = (TextView) findViewById(R.id.create_text_time);
        create_text_inform = (TextView) findViewById(R.id.create_text_inform);

    }
}
