package sg.edu.tmc.tmcactivitymanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Views declaration
    private Toolbar mainToolbar;
    private Button btn_create, btn_show, btn_dont_press_me;

    // Database object
    protected static DatabaseTable db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create db object
        db = new DatabaseTable(this);

        //Initiate the toolbar and setup
        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle(R.string.main_toolbar_title);

        //Initiate the buttons, then add listeners
        btn_create = (Button) findViewById(R.id.main_button_create);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
                startActivity(intent);
            }
        });

        btn_show = (Button) findViewById(R.id.main_button_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShowActivity.class);
                startActivity(intent);
            }
        });

        btn_dont_press_me = (Button) findViewById(R.id.main_button_dont_press_me);
        btn_dont_press_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NameEntryApp.class);
                startActivity(intent);
            }
        });

    }
}
