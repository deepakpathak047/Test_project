package com.example.deepakp.test_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.deepakp.test_project.StringConstant.CommonString;

import java.util.HashMap;

/**
 * Created by deepakp on 1/31/2017.
 */

public class AppDatabase extends SQLiteOpenHelper {

    static final String Tag_DATABASENAME = "LETSPARTY_DATABASE";
    static final int Tag_DATABASEVERSION = 1;
    SQLiteDatabase db;


    public AppDatabase(Context context) {
        super(context, Tag_DATABASENAME, null, Tag_DATABASEVERSION);
    }

    public void open() {
        try {
            db = this.getWritableDatabase();
        } catch (Exception ex) {
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CommonString.Tag_CONTACTNAME);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }


    public void InsertContactData(HashMap<String,String> data) {

        db.delete(CommonString.TABLE_CONTACTS, null, null);
        ContentValues values = new ContentValues();
        try {

            for (int i = 0; i < data.size(); i++) {

             //   values.put(CommonString.Tag_CONTACTNAME, data.getStoreid().get(i));
             //   values.put(CommonString.Tag_CONTACTNUMBER, data.getStorename().get(i));
            //    db.insert(CommonString1.TABLE_GEO_TAG_MAPPING, null, values);

            }

        } catch (Exception ex) {

        }

    }




}
