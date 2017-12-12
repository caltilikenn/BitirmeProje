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
    private static final String USERS_ADSOYAD = "AD_SOYAD";
    private static final String USERS_DTARIHI = "DOGUM_TARIHI";
    private static final String USERS_ID = "ID";
    private static final String USERS_EMAIL = "EMAIL";
    private static final String USERS_SIFRE = "SIFRE";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + USERS_TABLE + "(" + USERS_ID + " INTEGER PRIMARY KEY," + USERS_ADSOYAD + " TEXT NOT NULL," + USERS_DTARIHI + " TEXT NOT NULL," + USERS_EMAIL + " TEXT NOT NULL,"
                + USERS_SIFRE + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        onCreate(db);
    }

    public void kullaniciEkle(UyelikBilgi ub) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ADSOYAD, ub.getAd());
        contentValues.put(USERS_DTARIHI, ub.getDtarihi());
        contentValues.put(USERS_EMAIL, ub.getEmail());
        contentValues.put(USERS_SIFRE, ub.getSifre());

        db.insert(USERS_TABLE, null, contentValues);
        db.close();
    }

    public void kullaniciSil(UyelikBilgi ub){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] id = {String.valueOf(ub.getId())};
        db.delete(USERS_TABLE, USERS_ID + "=?", id );
        db.close();
    }

    public void sifreDegistir(UyelikBilgi ub){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] id = {String.valueOf(ub.getId())};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_SIFRE, ub.getSifre());
        db.update(USERS_TABLE, contentValues, USERS_ID + " = ?", id);
        db.close();
    }

    public List<String> showUserList() {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {USERS_ID, USERS_ADSOYAD, USERS_DTARIHI, USERS_EMAIL, USERS_SIFRE};
        Cursor c = db.query(USERS_TABLE, columns, null, null, null, null, null);

        while (c.moveToNext()) {
            list.add(c.getInt(0) + " - " + c.getString(1) + " - " + c.getString(2) + " - " + c.getString(3) + " - " + c.getString(4));
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

    public String isimGoster(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {USERS_ADSOYAD};
        String selection = USERS_EMAIL + "=?";
        String[] selectionArgs = {email};
        Cursor c = db.query(USERS_TABLE, columns, selection, selectionArgs, null, null, null);
        String ad = null;
        while (c.moveToNext()) {
            ad = c.getString(0);
        }
        return ad;
    }
}
//-------------------------------------------------------------------------------------------------------------------------------




