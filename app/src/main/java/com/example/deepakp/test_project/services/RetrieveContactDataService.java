package com.example.deepakp.test_project.services;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

import com.example.deepakp.test_project.AppDatabase;
import com.example.deepakp.test_project.SetterGetter.ContactGetterSetter;

import java.util.ArrayList;

/**
 * Created by deepakp on 1/31/2017.
 */

public class RetrieveContactDataService extends Service
{
    Context context;
    ContentResolver cr;
    Cursor cursor;
    AppDatabase db;
    ArrayList<ContactGetterSetter> contactArraylist;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        db=new AppDatabase(context);
        db.open();

        cr = context.getContentResolver();
        cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        contactArraylist=new ArrayList<ContactGetterSetter>();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));

                if (Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
                    while (pCur.moveToNext()) {

                        ContactGetterSetter contactGetterSetter=new ContactGetterSetter();

                        contactGetterSetter.setContactName(pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
                        contactGetterSetter.setContactNumber(pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));

                        contactArraylist.add(contactGetterSetter);
                        break;
                    }
                    pCur.close();
                }

            } while (cursor.moveToNext());
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
