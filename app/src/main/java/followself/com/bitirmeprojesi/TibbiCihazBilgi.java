package followself.com.bitirmeprojesi;

public class TibbiCihazBilgi {
    private int id;
    private String tur;
    private String uretici;
    private String konum;
    private String model;
    private int serino;
    private String tarih;

    public TibbiCihazBilgi(int id, String tur, String uretici, String konum, String model, int serino, String tarih){
        this.id=id;
        this.tur=tur;
        this.uretici=uretici;
        this.konum=konum;
        this.model=model;
        this.serino=serino;
        this.tarih=tarih;
    }

    public int getId() { return id; }

    public String getTur() { return tur; }

    public String getUretici() { return uretici; }

    public String getKonum() { return konum; }

    public String getModel() { return model; }

    public int getSerino() { return serino; }

    public String getTarih() { return tarih; }

    public void setId(int id) { this.id = id; }

    public void setTur(String tur) { this.tur = tur; }

    public void setUretici(String uretici) { this.uretici = uretici; }

    public void setKonum(String konum) { this.konum = konum; }

    public void setModel(String model) { this.model = model; }

    public void setSerino(int serino) { this.serino = serino; }

    public void setTarih(String tarih) { this.tarih = tarih; }

}
