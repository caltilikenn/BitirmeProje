package followself.com.bitirmeprojesi;

public class EgzersizBilgi {
    private int id;
    private String tur;
    private int sure;
    private int mesafe;
    private int adim;
    private int kalori;
    private String tarih;
    private String saat;

    public EgzersizBilgi(int id, String tur, int sure, int mesafe, int adim, int kalori, String tarih, String saat){
        this.id=id;
        this.tur=tur;
        this.sure=sure;
        this.mesafe=mesafe;
        this.adim=adim;
        this.kalori=kalori;
        this.tarih=tarih;
        this.saat=saat;
    }

    public int getId() { return id; }

    public String getTur() { return tur; }

    public int getSure() { return sure; }

    public int getMesafe() { return mesafe; }

    public int getAdim() { return adim; }

    public int getKalori() { return kalori; }

    public String getTarih() { return tarih; }

    public String getSaat() { return saat; }

    public void setId(int id) { this.id = id; }

    public void setTur(String tur) { this.tur = tur; }

    public void setSure(int sure) { this.sure = sure; }

    public void setMesafe(int mesafe) { this.mesafe = mesafe; }

    public void setAdim(int adim) { this.adim = adim; }

    public void setKalori(int kalori) { this.kalori = kalori; }

    public void setTarih(String tarih) { this.tarih = tarih; }

    public void setSaat(String saat) { this.saat = saat; }

}
