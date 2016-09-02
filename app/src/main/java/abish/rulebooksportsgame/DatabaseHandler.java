/** Ridio v1.0
 * 	Purpose	   : VehicleDatabaseHandler
 *  Created by : Abish 
 *  Created Dt : old file
 *  Modified on: 18-02-2016 (Updated : Pending Vehicle not showing, fixed)
 *  Verified by:
 *  Verified Dt:
 * **/


package abish.rulebooksportsgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
	 
    /** All Static variables*/
    private static final int DATABASE_VERSION = 1;			 		   // Database Version
    private static final String DATABASE_NAME = "gamerule";		 	   // Database Name
    private static final String TABLE_URL = "vehicle_master"; // Contacts table name
 
    /** Contacts Table Columns names*/
    private static final String KEY_ID = "id";
    private static final String KEY_URL_TAG = "url_tag";
    private static final String KEY_URLS = "urls";
 
    /**Contructor*/
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 

	/** Creating Tables*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_URL + "(" + KEY_ID + " INTEGER PRIMARY KEY autoincrement not null,"
                + KEY_URL_TAG + " TEXT,"+ KEY_URLS+" TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
     
    /** Upgrading database*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /** Drop older table if existed*/
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_URL);
        /** Create tables again*/
        onCreate(db);
    }
 
    /*** All CRUD(Create, Read, Update, Delete) Operations  */
 
    /** Adding new Vehicle*/
    public void addUrls(String[] contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        //values.put(KEY_ID, contact.getID()); 						// Get ID
        values.put(KEY_URL_TAG, contact[0]); 					// Get Color
        values.put(KEY_URLS, contact[1]);
        db.insert(TABLE_URL, null, values);
        db.close();
    }
    
    /**Get Vehicle Name related the bike number passed*/
    public String getVehicleName(String tag){
    	String selectQuery = "SELECT "+KEY_URLS+" from " + TABLE_URL+ " WHERE "+KEY_URL_TAG+" = '"+tag+"'";
    	 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            return cursor.getString(0);
//            do {
//            	return cursor.getString(0);
//            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return null;
    }

 
    /** Getting vehicles Count*/
    public int getVehiclesCount(String vend_id) {
        String countQuery = "SELECT  * FROM " + TABLE_URL +" WHERE "+KEY_URL_TAG+" = '"+vend_id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int temp = cursor.getCount();
        Log.d("Count of vehicle : ", "" + cursor.getCount());
        cursor.close();
        db.close();
        return temp;
    }

}