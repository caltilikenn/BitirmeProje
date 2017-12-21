package followself.com.bitirmeprojesi;

public class KolesterolBilgi {
    private int id;
    private int ldl;
    private int hdl;
    private int trigliserit;
    private int toplam;
    private String tarih;
    private String saat;

    public KolesterolBilgi(int id, int ldl, int hdl, int trigliserit, int toplam, String tarih, String saat){
        this.id=id;
        this.ldl=ldl;
        this.hdl=hdl;
        this.trigliserit=trigliserit;
        this.toplam=toplam;
        this.tarih=tarih;
        this.saat=saat;
    }

    public int getId() { return id; }

    public int getLdl() { return ldl; }

    public int getHdl() { return hdl; }

    public int getTrigliserit() { return trigliserit; }

    public int getToplam() { return toplam; }

    public String getTarih() { return tarih; }

    public String getSaat() { return saat; }

    public void setId(int id) { this.id = id; }

    public void setLdl(int ldl) { this.ldl = ldl; }

    public void setHdl(int hdl) { this.hdl = hdl; }

    public void setTrigliserit(int trigliserit) { this.trigliserit = trigliserit; }

    public void setToplam(int toplam) { this.toplam = toplam; }

    public void setTarih(String tarih) { this.tarih = tarih; }

    public void setSaat(String saat) { this.saat = saat; }

}
