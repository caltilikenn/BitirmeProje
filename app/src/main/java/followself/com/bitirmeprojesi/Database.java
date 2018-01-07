package followself.com.bitirmeprojesi;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private static final String USERS_ULKE = "ULKE";
    private static final String USERS_IL = "IL";
    private static final String USERS_CINSIYET = "CINSIYET";

    private static final String RESIMLER_TABLE = "RESIMLER";
    private static final String RESIM_AD = "AD";
    private static final String RESIM = "RESIM";
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
    private static final String BAGISIKLIKLAR_ETKI = "OLUMSUZ_ETKILER";
    private static final String BAGISIKLIKLAR_TARIH = "ALINMA_TARIHI";


    private static final String ALERJILER_TABLE = "ALERJILER";
    private static final String ALERJILER_AD = "AD";
    private static final String ALERJILER_BELIRTI = "BELIRTILER";
    private static final String ALERJILER_TUR = "TUR";
    private static final String ALERJILER_TESPIT = "GOZLEM_TARIHI";

    private static final String KISILER_TABLE = "KISILER";
    private static final String KISILER_AD = "AD";
    private static final String KISILER_UZMANLIK = "UZMANLIKLAR";
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
                + USERS_EMAIL + " TEXT NOT NULL," + USERS_SIFRE + " TEXT NOT NULL," + USERS_ULKE + " TEXT," + USERS_IL + " TEXT," + USERS_CINSIYET + " TEXT)");

        db.execSQL("CREATE TABLE RESIMLER(ID INTEGER,AD TEXT NOT NULL, RESIM BLOB, PRIMARY KEY(ID,AD), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE BOY(ID INTEGER, UZUNLUK INTEGER, TARIH TEXT NOT NULL, PRIMARY KEY(ID,TARIH), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE KILO(ID INTEGER, AGIRLIK INTEGER, TARIH TEXT NOT NULL, SAAT TEXT NOT NULL, PRIMARY KEY(ID,TARIH,SAAT), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE EGZERSIZ(ID INTEGER, TUR TEXT, SURE INTEGER, MESAFE INTEGER, ADIM_SAYISI INTEGER, YAKILAN_KALORI INTEGER, TARIH TEXT NOT NULL, SAAT TEXT NOT NULL, PRIMARY KEY(ID,TARIH,SAAT), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE KAN_BASINCI(ID INTEGER, SISTOLIK INTEGER, DIYASTOLIK INTEGER, NABIZ INTEGER, KALP_ATIS_DUZENI TEXT, TARIH TEXT NOT NULL, SAAT TEXT NOT NULL, PRIMARY KEY(ID,TARIH,SAAT), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE KAN_SEKERI(ID INTEGER, OLCUM_DEGERI INTEGER, OLCUM_ZAMANI TEXT, OLCUM_TURU TEXT, TARIH TEXT NOT NULL, SAAT TEXT NOT NULL, PRIMARY KEY(ID,TARIH,SAAT), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE KOLESTEROL(ID INTEGER, LDL INTEGER, HDL INTEGER, TRIGLISERIT INTEGER, TOPLAM_KOLESTEROL REAL, TARIH TEXT NOT NULL, SAAT TEXT NOT NULL, PRIMARY KEY(ID,TARIH,SAAT), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE VUCUT_OLCULERI(ID INTEGER, OLCUM_ALANI TEXT, BOYUT INTEGER, TARIH TEXT NOT NULL, PRIMARY KEY(ID,TARIH), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE ILACLAR(ID INTEGER, AD TEXT, ETKINLIK INTEGER, DOZAJ TEXT, ALINMA_SEKLI TEXT, ALINMA_SIKLIGI TEXT, ALINMA_NEDENI TEXT, BASLANGIC_TARIHI TEXT NOT NULL, BITIS_TARIHI TEXT NOT NULL, PRIMARY KEY(ID,AD,BASLANGIC_TARIHI,BITIS_TARIHI), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE BAGISIKLIKLAR(ID INTEGER, ASI_ADI TEXT, OLUMSUZ_ETKILER TEXT, ALINMA_TARIHI TEXT, PRIMARY KEY(ID,ASI_ADI,ALINMA_TARIHI), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE ALERJILER(ID INTEGER, AD TEXT, BELIRTILER TEXT, TUR TEXT, GOZLEM_TARIHI NOT NULL, PRIMARY KEY(ID,AD,GOZLEM_TARIHI), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE KISILER(ID INTEGER, AD TEXT, UZMANLIKLAR TEXT, IS_YERI TEXT, PRIMARY KEY(ID,AD), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");

        db.execSQL("CREATE TABLE TIBBI_CIHAZLAR(ID INTEGER, TUR TEXT, URETICI TEXT, VUCUTTAKI_KONUMU TEXT, MODEL TEXT, SERI_NO TEXT NOT NULL, BASLANGIC_TARIHI TEXT NOT NULL, PRIMARY KEY(ID,SERI_NO,BASLANGIC_TARIHI), FOREIGN KEY(ID) REFERENCES KULLANICILAR(ID) ON DELETE CASCADE)");
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
        String selection = USERS_EMAIL + " =?";
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
        String selection = USERS_EMAIL + " = ?";
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
        String selection = USERS_EMAIL + " = ?";
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
        String selection = USERS_EMAIL + " = ?";
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

    public void resimEkle(BelgelerBilgi bb)  {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, bb.getId());
        contentValues.put(RESIM_AD, bb.getAd());
        contentValues.put(RESIM, bb.getResim());
        db.insert(RESIMLER_TABLE, null, contentValues);
        db.close();
    }

    public byte[] resimGoster(int id,String ad) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {RESIM};
        String selection = USERS_ID + " = ?" + " AND " + RESIM_AD + " = ?";
        String[] selectionArgs = {String.valueOf(id),ad};
        Cursor c = db.query(RESIMLER_TABLE, columns, selection, selectionArgs, null, null, null);
        byte[] resim = new byte[0];
        while (c.moveToNext()) {
            resim = c.getBlob(0);
        }
        c.close();
        db.close();
        return resim;
    }

    public void resimSil(int id, String ad) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + RESIM_AD + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim(), ad};
        db.delete(RESIMLER_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showResimler(int id) {
        List<String> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {RESIM_AD};
        Cursor c = db.query(RESIMLER_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getString(0));
        }
        return list;
    }

    //-----------------------------------------------------------------------------------------------------------------

    public String profil(int id, int i) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {USERS_ADSOYAD,USERS_EMAIL,USERS_DTARIHI,USERS_ULKE,USERS_IL,USERS_CINSIYET};
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        Cursor c = db.query(USERS_TABLE, columns, selection, selectionArgs, null, null, null);
        String[] dizi = null;
        while (c.moveToNext()) {
            dizi = new String[]{c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5)};
        }
        c.close();
        db.close();
        assert dizi != null;
        return dizi[i];
    }

    public void profilGuncelle(int id, String ad, String email, String dtarihi, String ulke, String il, String cinsiyet) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(USERS_ADSOYAD, ad);
        contentValues.put(USERS_EMAIL, email);
        contentValues.put(USERS_DTARIHI, dtarihi);
        contentValues.put(USERS_ULKE, ulke);
        contentValues.put(USERS_IL, il);
        contentValues.put(USERS_CINSIYET, cinsiyet);
        db.update(USERS_TABLE, contentValues, selection, selectionArgs);
        db.close();
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
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {BOY_CM, TARIH};
        Cursor c = db.query(BOY_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getInt(0) + "cm     -     " + c.getString(1));
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
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " = ? ";
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
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " = ? ";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih, saat};
        db.delete(KILO_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showKilo(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {KILO_KG, TARIH, SAAT};
        Cursor c = db.query(KILO_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getInt(0) + "kg   -   " + c.getString(1) + "   -   " + c.getString(2));
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
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " = ? ";
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
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " = ? ";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih, saat};
        db.delete(EGZERSIZ_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showEgzersiz(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {EGZERSIZ_TUR, EGZERSIZ_SURE, EGZERSIZ_KM, EGZERSIZ_ADIM, EGZERSIZ_KALORI, TARIH, SAAT};
        Cursor c = db.query(EGZERSIZ_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getString(0) + " - " + c.getInt(1) + "dk - " + c.getInt(2) + "m - " + c.getInt(3) + "adım - " + c.getInt(4) + "cal - " + c.getString(5) + " - " + c.getString(6));
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
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " = ? ";
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
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " = ? ";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih, saat};
        db.delete(KAN_BASINCI_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showKanBasinci(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {KAN_BASINCI_SISTOLIK, KAN_BASINCI_DIYASTOLIK, KAN_BASINCI_NABIZ, KAN_BASINCI_DUZEN, TARIH, SAAT};
        Cursor c = db.query(KAN_BASINCI_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getInt(0) + "mmHg - " + c.getInt(1) + "mmHg - " + c.getInt(2) + " - " + c.getString(3) + " - " + c.getString(4) + " - " + c.getString(5));
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
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " = ? ";
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
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " = ? ";
        String[] selectionArgs = {String.valueOf(id).trim(), tarih, saat};
        db.delete(KAN_SEKERI_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showKanSekeri(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {KAN_SEKERI_OLCUM, KAN_SEKERI_ZAMAN, KAN_SEKERI_TUR, TARIH, SAAT};
        Cursor c = db.query(KAN_SEKERI_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getInt(0) + "mg/dL - " + c.getString(1) + " - " + c.getString(2) + " - " + c.getString(3) + " - " + c.getString(4));
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
        String selection = USERS_ID + " = ?" + " AND " + TARIH + " = ?" + " AND " + SAAT + " = ? ";
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
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {KOLESTEROL_LDL, KOLESTEROL_HDL, KOLESTEROL_TRIGLISERIT, KOLESTEROL_TOPLAM, TARIH, SAAT};
        Cursor c = db.query(KOLESTEROL_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getInt(0) + "mg/dL - " + c.getInt(1) + "mg/dL - " + c.getInt(2) + "mg/dL - " + c.getInt(3) + "mg/dL - " + c.getString(4) + " - " + c.getString(5));
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
        String[] columns = {VUCUT_OLCULERI_TUR,VUCUT_OLCULERI_CM, TARIH};
        Cursor c = db.query(VUCUT_OLCULERI_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getString(0) + "          " + c.getInt(1) + "cm          " + c.getString(2));
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
        String selection = USERS_ID + " = ?" + " AND " + ILAC_ADI + " = ?" + " AND " + ILAC_BASLANGIC + " = ? " + " AND " + ILAC_BITIS + " = ? ";
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
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {ILAC_ADI, ILAC_ETKINLIK, ILAC_DOZAJ, ILAC_ALINMA_SEKLI, ILAC_ALINMA_SIKLIGI, ILAC_ALINMA_NEDENI, ILAC_BASLANGIC, ILAC_BITIS};
        Cursor c = db.query(ILACLAR_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getString(0) + " - " + c.getInt(1) + "mg - " + c.getString(2) + " - " + c.getString(3) + " - " + c.getString(4) + " - " + c.getString(5) + " - " + c.getString(6) + " - " + c.getString(7));
        }
        return list;
    }
    //------------------------------------------------------------------------------------------------------------------------------

    public void bagisiklikEkle(BagisiklikBilgi bb) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, bb.getId());
        contentValues.put(BAGISIKLIKLAR_AD, bb.getAd());
        contentValues.put(BAGISIKLIKLAR_ETKI, bb.getEtki());
        contentValues.put(BAGISIKLIKLAR_TARIH, bb.getTarih());
        db.insert(BAGISIKLIKLAR_TABLE, null, contentValues);
        db.close();
    }

    public void bagisiklikGuncelle(int id, String eskiAd, String yeniAd, String etki, String eskiTarih, String yeniTarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + BAGISIKLIKLAR_AD + " = ?" + " AND " + BAGISIKLIKLAR_TARIH + " = ? ";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiAd, eskiTarih};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(BAGISIKLIKLAR_AD, yeniAd);
        contentValues.put(BAGISIKLIKLAR_ETKI, etki);
        contentValues.put(BAGISIKLIKLAR_TARIH, yeniTarih);
        db.update(BAGISIKLIKLAR_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void bagisiklikSil(int id, String ad, String tarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + BAGISIKLIKLAR_AD + " = ?" + " AND " + BAGISIKLIKLAR_TARIH + " = ? ";
        String[] selectionArgs = {String.valueOf(id).trim(), ad, tarih};
        db.delete(BAGISIKLIKLAR_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showBagisiklik(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {BAGISIKLIKLAR_AD, BAGISIKLIKLAR_ETKI, BAGISIKLIKLAR_TARIH};
        Cursor c = db.query(BAGISIKLIKLAR_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getString(0) + "   -   " + c.getString(1) + "   -   " + c.getString(2));
        }
        return list;
    }
    //-------------------------------------------------------------------------------------------------------------------------------------

    public void alerjiEkle(AlerjiBilgi a) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, a.getId());
        contentValues.put(ALERJILER_AD, a.getAd());
        contentValues.put(ALERJILER_BELIRTI, a.getBelirti());
        contentValues.put(ALERJILER_TUR, a.getTur());
        contentValues.put(ALERJILER_TESPIT, a.getTarih());
        db.insert(ALERJILER_TABLE, null, contentValues);
        db.close();
    }

    public void alerjiGuncelle(int id, String eskiAd, String yeniAd, String belirti, String tur, String eskiTarih, String yeniTarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + ALERJILER_AD + " = ?" + " AND " + ALERJILER_TESPIT + " = ? ";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiAd, eskiTarih};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(ALERJILER_AD, yeniAd);
        contentValues.put(ALERJILER_BELIRTI, belirti);
        contentValues.put(ALERJILER_TUR, tur);
        contentValues.put(ALERJILER_TESPIT, yeniTarih);
        db.update(ALERJILER_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void alerjiSil(int id, String ad, String tarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + ALERJILER_AD + " = ?" + " AND " + ALERJILER_TESPIT + " = ? ";
        String[] selectionArgs = {String.valueOf(id).trim(), ad, tarih};
        db.delete(ALERJILER_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showAlerji(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {ALERJILER_AD, ALERJILER_BELIRTI, ALERJILER_TUR, ALERJILER_TESPIT};
        Cursor c = db.query(ALERJILER_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getString(0) + "  -  " + c.getString(1) + "  -  " + c.getString(2) + "  -  " + c.getString(3));
        }
        return list;
    }
    //-------------------------------------------------------------------------------------------------------------------------------------

    public void kisiEkle(KisilerBilgi kb) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, kb.getId());
        contentValues.put(KISILER_AD, kb.getAd());
        contentValues.put(KISILER_UZMANLIK, kb.getUzmanlik());
        contentValues.put(KISILER_ISYERI, kb.getIsyeri());
        db.insert(KISILER_TABLE, null, contentValues);
        db.close();
    }

    public void kisiGuncelle(int id, String eskiAd, String yeniAd, String yeniUzmanlik, String yeniIsyeri) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + KISILER_AD + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiAd};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(KISILER_AD, yeniAd);
        contentValues.put(KISILER_UZMANLIK, yeniUzmanlik);
        contentValues.put(KISILER_ISYERI, yeniIsyeri);
        db.update(KISILER_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void kisiSil(int id, String ad) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + KISILER_AD + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim(), ad};
        db.delete(KISILER_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showKisi(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {KISILER_AD, KISILER_UZMANLIK, KISILER_ISYERI};
        Cursor c = db.query(KISILER_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getString(0) + "   -   " + c.getString(1) + "   -   " + c.getString(2));
        }
        return list;
    }
    //------------------------------------------------------------------------------------------------------------------------------

    public void tibbiCihazEkle(TibbiCihazBilgi tb) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, tb.getId());
        contentValues.put(TIBBI_CIHAZLAR_TUR, tb.getTur());
        contentValues.put(TIBBI_CIHAZLAR_URETICI, tb.getUretici());
        contentValues.put(TIBBI_CIHAZLAR_KONUM, tb.getKonum());
        contentValues.put(TIBBI_CIHAZLAR_MODEL, tb.getModel());
        contentValues.put(TIBBI_CIHAZLAR_SERI, tb.getSerino());
        contentValues.put(TIBBI_CIHAZLAR_BASLANGIC, tb.getTarih());
        db.insert(TIBBI_CIHAZLAR_TABLE, null, contentValues);
        db.close();
    }

    public void tibbiCihazGuncelle(int id, String yeniTur, String uretici, String konum, String model, String eskiSerino, String yeniSerino,  String eskiTarih, String yeniTarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TIBBI_CIHAZLAR_SERI + " = ?" + " AND " + TIBBI_CIHAZLAR_BASLANGIC + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim(), eskiSerino, eskiTarih};
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_ID, id);
        contentValues.put(TIBBI_CIHAZLAR_TUR, yeniTur);
        contentValues.put(TIBBI_CIHAZLAR_URETICI, uretici);
        contentValues.put(TIBBI_CIHAZLAR_KONUM, konum);
        contentValues.put(TIBBI_CIHAZLAR_MODEL, model);
        contentValues.put(TIBBI_CIHAZLAR_SERI, yeniSerino);
        contentValues.put(TIBBI_CIHAZLAR_BASLANGIC, yeniTarih);
        db.update(TIBBI_CIHAZLAR_TABLE, contentValues, selection, selectionArgs);
        db.close();
    }

    public void tibbiCihazSil(int id, String serino, String tarih) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = USERS_ID + " = ?" + " AND " + TIBBI_CIHAZLAR_SERI + " = ?" + " AND " + TIBBI_CIHAZLAR_BASLANGIC + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim(), serino, tarih};
        db.delete(TIBBI_CIHAZLAR_TABLE, selection, selectionArgs);
        db.close();
    }

    public List<String> showTibbiCihaz(int id) {
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = USERS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id).trim()};
        String[] columns = {TIBBI_CIHAZLAR_TUR, TIBBI_CIHAZLAR_URETICI, TIBBI_CIHAZLAR_KONUM, TIBBI_CIHAZLAR_MODEL, TIBBI_CIHAZLAR_SERI, TIBBI_CIHAZLAR_BASLANGIC};
        Cursor c = db.query(TIBBI_CIHAZLAR_TABLE, columns, selection, selectionArgs, null, null, null);
        while (c.moveToNext()) {
            list.add(c.getString(0) + " - " + c.getString(1) + " - " + c.getString(2) + " - " + c.getString(3) + " - " + c.getString(4) + " - " + c.getString(5));
        }
        return list;
    }
}


