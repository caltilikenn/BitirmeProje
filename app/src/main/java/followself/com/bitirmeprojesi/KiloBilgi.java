package followself.com.bitirmeprojesi;


public class KiloBilgi {
    private int id;
    private int kilo;
    private String tarih;
    private String saat;

    public KiloBilgi(int id, int kilo, String tarih, String saat){
        this.id=id;
        this.kilo=kilo;
        this.tarih=tarih;
        this.saat=saat;
    }

    public int getId() { return id; }

    public int getKilo() { return kilo; }

    public String getTarih() { return tarih; }

    public String getSaat() { return saat; }

    public void setId(int id) { this.id = id; }

    public void setKilo(int kilo) { this.kilo=kilo; }

    public void setTarih(String tarih) { this.tarih=tarih; }

    public void setSaat(String saat) { this.saat = saat; }

}
