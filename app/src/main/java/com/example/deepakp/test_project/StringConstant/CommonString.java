package com.example.deepakp.test_project.StringConstant;

/**
 * Created by deepakp on 1/30/2017.
 */

public class CommonString {

    public CommonString(){};

    public static final String Tag_CONTACTNUMBER = "contactNumber";
    public static final String Tag_CONTACTNAME = "contactName";
    public static final String Tag_CONTACTS = "contacts";

    public static final String TABLE_CONTACTS = "contacts";




    public static final String CREATE_TABLE_CONTACTS = "create table if not exists" +
            ""+Tag_CONTACTS+"(" +
            ""+Tag_CONTACTNAME+" varchar," +
            ""+Tag_CONTACTNAME+" varchar)";


}
