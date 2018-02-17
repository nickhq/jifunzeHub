package io.nkossy.jifunzeHub.data;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by nickhq on 2/15/18
 */

class DbAssetsHelper extends SQLiteAssetHelper {

   // private static final String DATABASE_NAME = "computer.db";
    private static final int DATABASE_VERSION = 1;


    DbAssetsHelper(Context context, String dbName) {
        super(context, dbName, null, DATABASE_VERSION);
    }
}
