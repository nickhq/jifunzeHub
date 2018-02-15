package io.nkossy.collapsingtoolbar.data;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by nickhq on 2/15/18
 */

public class DbAssetsHelper extends SQLiteAssetHelper {

   // private static final String DATABASE_NAME = "computer.db";
    private static final int DATABASE_VERSION = 1;


    public DbAssetsHelper(Context context, String dbName) {
        super(context, dbName, null, DATABASE_VERSION);
    }
}
