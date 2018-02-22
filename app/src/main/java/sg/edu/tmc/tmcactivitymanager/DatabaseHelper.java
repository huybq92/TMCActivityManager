package sg.edu.tmc.tmcactivitymanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by huybq on 14/2/2018.
 *
 * //REFERENCE: http://abhiandroid.com/database/sqlite
 * //REFERENCE: https://developer.android.com/training/data-storage/sqlite.html
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //Variables
    private static final String db_name = "COMP1661";
    private static final String table_name = "COMP1661";
    private static final int db_version = 1;
    private static final String table_key = "act_id";
    private static final String table_field1 = "act_name"; // required
    private static final String table_field2 = "act_location"; // optional
    private static final String table_field3 = "act_date"; // required
    private static final String table_field4 = "act_time"; // optional
    private static final String table_field5 = "act_volunteer_name"; // required

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + table_name + " (" +
                    table_key + " INTEGER PRIMARY KEY," +
                    table_field1 + " TEXT," +
                    table_field2 + " TEXT," +
                    table_field3 + " TEXT," +
                    table_field4 + " TEXT," +
                    table_field5 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + table_name;

//#############
//## METHODS ##
//#############

    //Constructor
    public DatabaseHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
