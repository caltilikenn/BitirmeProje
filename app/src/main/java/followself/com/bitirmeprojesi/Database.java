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
    private static final String USERS_TABLE = "KULLANICILAR";
    private static final String USERS_ADSOYAD = "AD_SOYAD";
    private static final String USERS_DTARIHI = "DOGUM_TARIHI";
    private static final String USERS_ID = "ID";
    private static final String USERS_EMAIL = "EMAIL";
    private static final String USERS_SIFRE = "SIFRE";
    private static final String TARIH = "TARIH";
    private static final String SAAT = "SAAT";

//--------------------------------------------------------------------------------------------------

    private static final String BOY_TABLE = "BOY";
    private static final String BOY_CM = "UZUNLUK";

    private static final String KILO_TABLE = "KILO";
    private static final String KILO_KG = "AGIRLIK";

    private static final String EGZERSIZ_TABLE = "EGZERSIZ";
    private static final String EGZERSIZ_TUR = "TUR";
    private static final String EGZERSIZ_SURE = "SURESI";
    private static final String EGZERSIZ_KM = "MESAFE";
    private static final String EGZERSIZ_ADIM = "ADIM_SAYISI";
    private static final String EGZERSIZ_KALORI = "YAKILAN_KALORI";

    private static final String KAN_BASINCI_TABLE = "KAN_BASINCI";
    private static final String KAN_BASINCI_SISTOLIK = "SISTOLIK";
    private static final String KAN_BASINCI_DIYASTOLIK = "DIYASTOLIK";
    private static final String KAN_BASINCI_NABIZ = "NABIZ";
    private static final String KAN_BASINCI_DUZEN = "KALP_ATIS_DUZENI";

    private static final String KAN_SEKERI_TABLE = "KAN_SEKERI";
    private static final String KAN_SEKERI_OLCUM = "OLCUM";
    private static final String KAN_SEKERI_ZAMAN = "OLCUM_ZAMANI";
    private static final String KAN_SEKERI_TUR = "OLCUM_TURU";

    private static final String KOLESTEROL_TABLE = "KOLESTEROL";
    private static final String KOLESTEROL_LDL = "LDL";
    private static final String KOLESTEROL_HDL = "HDL";
    private static final String KOLESTEROL_TRIGLISERIT = "TRIGLISERIT";
    private static final String KOLESTEROL_TOPLAM = "TOPLAM_KOLESTEROL";

    private static final String VUCUT_OLCULERI_TABLE = "VUCUT_OLCULERI";
    private static final String VUCUT_OLCULERI_TUR = "OLCUM_ALANI";
    private static final String VUCUT_OLCULERI_CM = "BOYUT";

//--------------------------------------------------------------------------------------------------

    private static final String ILACLAR_TABLE = "ILACLAR";
    private static final String ILAC_ADI = "AD";
    private static final String ILAC_ETKINLIK = "ETKINLIK";
    private static final String ILAC_DOZAJ = "DOZAJ";
    private static final String ILAC_ALINMA_SEKLI = "ALINMA_SEKLI";
    private static final String ILAC_ALINMA_SIKLIGI = "ALINMA_SIKLIGI";
    private static final String ILAC_ALINMA_NEDENI = "ALINMA_NEDENI";
    private static final String ILAC_BASLANGIC = "BASLANGIC_TARIHI";
    private static final String ILAC_BITIS = "BITIS_TARIHI";

    private static final String BAGISIKLIKLAR_TABLE = "BAGISIKLIKLAR";
    private static final String BAGISIKLIKLAR_AD = "ASI_ADI";
    private static final String BAGISIKLIKLAR_TARIH = "ALINMA_TARIHI";
    private static final String BAGISIKLIKLAR_ETKI = "OLUMSUZ_ETKILER";

    private static final String ALERJILER_TABLE = "ALERJILER";
    private static final String ALERJILER_AD = "AD";
    private static final String ALERJILER_BELIRTI = "BELIRTILER";
    private static final String ALERJILER_TUR = "TUR";
    private static final String ALERJILER_TESPIT = "ILK_GOZLEMLEME";

    private static final String KISILER_TABLE = "KISILER";
    private static final String KISILER_AD = "AD";
    private static final String KISLER_UZMANLIK = "UZMANLIKLAR";
    private static final String KISILER_ISYERI = "IS_YERI";

    private static final String TIBBI_CIHAZLAR_TABLE = "TIBBI_CIHAZLAR";
    private static final String TIBBI_CIHAZLAR_TUR = "TUR";
    private static final String TIBBI_CIHAZLAR_URETICI = "URETICI";
    private static final String TIBBI_CIHAZLAR_KONUM = "VUCUTTAKI_KONUMU";
    private static final String TIBBI_CIHAZLAR_MODEL = "MODEL";
    private static final String TIBBI_CIHAZLAR_SERI = "SERI_NO";

//--------------------------------------------------------------------------------------------------

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + USERS_TABLE + "(" + USERS_ID + " INTEGER PRIMARY KEY," + USERS_ADSOYAD + " TEXT NOT NULL," + USERS_DTARIHI + " TEXT NOT NULL,"
                + USERS_EMAIL + " TEXT NOT NULL," + USERS_SIFRE + " TEXT NOT NULL)");

     /*   db.execSQL("CREATE TABLE " + BOY_TABLE + "(" + USERS_ID + " INTEGER," + BOY_CM + " INTEGER NOT NULL," + TARIH + " TEXT,"
                + "PRIMARY KEY("+ USERS_ID + "," + TARIH + "), FOREIGN KEY(" + USERS_ID + " ) REFERENCES " + USERS_TABLE + "(" + USERS_ID + ") ON DELETE CASCADE)");

    */}

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

    public void kullaniciSil(UyelikBilgi ub) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] id = {String.valueOf(ub.getId())};
        db.delete(USERS_TABLE, USERS_ID + "=?", id);
        db.close();
    }

    public void sifreDegistir(UyelikBilgi ub) {
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
        c.close();
        db.close();
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
        c.close();
        db.close();
        return ad;
    }

    public int idYolla(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {USERS_ID};
        String[] selectionArgs = {email};
        Cursor c = db.query(USERS_TABLE, columns, email, selectionArgs, null, null, null);
        Integer id = 0;
        while (c.moveToFirst()) {
            id = c.getInt(0);
        }
        c.close();
        db.close();
        return id;
    }


    //-----------------------------------------------------------------------------------------------------------------

    public void boyEkle(Boy b) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, b.getId());
        contentValues.put(BOY_CM, b.getBoy());
        contentValues.put(TARIH, b.getTarih());

        db.insert(BOY_TABLE, null, contentValues);
        db.close();
    }
}




