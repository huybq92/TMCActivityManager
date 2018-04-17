package sg.edu.tmc.tmcactivitymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by huybq on 22/2/2018.
 *
 * This class is to help create, read, update and delete db data.
 *
 * REFERENCE:   https://developer.android.com/training/data-storage/sqlite.html
 *              http://www.codebind.com/android-tutorials-and-examples/android-sqlite-tutorial-example/
 */

public class DatabaseTable extends SQLiteOpenHelper {

    // Private attributes
    private static final String DATABASE_NAME = "COMP1661.db"; // db name
    private static final int DATABASE_VERSION = 1; // db version
    private static final String TABLE_NAME = "ACTIVITY";

    //The columns we'll include in the table
    private static final String COL_ACT_ID = "ACT_ID";
    private static final String COL_ACT_NAME = "ACT_NAME";
    private static final String COL_ACT_LOCATION = "ACT_LOCATION";
    private static final String COL_ACT_DATETIME = "ACT_DATETIME";
    private static final String COL_ACT_VOLUNTEER_NAME = "ACT_VOLUNTEER_NAME";

    //###############
    //# CONSTRUCTOR #
    //###############
    DatabaseTable(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Callback method to create db when an instance of this class is created
    // or when table need upgrading
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_ACTIVITY =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "( " +
                        COL_ACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COL_ACT_NAME + " TEXT," +
                        COL_ACT_LOCATION + " TEXT," +
                        COL_ACT_DATETIME + " TEXT," +
                        COL_ACT_VOLUNTEER_NAME + " TEXT" +
                ")";
        db.execSQL(CREATE_TABLE_ACTIVITY); // execute above SQL command
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Creating tables again
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    //##################
    //# CUSTOM METHODS #
    //##################

    // Method to insert new record to 'ACTIVITY' table
    // Return a boolean value to check if the process of inserting is successful
    boolean addActivity(String act_name, String act_location, String act_datetime, String act_volunteer_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // The COL_ACT_ID is the primary key ==> Java doesn't fill it. Instead, SQLite does automatically.
        contentValues.put(COL_ACT_NAME, act_name);
        contentValues.put(COL_ACT_LOCATION, act_location);
        contentValues.put(COL_ACT_DATETIME, act_datetime);
        contentValues.put(COL_ACT_VOLUNTEER_NAME, act_volunteer_name);

        // Begin INSERTING
        long result = db.insert(TABLE_NAME,null ,contentValues);
        return result != -1;
    }

    // Method to query all data from 'ACTIVITY' table
    protected Cursor getAllData () {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return res;
    }

    // Method to query only activity name from 'ACTIVITY' table
    protected Cursor getAllActivity () {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql_command = "SELECT ACT_NAME AS _id FROM " + TABLE_NAME;
        Cursor res = db.rawQuery(sql_command,null);
        return res;
    }

    // method to get the COL_ACT_NAME private variable
    protected String getColActName() {
        return COL_ACT_NAME;
    }

// class ends
}
