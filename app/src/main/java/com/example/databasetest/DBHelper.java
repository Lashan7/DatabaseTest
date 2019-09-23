package com.example.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String Database_Name = "ItemDb";

    public DBHelper(Context context){
        super(context,Database_Name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_ENTITY = "CREATE TABLE " + UserMaster.Item.TABLE_NAME +
                ( "(") + UserMaster.Item.ITEM_NAME + " TEXT ," +
                UserMaster.Item.ITEM_DES + " TEXT)";


        sqLiteDatabase.execSQL(SQL_CREATE_ENTITY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void addItem(String name, String des){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UserMaster.Item.ITEM_NAME,name);
        values.put(UserMaster.Item.ITEM_DES,des);

        long rows = db.insert(UserMaster.Item.TABLE_NAME,null,values);

        if(rows > 0){
            System.out.println("Insertion Ok!");
        }
    }

    public List<Item> readAll(){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();


        String pro[] = { UserMaster.Item.ITEM_NAME,UserMaster.Item.ITEM_DES };

        String sortOrder = UserMaster.Item.ITEM_NAME + " DESC";

        Cursor cursor =  sqLiteDatabase.query(
                UserMaster.Item.TABLE_NAME,
                pro,
                null,
                null,
                null,
                null,
                sortOrder
        );


        List list = new ArrayList<Item>();

        while (cursor.moveToNext()){

            Item item = new Item();
            item.setName(cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Item.ITEM_NAME)));
            item.setDes(cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Item.ITEM_DES)));
            list.add(item);
        }

        cursor.close();

        return list;
    }

    public List<Item> search(String name){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();


        String pro[] = { UserMaster.Item.ITEM_NAME,UserMaster.Item.ITEM_DES };

        String sortOrder = UserMaster.Item.ITEM_NAME + " DESC";

        Cursor cursor =  sqLiteDatabase.query(
                UserMaster.Item.TABLE_NAME,
                pro,
                UserMaster.Item.ITEM_NAME + "= ?",
                new String[] { name },
                null,
                null,
                sortOrder
        );


        List list = new ArrayList<Item>();

        while (cursor.moveToNext()){

            Item item = new Item();
            item.setName(cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Item.ITEM_NAME)));
            item.setDes(cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.Item.ITEM_DES)));
            list.add(item);
        }

        cursor.close();

        return list;
    }

    public void deleteItem(String name){

        SQLiteDatabase db = getWritableDatabase();

        String section = UserMaster.Item.ITEM_NAME + " = ?";

        String[] selectionArgs = { name };

        db.delete(UserMaster.Item.ITEM_NAME,section,selectionArgs);

    }
}
