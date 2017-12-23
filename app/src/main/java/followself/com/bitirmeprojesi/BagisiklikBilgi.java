package followself.com.bitirmeprojesi;


public class BagisiklikBilgi {
    private int id;
    private String ad;
    private String etki;
    private String tarih;

    public BagisiklikBilgi(int id, String ad, String etki, String tarih){
        this.id=id;
        this.ad=ad;
        this.etki=etki;
        this.tarih=tarih;
    }

    public int getId() { return id; }

    public String getAd() { return ad; }

    public String getEtki() { return etki; }

    public String getTarih() { return tarih; }

    public void setId(int id) { this.id = id; }

    public void setAd(String ad) { this.ad=ad; }

    public void setEtki(String etki) { this.etki=etki; }

    public void setTarih(String tarih) { this.tarih = tarih; }

}
