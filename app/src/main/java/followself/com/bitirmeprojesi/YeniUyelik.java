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
        Button btn1 = (Button) findViewById(R.id.btn1);
        RelativeLayout  rel1 = (RelativeLayout) findViewById(R.id.rel1);

        //Geçici olarak listelemeye bakmak için kullanıyorum
        ImageButton liste = (ImageButton)findViewById(R.id.liste);

        //Yeni kullanıcı oluşturma kısmı
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String email = et1.getText().toString();
                final String sifre = et2.getText().toString();
                final String sifreOnay = et3.getText().toString();

                UyelikBilgi ub = new UyelikBilgi(email,sifre);
                Database db = new Database(getApplicationContext());

                if(email.isEmpty() || sifre.isEmpty() || sifreOnay.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz",Toast.LENGTH_LONG).show();
                    return;
                }

                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(getApplicationContext(), "Lütfen Geçerli bir email adresi girin", Toast.LENGTH_LONG).show();
                    return;
                }

                if(!(sifre.equals(sifreOnay))){
                    txt2.setText("Girdiğiniz şifreler eşleşmiyor");
                }

                else {
                    if (!db.checkUser(email.trim())) {
                        db.insert(ub);
                        Toast.makeText(getApplicationContext(), "Üyelik işleminiz tamamlandı", Toast.LENGTH_LONG).show();
                        Intent basaDon = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(basaDon);
                    } else {
                        Toast.makeText(getApplicationContext(), "Üyelik işleminiz başarısız", Toast.LENGTH_LONG).show();
                    }
                }


                }
            });

        //veritabanındaki bilgileri göstermek için
        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listele = new Intent(getApplicationContext(),DatabaseList.class);
                startActivity(listele);
            }
        });


    }
}
