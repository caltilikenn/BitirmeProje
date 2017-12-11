package followself.com.bitirmeprojesi;

public class UyelikBilgi {

     private int id;
     private String ad;
     private String dtarihi;
     private String email;
     private String sifre;

    public UyelikBilgi(String ad, String dtarihi, String email, String sifre){

        this.ad=ad;
        this.dtarihi=dtarihi;
        this.sifre=sifre;
        this.email=email;
    }

    //Getterlar
    public String getAd() { return ad; }

    public String getDtarihi() { return dtarihi; }

    public String getEmail() {
        return email;
    }

    public String getSifre() { return sifre; }

    public int getId() { return id; }

    //Setterlar
    public void setAd(String ad) { this.ad = ad; }

    public void setDtarihi(String dtarihi) { this.dtarihi = dtarihi; }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
