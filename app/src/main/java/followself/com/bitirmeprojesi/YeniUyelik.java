package followself.com.bitirmeprojesi;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class YeniUyelik extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeni_uyelik);

        TextView txt1 = (TextView) findViewById(R.id.txt1);
        final TextView txt2 = (TextView) findViewById(R.id.txt2);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        final EditText et5 = (EditText) findViewById(R.id.et5);
        Button btn1 = (Button) findViewById(R.id.btn1);
        RelativeLayout  rel1 = (RelativeLayout) findViewById(R.id.rel1);

        //Yeni kullanıcı oluşturma kısmı
        btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        final String ad = et1.getText().toString();
                        final String dtarihi = et2.getText().toString();
                        final String email = et3.getText().toString();
                        final String sifre = et4.getText().toString();
                        final String sifreOnay = et5.getText().toString();

                UyelikBilgi ub = new UyelikBilgi(ad,dtarihi,email,sifre);
                Database db = new Database(getApplicationContext());

                if(ad.isEmpty() || dtarihi.isEmpty() || email.isEmpty() || sifre.isEmpty() || sifreOnay.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz",Toast.LENGTH_LONG).show();
                    et4.setText("");
                    et5.setText("");
                    return;
                }

                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(getApplicationContext(), "Lütfen Geçerli bir email adresi giriniz", Toast.LENGTH_LONG).show();
                    et4.setText("");
                    et5.setText("");
                    return;
                }

                if(!(sifre.length()>=6 & sifre.length()<=10)){
                    Toast.makeText(getApplicationContext(),"Şifreniz en az 6 en fazla 10 karakter içerebilir", Toast.LENGTH_LONG).show();
                    et4.setText("");
                    et5.setText("");
                    return;
                }

                if(!(sifre.equals(sifreOnay))){
                    txt2.setText("Girdiğiniz şifreler eşleşmiyor");
                }

                else {
                    if (!db.checkUser(email.trim())) {
                        db.kullaniciEkle(ub);
                        Toast.makeText(getApplicationContext(), "Üyelik işleminiz tamamlandı", Toast.LENGTH_LONG).show();
                        Intent basaDon = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(basaDon);
                        et1.setText("");
                        et2.setText("");
                        et3.setText("");
                        et4.setText("");
                        et5.setText("");
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Sistemde bu e-mail adresi zaten kayıtlı", Toast.LENGTH_LONG).show();
                        et1.setText("");
                        et2.setText("");
                        et3.setText("");
                        et4.setText("");
                        et5.setText("");
                    }
                }
                    }
            });
    }
}
