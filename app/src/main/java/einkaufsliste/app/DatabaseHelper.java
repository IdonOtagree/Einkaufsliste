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

    // Database table attributes.
    private static String articleId = "articleId";
    private static String articleName = "articleName";
    private static String articleAmount = "articleAmount";
    private static String articleTimeAdded = "articleTimeAdded";

    // Other.
    public static long unixTime;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table " +
                articles + " (" +
                articleId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                articleName + " TEXT, " +
                articleAmount + " INTEGER, " +
                articleTimeAdded + " INTEGER)"
        );
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + articles);
    }

    public void insertArticle(String name, int amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(articleName, name);
        contentValues.put(articleAmount, amount);
        contentValues.put(articleAmount, getUnixTimeStamp());

        db.insert(articles, null, contentValues);
    }

    private long getUnixTimeStamp() {
        return unixTime = System.currentTimeMillis() / 1000L;
    }

}
