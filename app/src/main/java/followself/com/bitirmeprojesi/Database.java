package followself.com.bitirmeprojesi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class Database extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="FOLLOWSELF";
    private static final int DATABASE_VERSION =1;
    private static final String USERS_TABLE="USERS";
    private static final String USERS_ID="ID";
    private static final String USERS_EMAIL="EMAIL";
    private static final String USERS_SIFRE="SIFRE";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +USERS_TABLE+ "("+USERS_ID+ " INTEGER PRIMARY KEY,"+USERS_EMAIL+" TEXT NOT NULL,"
                                                 +USERS_SIFRE+ " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + USERS_TABLE);
        onCreate(db);
    }

    public long insert(UyelikBilgi ub){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_EMAIL,ub.getEmail());
        contentValues.put(USERS_SIFRE,ub.getSifre());

        long id = db.insert(USERS_TABLE,null,contentValues);
        db.close();
        return id;

    }

    public List<UyelikBilgi> showList() {
        List<UyelikBilgi> list = new ArrayList<UyelikBilgi>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + USERS_TABLE, null);
        int noID = c.getColumnIndex("ID");
        int noEmail = c.getColumnIndex("EMAIL");
        int noSifre = c.getColumnIndex("SIFRE");

        try{
            while(c.moveToNext()){
                UyelikBilgi ub = new UyelikBilgi(c.getString(noEmail),c.getString(noSifre));
                ub.setId(c.getInt(noID));
                list.add(ub);
            }
        }
        finally {
        c.close();
        db.close();
        }
        return list;
    }
}
