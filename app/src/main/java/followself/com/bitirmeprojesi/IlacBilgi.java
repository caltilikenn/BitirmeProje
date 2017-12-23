package followself.com.bitirmeprojesi;

public class IlacBilgi {
    private int id;
    private String ad;
    private int etkinlik;
    private String dozaj;
    private String sekil;
    private String siklik;
    private String neden;
    private String baslangic;
    private String bitis;

    public IlacBilgi(int id, String ad, int etkinlik, String dozaj, String sekil, String siklik, String neden, String baslangic, String bitis){
        this.id=id;
        this.ad=ad;
        this.etkinlik=etkinlik;
        this.dozaj=dozaj;
        this.sekil=sekil;
        this.siklik=siklik;
        this.neden=neden;
        this.baslangic=baslangic;
        this.bitis=bitis;
    }

    public int getId() { return id; }

    public String getAd() { return ad; }

    public int getEtkinlik() { return etkinlik; }

    public String getDozaj() { return dozaj; }

    public String getSekil() { return sekil; }

    public String getSiklik() { return siklik; }

    public String getNeden() { return neden; }

    public String getBaslangic() { return baslangic; }

    public String getBitis() { return bitis; }

    public void setId(int id) { this.id = id; }

    public void setAd(String ad) { this.ad = ad; }

    public void setEtkinlik(int etkinlik) { this.etkinlik = etkinlik; }

    public void setDozaj(String dozaj) { this.dozaj = dozaj; }

    public void setSekil(String sekil) { this.sekil = sekil; }

    public void setSiklik(String siklik) { this.siklik = siklik; }

    public void setNeden(String neden) { this.neden = neden; }

    public void setBaslangic(String baslangic) { this.baslangic = baslangic; }

    public void setBitis(String bitis) { this.bitis = bitis; }

}
