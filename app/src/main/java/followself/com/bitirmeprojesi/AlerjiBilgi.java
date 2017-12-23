package followself.com.bitirmeprojesi;

public class AlerjiBilgi {
    private int id;
    private String ad;
    private String belirti;
    private String tur;
    private String tarih;

    public AlerjiBilgi(int id, String ad, String belirti, String tur,  String tarih){
        this.id=id;
        this.ad=ad;
        this.belirti=belirti;
        this.tur=tur;
        this.tarih=tarih;
    }

    public int getId() { return id; }

    public String getAd() { return ad; }

    public String getBelirti() { return belirti; }

    public String getTur() { return tur; }

    public String getTarih() { return tarih; }

    public void setId(int id) { this.id = id; }

    public void setAd(String ad) { this.ad = ad; }

    public void setBelirti(String belirti) { this.belirti = belirti; }

    public void setTur(String tur) { this.tur = tur; }

    public void setTarih(String tarih) { this.tarih = tarih; }

}
