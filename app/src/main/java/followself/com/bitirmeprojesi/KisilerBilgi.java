package followself.com.bitirmeprojesi;


public class KisilerBilgi {
    private int id;
    private String ad;
    private String uzmanlik;
    private String isyeri;

    public KisilerBilgi(int id, String ad, String uzmanlik, String isyeri){
        this.id=id;
        this.ad=ad;
        this.uzmanlik=uzmanlik;
        this.isyeri=isyeri;
    }

    public int getId() { return id; }

    public String getAd() { return ad; }

    public String getUzmanlik() { return uzmanlik; }

    public String getIsyeri() { return isyeri; }

    public void setId(int id) { this.id = id; }

    public void setAd(String ad) { this.ad=ad; }

    public void setUzmanlik(String etki) { this.uzmanlik=uzmanlik; }

    public void setIsyeri(String isyeri) { this.isyeri = isyeri; }

}
