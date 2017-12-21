package followself.com.bitirmeprojesi;


public class VucutOlcuBilgi {
    private int id;
    private String tur;
    private int boyut;
    private String tarih;

    public VucutOlcuBilgi(int id, String tur, int boyut, String tarih){
        this.id=id;
        this.tur=tur;
        this.boyut=boyut;
        this.tarih=tarih;
    }

    public int getId() { return id; }

    public String getTur() { return tur; }

    public int getBoyut() { return boyut; }

    public String getTarih() { return tarih; }

    public void setId(int id) { this.id = id; }

    public void setTur(String tur) { this.tur = tur; }

    public void setBoyut(int boyut) { this.boyut=boyut; }

    public void setTarih(String tarih) { this.tarih=tarih; }

}
