package followself.com.bitirmeprojesi;

public class UyelikBilgi {

     private int id;
     private String email;
     private String sifre;


    public UyelikBilgi(String email, String sifre){

        this.sifre=sifre;
        this.email=email;
    }

    //Getterlar
    public String getEmail() {
        return email;
    }

    public String getSifre() { return sifre; }

    public int getId() { return id; }

    //Setterlar
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
