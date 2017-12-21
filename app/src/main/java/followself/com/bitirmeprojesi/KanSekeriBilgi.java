package followself.com.bitirmeprojesi;

public class KanSekeriBilgi {
    private int id;
    private float olcum;
    private String zaman;
    private String tur;
    private String tarih;
    private String saat;

    public KanSekeriBilgi(int id, float olcum, String zaman, String tur, String tarih, String saat){
        this.id=id;
        this.olcum=olcum;
        this.zaman=zaman;
        this.tur=tur;
        this.tarih=tarih;
        this.saat=saat;
    }

    public int getId() { return id; }

    public float getOlcum() { return olcum; }

    public String getZaman() { return zaman; }

    public String getTur() { return tur; }

    public String getTarih() { return tarih; }

    public String getSaat() { return saat; }

    public void setId(int id) { this.id = id; }

    public void setOlcum(float olcum) { this.olcum = olcum; }

    public void setZaman(String zaman) { this.zaman = zaman; }

    public void setTur(String tur) { this.tur = tur; }

    public void setTarih(String tarih) { this.tarih = tarih; }

    public void setSaat(String saat) { this.saat = saat; }

}
