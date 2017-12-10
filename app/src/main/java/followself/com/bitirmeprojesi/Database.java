package followself.com.bitirmeprojesi;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FOLLOWSELF";
    private static final int DATABASE_VERSION = 1;
    private static final String USERS_TABLE = "USERS";
    private static final String USERS_ID = "ID";
    private static final String USERS_EMAIL = "EMAIL";
    private static final String USERS_SIFRE = "SIFRE";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + USERS_TABLE + "(" + USERS_ID + " INTEGER PRIMARY KEY," + USERS_EMAIL + " TEXT NOT NULL,"
                + USERS_SIFRE + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        onCreate(db);
    }

    public void insert(UyelikBilgi ub) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_EMAIL, ub.getEmail());
        contentValues.put(USERS_SIFRE, ub.getSifre());

        db.insert(USERS_TABLE, null, contentValues);
        db.close();

    }

    public List<String> showList() {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {USERS_ID, USERS_EMAIL, USERS_SIFRE};
        Cursor c = db.query(USERS_TABLE, columns, null, null, null, null, null);

        while (c.moveToNext()) {
            list.add(c.getInt(0) + " - " + c.getString(1) + " - " + c.getString(2));
        }

        return list;
    }

    public boolean checkUser(String email) {
        String[] columns = {USERS_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_EMAIL + " = ?";
        String[] selectionArgs = {email};
        Cursor c = db.query(USERS_TABLE, columns, selection, selectionArgs, null, null, null);
        int cursorCount = c.getCount();
        c.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        } else
            return false;
    }

    public boolean checkUser(String email, String sifre) {
        String[] columns = {USERS_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_EMAIL + " = ?" + " AND " + USERS_SIFRE + " = ?";
        String[] selectionArgs = {email, sifre};
        Cursor c = db.query(USERS_TABLE, columns, selection, selectionArgs, null, null, null);
        int cursorCount = c.getCount();
        c.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public String sifreGoster(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {USERS_SIFRE};
        String selection = USERS_EMAIL + "=?";
        String[] selectionArgs = {email};
        Cursor c = db.query(USERS_TABLE, columns, selection, selectionArgs, null, null, null);
        String sifre = null;
        while (c.moveToNext()) {
            sifre = c.getString(0);
        }
        return sifre;
    }
}