package einkaufsliste.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database.
    public static String DATABASE_NAME = "ShoppingList.db";

    // Database tables.
    private static String articles = "articles";
    private static String shoppinglists = "shoppinglists";
    private static String shoppinglistItems = "shoppinglistItems";

    // Database table attributes.
    private static String artId = "artId";
    private static String artName = "artName";
    private static String artComment = "artComment";
    private static String artDateAdded = "artDateAdded";

    private static String listId = "listId";
    private static String listName = "listName";
    private static String listPriceSum = "listPriceSum";
    private static String listDateAdded = "listDateAdded";
    private static String listFinished = "listFinished";
    private static String listDateFinished = "listDateFinished";

    private static String itemId = "itemId";
    private static String itemAmount = "itemAmount";
    private static String itemPrice = "itemPrice";
    private static String itemDateAdded = "itemDateAdded";
    private static String itemFinished = "itemFinished";
    private static String itemDateFinished = "itemDateFinished";

    // Other.
    public static long unixTime;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
//        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        // this might only work since SQLite version 3.6.19 and respectively Android 2.2 Froyo.
        db.execSQL("PRAGMA foreign_keys=ON");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table " +
                articles + " (" +
                artId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                artName + " TEXT, " +
                artComment + "TEXT, " +
                artDateAdded + "INTEGER)"
        );
        db.execSQL("CREATE table " +
                shoppinglists + " (" +
                listId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                listName + " TEXT, " +
                listPriceSum + " REAL, " +
                listDateAdded + " INTEGER, " +
                listFinished + "INTEGER, " +
                listDateFinished + " INTEGER)"
        );
        // Foreign keys??
        db.execSQL("CREATE table " +
                shoppinglistItems + " (" +
                itemId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                artId + " INTEGER NOT NULL, " +
                listId + " INTEGER NOT NULL, " +
                itemAmount + " REAL, " +
                itemPrice + " REAL, " +
                itemDateAdded + " INTEGER, " +
                itemFinished + " INTEGER, " +
                itemDateFinished + " INTEGER)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + articles);
        db.execSQL("DROP TABLE IF EXISTS " + shoppinglists);
        db.execSQL("DROP TABLE IF EXISTS " + shoppinglistItems);
    }

    public boolean insertArticle(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(artName, name);
        long result = db.insert(articles, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

//    public boolean insertShoppinglist(String name) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(artName, name);
//        long result = db.insert(articles, null, contentValues);
//
//        if (result == -1) {
//            return false;
//        } else {
//            return true;
//        }
//
//    }

    public long getUnixTimeStamp() {
        return unixTime = System.currentTimeMillis() / 1000L;
    }


}
