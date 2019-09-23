package com.example.databasetest;

import android.provider.BaseColumns;

public class UserMaster {

    private UserMaster() {}

    public static class Item implements BaseColumns{
        public static final String TABLE_NAME = "Item";
        public static final String ITEM_NAME = "Item_Name";
        public static final String ITEM_DES = "Item_Des";
    }
}
