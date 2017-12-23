package followself.com.bitirmeprojesi;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

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
    private static final String EGZERSIZ_SURE = "SURE";
    private static final String EGZERSIZ_KM = "MESAFE";
    private static final String EGZERSIZ_ADIM = "ADIM_SAYISI";
    private static final String EGZERSIZ_KALORI = "YAKILAN_KALORI";

    private static final String KAN_BASINCI_TABLE = "KAN_BASINCI";
    private static final String KAN_BASINCI_SISTOLIK = "SISTOLIK";
    private static final String KAN_BASINCI_DIYASTOLIK = "DIYASTOLIK";
    private static final String KAN_BASINCI_NABIZ = "NABIZ";
    private static final String KAN_BASINCI_DUZEN = "KALP_ATIS_DUZENI";

    private static final String KAN_SEKERI_TABLE = "KAN_SEKERI";
    private static final String KAN_SEKERI_OLCUM = "OLCUM_DEGERI";
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
    private static final String ALERJILER_TESPIT = "GOZLEM_TARIHI";

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
    private static final String TIBBI_CIHAZLAR_BASLANGIC = "BASLANGIC_TARIHI";

//--------------------------------------------------------------------------------------------------

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + USERS_TABLE + "(" + USERS_ID + " INTEGER PRIMARY KEY," + USERS_ADSOYAD + " TEXT NOT NULL," + USERS_DTARIHI + " TEXT NOT NULL,"
                + USERS_EMAIL + " TEXT NOT NULL," + USERS_SIFRE + " TEXT NOT NULL)");

        db.execSQL("CREATE TABLE BOY(ID INTEGER, UZUNLUK INTEGER, TARIH TEXT NOT NULL, PRIMARY KEY(ID,TARIH), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE KILO(ID INTEGER, AGIRLIK INTEGER, TARIH TEXT NOT NULL, SAAT TEXT NOT NULL, PRIMARY KEY(ID,TARIH,SAAT), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE EGZERSIZ(ID INTEGER, TUR TEXT, SURE INTEGER, MESAFE INTEGER, ADIM_SAYISI INTEGER, YAKILAN_KALORI INTEGER, TARIH TEXT NOT NULL, SAAT TEXT NOT NULL, PRIMARY KEY(ID,TARIH,SAAT), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE KAN_BASINCI(ID INTEGER, SISTOLIK INTEGER, DIYASTOLIK INTEGER, NABIZ INTEGER, KALP_ATIS_DUZENI TEXT, TARIH TEXT NOT NULL, SAAT TEXT NOT NULL, PRIMARY KEY(ID,TARIH,SAAT), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE KAN_SEKERI(ID INTEGER, OLCUM_DEGERI INTEGER, OLCUM_ZAMANI TEXT, OLCUM_TURU TEXT, TARIH TEXT NOT NULL, SAAT TEXT NOT NULL, PRIMARY KEY(ID,TARIH,SAAT), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE KOLESTEROL(ID INTEGER, LDL INTEGER, HDL INTEGER, TRIGLISERIT INTEGER, TOPLAM_KOLESTEROL REAL, TARIH TEXT NOT NULL, SAAT TEXT NOT NULL, PRIMARY KEY(ID,TARIH,SAAT), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE VUCUT_OLCULERI(ID INTEGER, OLCUM_ALANI TEXT, BOYUT INTEGER, TARIH TEXT NOT NULL, PRIMARY KEY(ID,TARIH), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE ILACLAR(ID INTEGER, AD TEXT, ETKINLIK INTEGER, DOZAJ TEXT, ALINMA_SEKLI TEXT, ALINMA_SIKLIGI TEXT, ALINMA_NEDENI TEXT, BASLANGIC_TARIHI TEXT NOT NULL, BITIS_TARIHI TEXT NOT NULL, PRIMARY KEY(ID,AD,BASLANGIC_TARIHI,BITIS_TARIHI), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE BAGISIKLIKLAR(ID INTEGER, ASI_ADI TEXT, OLUMSUZ_ETKILER TEXT, ALINMA_TARIHI TEXT NOT NULL, PRIMARY KEY(ID,ALINMA_TARIHI), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE ALERJILER(ID INTEGER, AD TEXT, BELIRTILER TEXT, TUR TEXT, GOZLEM_TARIHI NOT NULL, PRIMARY KEY(ID,AD,GOZLEM_TARIHI), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE KISILER(ID INTEGER, AD TEXT, UZMANLIKLAR TEXT, IS_YERI TEXT, PRIMARY KEY(ID,AD), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE TIBBI_CIHAZLAR(ID INTEGER, TUR TEXT, URETICI TEXT, VUCUTTAKI_KONUMU TEXT, MODEL TEXT, SERI_NO INTEGER NOT NULL, BASLANGIC_TARIHI TEXT NOT NULL, PRIMARY KEY(ID,SERI_NO,BASLANGIC_TARIHI), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        onCreate(db);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.setForeignKeyConstraintsEnabled(true);
        }
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

    public void kullaniciSil(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] select = {String.valueOf(id).trim()};
        db.delete(USERS_TABLE, USERS_ID + " = ?", select);
        db.close();
    }

    public void sifreDegistir(int id, String sifre) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] selection = {String.valueOf(id).trim()};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_SIFRE, sifre);
        db.update(USERS_TABLE, contentValues, USERS_ID + " = ?", selection);
        db.close();
    }

    public List<String> showUserList() {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {USERS_ID, USERS_ADSOYAD, USERS_DTARIHI, USERS_EMAIL, USERS_SIFRE};
        Cursor c = db.query(USERS_TABLE, columns, null, null, null, null, null);

        while (c.moveToNext()) {
            list.add(c.getInt(0) + " | " + c.getString(1) + " | " + c.getString(2) + " | " + c.getString(3) + " | " + c.getString(4));
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

    public String idYolla(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {USERS_ID};
        String selection = USERS_EMAIL + "=?";
        String[] selectionArgs = {email};
        Cursor c = db.query(USERS_TABLE, columns, selection, selectionArgs, null, null, null);
        String id = null;
        while (c.moveToNext()) {
            id = c.getString(0);
        }
        c.close();
        db.close();
        return id;
    }

    public boolean checkPassword(int id, String sifre) {
        String[] columns = {USERS_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + USERS_SIFRE + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim(), sifre};
        Cursor c = db.query(USERS_TABLE, columns, selection, selectionArgs, null, null, null);
        int cursorCount = c.getCount();
        c.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        } else
            return false;
    }

    //-----------------------------------------------------------------------------------------------------------------

    public void boyEkle(BoyBilgi b) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, b.getId());
        contentValues.put(BOY_CM, b.getBoy());
        contentValues.put(TARIH, b.getTarih());
        db.insert(BOY_TABLE, null, contentValues);
        db.close();
    }

    public void boyGuncelle(int id, int boy, String eskiTarih, String yeniTarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiTarih};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(BOY_CM, boy);
        contentValues.put(TARIH, yeniTarih);
        db.update(BOY_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void boySil(int id, String tarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih};
        db.delete(BOY_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showBoy(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " =?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {USERS_ID, BOY_CM, TARIH};
        Cursor c = db.query(BOY_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add("ID=" + c.getInt(0) + "                    " + c.getInt(1) + "cm                    " + c.getString(2));
        }
        return list;
    }

    //------------------------------------------------------------------------------------------------------------------------------
    public void kiloEkle(KiloBilgi k) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, k.getId());
        contentValues.put(KILO_KG, k.getKilo());
        contentValues.put(TARIH, k.getTarih());
        contentValues.put(SAAT, k.getSaat());
        db.insert(KILO_TABLE, null, contentValues);
        db.close();
    }

    public void kiloGuncelle(int id, int kilo, String eskiTarih, String yeniTarih, String eskiSaat, String yeniSaat) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiTarih, eskiSaat};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(KILO_KG, kilo);
        contentValues.put(TARIH, yeniTarih);
        contentValues.put(SAAT, yeniSaat);
        db.update(KILO_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void kiloSil(int id, String tarih, String saat) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih, saat};
        db.delete(KILO_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showKilo(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " =?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {USERS_ID, KILO_KG, TARIH, SAAT};
        Cursor c = db.query(KILO_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add("ID=" + c.getInt(0) + "            " + c.getInt(1) + "kg            " + c.getString(2) + "            " + c.getString(3));
        }
        return list;
    }

    //------------------------------------------------------------------------------------------------------------------------------
    public void egzersizEkle(EgzersizBilgi eb) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, eb.getId());
        contentValues.put(EGZERSIZ_TUR, eb.getTur());
        contentValues.put(EGZERSIZ_SURE, eb.getSure());
        contentValues.put(EGZERSIZ_KM, eb.getMesafe());
        contentValues.put(EGZERSIZ_ADIM, eb.getAdim());
        contentValues.put(EGZERSIZ_KALORI, eb.getKalori());
        contentValues.put(TARIH, eb.getTarih());
        contentValues.put(SAAT, eb.getSaat());
        db.insert(EGZERSIZ_TABLE, null, contentValues);
        db.close();
    }

    public void egzersizGuncelle(int id, String tur, int sure, int mesafe, int adim, int kalori, String eskiTarih, String yeniTarih, String eskiSaat, String yeniSaat) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiTarih, eskiSaat};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(EGZERSIZ_TUR, tur);
        contentValues.put(EGZERSIZ_SURE, sure);
        contentValues.put(EGZERSIZ_KM, mesafe);
        contentValues.put(EGZERSIZ_ADIM, adim);
        contentValues.put(EGZERSIZ_KALORI, kalori);
        contentValues.put(TARIH, yeniTarih);
        contentValues.put(SAAT, yeniSaat);
        db.update(EGZERSIZ_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void egzersizSil(int id, String tarih, String saat) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih, saat};
        db.delete(EGZERSIZ_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showEgzersiz(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " =?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {USERS_ID, EGZERSIZ_TUR, EGZERSIZ_SURE, EGZERSIZ_KM, EGZERSIZ_ADIM, EGZERSIZ_KALORI, TARIH, SAAT};
        Cursor c = db.query(EGZERSIZ_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add("ID=" + c.getInt(0) + "-" + c.getString(1) + "-" + c.getInt(2) + "dk-" + c.getInt(3) + "m-" + c.getInt(4) + "adım-" + c.getInt(5) + "cal-" + c.getString(6) + "-" + c.getString(7));
        }
        return list;
    }

    //------------------------------------------------------------------------------------------------------------------------------
    public void kanBasinciEkle(KanBasinciBilgi kb) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, kb.getId());
        contentValues.put(KAN_BASINCI_SISTOLIK, kb.getSistolik());
        contentValues.put(KAN_BASINCI_DIYASTOLIK, kb.getDiyastolik());
        contentValues.put(KAN_BASINCI_NABIZ, kb.getNabiz());
        contentValues.put(KAN_BASINCI_DUZEN, kb.getDuzen());
        contentValues.put(TARIH, kb.getTarih());
        contentValues.put(SAAT, kb.getSaat());
        db.insert(KAN_BASINCI_TABLE, null, contentValues);
        db.close();
    }

    public void kanBasinciGuncelle(int id, int sistolik, int diyastolik, int nabiz, String duzen, String eskiTarih, String yeniTarih, String eskiSaat, String yeniSaat) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiTarih, eskiSaat};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(KAN_BASINCI_SISTOLIK, sistolik);
        contentValues.put(KAN_BASINCI_DIYASTOLIK, diyastolik);
        contentValues.put(KAN_BASINCI_NABIZ, nabiz);
        contentValues.put(KAN_BASINCI_DUZEN, duzen);
        contentValues.put(TARIH, yeniTarih);
        contentValues.put(SAAT, yeniSaat);
        db.update(KAN_BASINCI_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void kanBasinciSil(int id, String tarih, String saat) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih, saat};
        db.delete(KAN_BASINCI_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showKanBasinci(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " =?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {USERS_ID, KAN_BASINCI_SISTOLIK, KAN_BASINCI_DIYASTOLIK, KAN_BASINCI_NABIZ, KAN_BASINCI_DUZEN, TARIH, SAAT};
        Cursor c = db.query(KAN_BASINCI_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add("ID=" + c.getInt(0) + "-" + c.getInt(1) + "mmHg-" + c.getInt(2) + "mmHg-" + c.getInt(3) + "-" + c.getString(4) + "-" + c.getString(5) + "-" + c.getString(6));
        }
        return list;
    }

    //------------------------------------------------------------------------------------------------------------------------------
    public void kanSekeriEkle(KanSekeriBilgi ks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, ks.getId());
        contentValues.put(KAN_SEKERI_OLCUM, ks.getOlcum());
        contentValues.put(KAN_SEKERI_ZAMAN, ks.getZaman());
        contentValues.put(KAN_SEKERI_TUR, ks.getTur());
        contentValues.put(TARIH, ks.getTarih());
        contentValues.put(SAAT, ks.getSaat());
        db.insert(KAN_SEKERI_TABLE, null, contentValues);
        db.close();
    }

    public void kanSekeriGuncelle(int id, int olcum, String zaman, String tur, String eskiTarih, String yeniTarih, String eskiSaat, String yeniSaat) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiTarih, eskiSaat};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(KAN_SEKERI_OLCUM, olcum);
        contentValues.put(KAN_SEKERI_ZAMAN, zaman);
        contentValues.put(KAN_SEKERI_TUR, tur);
        contentValues.put(TARIH, yeniTarih);
        contentValues.put(SAAT, yeniSaat);
        db.update(KAN_SEKERI_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void kanSekeriSil(int id, String tarih, String saat) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih, saat};
        db.delete(KAN_SEKERI_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showKanSekeri(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " =?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {USERS_ID, KAN_SEKERI_OLCUM, KAN_SEKERI_ZAMAN, KAN_SEKERI_TUR, TARIH, SAAT};
        Cursor c = db.query(KAN_SEKERI_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add("ID=" + c.getInt(0) + "-" + c.getInt(1) + "mg/dL-" + c.getString(2) + "-" + c.getString(3) + "-" + c.getString(4) + "-" + c.getString(5));
        }
        return list;
    }
//------------------------------------------------------------------------------------------------------------------------------

    public void kolesterolEkle(KolesterolBilgi kol) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, kol.getId());
        contentValues.put(KOLESTEROL_LDL, kol.getLdl());
        contentValues.put(KOLESTEROL_HDL, kol.getHdl());
        contentValues.put(KOLESTEROL_TRIGLISERIT, kol.getTrigliserit());
        contentValues.put(KOLESTEROL_TOPLAM, kol.getToplam());
        contentValues.put(TARIH, kol.getTarih());
        contentValues.put(SAAT, kol.getSaat());
        db.insert(KOLESTEROL_TABLE, null, contentValues);
        db.close();
    }

    public void kolesterolGuncelle(int id, int ldl, int hdl, int trigliserit, int toplam, String eskiTarih, String yeniTarih, String eskiSaat, String yeniSaat) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiTarih, eskiSaat};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(KOLESTEROL_LDL, ldl);
        contentValues.put(KOLESTEROL_HDL, hdl);
        contentValues.put(KOLESTEROL_TRIGLISERIT, trigliserit);
        contentValues.put(KOLESTEROL_TOPLAM, toplam);
        contentValues.put(TARIH, yeniTarih);
        contentValues.put(SAAT, yeniSaat);
        db.update(KOLESTEROL_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void kolesterolSil(int id, String tarih, String saat) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih, saat};
        db.delete(KOLESTEROL_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showKolesterol(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " =?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {USERS_ID, KOLESTEROL_LDL, KOLESTEROL_HDL, KOLESTEROL_TRIGLISERIT, KOLESTEROL_TOPLAM, TARIH, SAAT};
        Cursor c = db.query(KOLESTEROL_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add("ID=" + c.getInt(0) + " " + c.getInt(1) + "mg/dL " + c.getInt(2) + "mg/dL " + c.getInt(3) + "mg/dL " + c.getInt(4) + "mg/dL " + c.getString(5) + " " + c.getString(6));
        }
        return list;
    }
//------------------------------------------------------------------------------------------------------------------------------

    public void vucutOlcuEkle(VucutOlcuBilgi v) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, v.getId());
        contentValues.put(VUCUT_OLCULERI_TUR, v.getTur());
        contentValues.put(VUCUT_OLCULERI_CM, v.getBoyut());
        contentValues.put(TARIH, v.getTarih());
        db.insert(VUCUT_OLCULERI_TABLE, null, contentValues);
        db.close();
    }

    public void vucutOlcuGuncelle(int id, String tur, int boyut, String eskiTarih, String yeniTarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiTarih};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(VUCUT_OLCULERI_TUR, tur);
        contentValues.put(VUCUT_OLCULERI_CM, boyut);
        contentValues.put(TARIH, yeniTarih);
        db.update(VUCUT_OLCULERI_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void vucutOlcuSil(int id, String tarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih};
        db.delete(VUCUT_OLCULERI_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showVucutOlcu(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " =?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {USERS_ID, VUCUT_OLCULERI_TUR,VUCUT_OLCULERI_CM, TARIH};
        Cursor c = db.query(VUCUT_OLCULERI_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add("ID=" + c.getInt(0) + "          " + c.getString(1) + "          " + c.getInt(2) + "cm          " + c.getString(3));
        }
        return list;
    }

//------------------------------------------------------------------------------------------------------------------------------

    public void ilacEkle(IlacBilgi ib) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, ib.getId());
        contentValues.put(ILAC_ADI, ib.getAd());
        contentValues.put(ILAC_ETKINLIK, ib.getEtkinlik());
        contentValues.put(ILAC_DOZAJ, ib.getDozaj());
        contentValues.put(ILAC_ALINMA_SEKLI, ib.getSekil());
        contentValues.put(ILAC_ALINMA_SIKLIGI, ib.getSiklik());
        contentValues.put(ILAC_ALINMA_NEDENI, ib.getNeden());
        contentValues.put(ILAC_BASLANGIC, ib.getBaslangic());
        contentValues.put(ILAC_BITIS, ib.getBitis());
        db.insert(ILACLAR_TABLE, null, contentValues);
        db.close();
    }

    public void ilacGuncelle(int id, String eskiAd, String yeniAd, int etkinlik, String dozaj, String sekil, String siklik, String neden, String eskiBaslangic, String yeniBaslangic, String eskiBitis, String yeniBitis) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + ILAC_ADI + " = ?" + " AND " + ILAC_BASLANGIC + " =? " + " AND " + ILAC_BITIS + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiAd, eskiBaslangic, eskiBitis};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(ILAC_ADI, yeniAd);
        contentValues.put(ILAC_ETKINLIK, etkinlik);
        contentValues.put(ILAC_DOZAJ, dozaj);
        contentValues.put(ILAC_ALINMA_SEKLI, sekil);
        contentValues.put(ILAC_ALINMA_SIKLIGI, siklik);
        contentValues.put(ILAC_ALINMA_NEDENI, neden);
        contentValues.put(ILAC_BASLANGIC, yeniBaslangic);
        contentValues.put(ILAC_BITIS, yeniBitis);
        db.update(ILACLAR_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void ilacSil(int id, String ad, String baslangic, String bitis) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + ILAC_ADI + " = ?" + " AND " + ILAC_BASLANGIC + " =? " + " AND " + ILAC_BITIS + " =? ";
        String[] selectionArgs = {String.valueOf(id).trim(), ad, baslangic, bitis};
        db.delete(ILACLAR_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showIlac(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " =?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {USERS_ID, ILAC_ADI, ILAC_ETKINLIK, ILAC_DOZAJ, ILAC_ALINMA_SEKLI, ILAC_ALINMA_SIKLIGI, ILAC_ALINMA_NEDENI, ILAC_BASLANGIC, ILAC_BITIS};
        Cursor c = db.query(ILACLAR_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add("ID=" + c.getInt(0) + "-" + c.getString(1) + "-" + c.getInt(2) + "mg-" + c.getString(3) + "-" + c.getString(4) + "-" + c.getString(5) + "-" + c.getString(6) + "-" + c.getString(7) + "-" + c.getString(8));
        }
        return list;
    }
}


