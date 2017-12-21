package followself.com.bitirmeprojesi;

public class KanBasinciBilgi {
    private int id;
    private int sistolik;
    private int diyastolik;
    private int nabiz;
    private String duzen;
    private String tarih;
    private String saat;

    public KanBasinciBilgi(int id, int sistolik, int diyastolik, int nabiz, String duzen, String tarih, String saat){
        this.id=id;
        this.sistolik=sistolik;
        this.diyastolik=diyastolik;
        this.nabiz=nabiz;
        this.duzen=duzen;
        this.tarih=tarih;
        this.saat=saat;
    }

    public int getId() { return id; }

    public int getSistolik() { return sistolik; }

    public int getDiyastolik() { return diyastolik; }

    public int getNabiz() { return nabiz; }

    public String getDuzen() { return duzen; }

    public String getTarih() { return tarih; }

    public String getSaat() { return saat; }

    public void setId(int id) { this.id = id; }

    public void setSistolik(int sistolik) { this.sistolik = sistolik; }

    public void setDiyastolik(int diyastolik) { this.diyastolik = diyastolik; }

    public void setNabiz(int nabiz) { this.nabiz = nabiz; }

    public void setDuzen(String duzen) { this.duzen = duzen; }

    public void setTarih(String tarih) { this.tarih = tarih; }

    public void setSaat(String saat) { this.saat = saat; }

}
