package followself.com.bitirmeprojesi;


public class BelgelerBilgi {
    private int id;
    private String ad;
    private byte[] resim;

    public BelgelerBilgi(int id, String ad, byte[] resim) {
        this.id = id;
        this.ad = ad;
        this.resim = resim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public byte[] getResim() {
        return resim;
    }

    public void setResim(byte[] resim) {
        this.resim = resim;
    }
}
