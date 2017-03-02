package einkaufsliste.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
        contentValues.put(articleTimeAdded, getUnixTimeStamp());

        db.insert(articles, null, contentValues);
    }

    // Getting All Shops
    public List<Article> getArticleList() {
        List<Article> articleList = new ArrayList<Article>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + articles;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Article article = new Article();
                article.setArticleName(cursor.getString(1));
                article.setArticleAmount(Double.parseDouble(cursor.getString(2)));
                // Adding contact to list
                articleList.add(article);
            } while (cursor.moveToNext());
        }
        // return contact list
        return articleList;
    }

    private long getUnixTimeStamp() {
        return unixTime = System.currentTimeMillis() / 1000L;
    }

}
