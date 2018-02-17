package io.nkossy.jifunzeHub.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nickhq on 2/15/18
 */

public class SubjectDb {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static SubjectDb instance;


    // columns of the various subjects table
    private static final String COL_ID = "_id";
    private static final String COL_QUESTION = "COL_QUESTION";
    private static final String COL_OPTION_A = "COL_OPTION_A";
    private static final String COL_OPTION_B = "COL_OPTION_B";
    private static final String COL_OPTION_C = "COL_OPTION_C";
    private static final String COL_OPTION_D = "COL_OPTION_D";
    private static final String COL_ANSWER = "COL_ANSWER";


    private String tableName;


    private SubjectDb(Context context, String dbName, String tableName){
        this.tableName = tableName;
        this.openHelper = new DbAssetsHelper(context, dbName);
    }

    /**
     * Return a singleton instance of ComputerDbHelper.
     *
     * @param context the Context
     * @return the instance of ComputerDbHelper
     */
    public static SubjectDb getInstance(Context context, String dbName, String tableName) {
        if (instance == null) {
            instance = new SubjectDb(context, dbName, tableName);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    //Used to read the data from the Des.db file where id is given and we choose id randomly
    public String readQuestion(int id) {
        //string that contains the required field  note that Ans is just a local string not related to COL_ANSWER or Option...
        String Ans;
        //cursor to that query
        Cursor c = database.rawQuery("SELECT " + COL_QUESTION + " FROM "+ tableName +" WHERE _id = " + id + "", null);
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }

    public String readOptionA(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to COL_ANSWER or Option...
        Cursor c = database.rawQuery("SELECT " + COL_OPTION_A + " FROM " + tableName + " WHERE " + COL_ID + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }

    public String readOptionB(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to COL_ANSWER or Option...
        Cursor c = database.rawQuery("SELECT " + COL_OPTION_B + " FROM " + tableName + " WHERE " + COL_ID + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }

    public String readOptionC(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to COL_ANSWER or Option...
        Cursor c = database.rawQuery("SELECT " + COL_OPTION_C + " FROM " + tableName + " WHERE " + COL_ID + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }

    public String readOptionD(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to COL_ANSWER or Option...
        Cursor c = database.rawQuery("SELECT " + COL_OPTION_D + " FROM " + tableName + " WHERE " + COL_ID + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }

    public String readAnswer(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {

        String Ans = "";//string that contains the required field
        Cursor c = database.rawQuery("SELECT " + COL_ANSWER + " FROM " + tableName + " WHERE " + COL_ID + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }
}
