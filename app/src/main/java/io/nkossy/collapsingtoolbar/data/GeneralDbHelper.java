package io.nkossy.collapsingtoolbar.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nickhq on 2/15/18
 */

public class GeneralDbHelper {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static GeneralDbHelper instance;

    private static final String Table_name = "general";//name of table
    private static final String uid = "_id";//name of column1
    private static final String Question = "Question";//name of column2
    private static final String OptionA = "OptionA";//name of column3
    private static final String OptionB = "OptionB";//name of column4
    private static final String OptionC = "OptionC";//name of column5
    private static final String OptionD = "OptionD";//name of column6
    private static final String Answer = "Answer";//name of column7

    private static final String DB_NAME = "general.db";

    private GeneralDbHelper(Context context){
        this.openHelper = new DbAssetsHelper(context, DB_NAME);
    }

    /**
     * Return a singleton instance of ComputerDbHelper.
     *
     * @param context the Context
     * @return the instance of ComputerDbHelper
     */
    public static GeneralDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new GeneralDbHelper(context);
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
        //string that contains the required field  note that Ans is just a local string not related to Answer or Option...
        String Ans;
        //cursor to that query
        Cursor c = database.rawQuery("SELECT Question FROM " + Table_name + " WHERE _id = " + id + "", null);
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }

    public String readOptionA(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to Answer or Option...
        Cursor c = database.rawQuery("SELECT " + OptionA + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }

    public String readOptionB(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to Answer or Option...
        Cursor c = database.rawQuery("SELECT " + OptionB + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }

    public String readOptionC(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to Answer or Option...
        Cursor c = database.rawQuery("SELECT " + OptionC + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }

    public String readOptionD(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to Answer or Option...
        Cursor c = database.rawQuery("SELECT " + OptionD + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
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
        Cursor c = database.rawQuery("SELECT " + Answer + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        c.close();
        return Ans;
    }
}
