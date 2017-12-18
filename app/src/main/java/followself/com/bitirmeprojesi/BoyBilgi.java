package followself.com.bitirmeprojesi;


public class BoyBilgi {
    private int id;
    private int boy;
    private String tarih;

    public BoyBilgi(int id, int boy, String tarih){
        this.id=id;
        this.boy=boy;
        this.tarih=tarih;
    }

    public int getId() { return id; }

    public int getBoy() { return boy; }

    public String getTarih() { return tarih; }

    public void setBoy(int boy) { this.boy=boy; }

    public void setTarih(String tarih) { this.tarih=tarih; }

    public void setId(int id) { this.id = id; }

}
