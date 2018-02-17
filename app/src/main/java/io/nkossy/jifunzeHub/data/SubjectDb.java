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
    private static final String COL_QUESTION = "Question";
    private static final String COL_OPTION_A = "OptionA";
    private static final String COL_OPTION_B = "OptionB";
    private static final String COL_OPTION_C = "OptionC";
    private static final String COL_OPTION_D = "OptionD";
    private static final String COL_ANSWER = "Answer";


    private String tableName;


    private SubjectDb(Context context, String dbName, String tableName) {
        this.tableName = tableName;
        this.openHelper = new DbAssetsHelper(context, dbName);
    }

    /**
     * Return a singleton instance of SubjectDb.
     *
     * @param context the Context
     * @return the instance of SubjectDb
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

    /**
     * read the question of given subject db file where id is chosen  randomly
     *
     * @param id The id of the question
     * @return question
     */
    public String readQuestion(int id) {
        String question;
        // run a raw DB query to select the question of a subject
        Cursor cursor = database.rawQuery("SELECT " + COL_QUESTION + " FROM " + tableName + " WHERE _id = " + id + "", null);
        if (cursor.moveToFirst())
            question = cursor.getString(0);
        else
            question = "";
        cursor.close();
        return question;
    }

    public String readOptionA(int id) {
        String optionA;
        Cursor c = database.rawQuery("SELECT " + COL_OPTION_A + " FROM " + tableName + " WHERE " + COL_ID + " = " + id + "", null);//cursor to that query
        if (c.moveToFirst())
            optionA = c.getString(0);
        else
            optionA = "";
        c.close();
        return optionA;
    }

    public String readOptionB(int id) {
        String optionB;
        Cursor c = database.rawQuery("SELECT " + COL_OPTION_B + " FROM " + tableName + " WHERE " + COL_ID + " = " + id + "", null);//cursor to that query
        if (c.moveToFirst())
            optionB = c.getString(0);
        else
            optionB = "";
        c.close();
        return optionB;
    }

    public String readOptionC(int id)
    {
        String optionC;
        Cursor c = database.rawQuery("SELECT " + COL_OPTION_C + " FROM " + tableName + " WHERE " + COL_ID + " = " + id + "", null);//cursor to that query
        if (c.moveToFirst())
            optionC = c.getString(0);
        else
            optionC = "";
        c.close();
        return optionC;
    }

    public String readOptionD(int id)
    {
        String optionD;
        Cursor c = database.rawQuery("SELECT " + COL_OPTION_D + " FROM " + tableName + " WHERE " + COL_ID + " = " + id + "", null);//cursor to that query
        if (c.moveToFirst())
            optionD = c.getString(0);
        else
            optionD = "";
        c.close();
        return optionD;
    }

    public String readAnswer(int id)
    {

        String answer;
        Cursor c = database.rawQuery("SELECT " + COL_ANSWER + " FROM " + tableName + " WHERE " + COL_ID + " = " + id + "", null);//cursor to that query
        if (c.moveToFirst())
            answer = c.getString(0);
        else
            answer = "";
        c.close();
        return answer;
    }
}
