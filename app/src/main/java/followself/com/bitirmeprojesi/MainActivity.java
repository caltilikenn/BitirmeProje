package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //activity_main.xml deki bileşenleri tek tek tanımla
    EditText et1;
    EditText et2;
    TextView txt1;
    TextView txt2;
    Button btn1;
    Button btn2;
    RelativeLayout rel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tanımlanan değişkenlere görsel öğeleri ata
        txt1 = (TextView) findViewById(R.id.txt1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        txt2 = (TextView) findViewById(R.id.txt2);
        rel1 = (RelativeLayout) findViewById(R.id.rel1);

        txt2.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    //Yeni üyelik sayfasına yönlendir
    public void yeniUyelik(View view) {
        Intent intent = new Intent(MainActivity.this, YeniUyelik.class);
        startActivity(intent);
    }

    //Anasayfaya yönlendir.
    public void anaSayfa(View view) {
        Database db = new Database(getApplicationContext());
         String email = et1.getText().toString().trim();
         String sifre = et2.getText().toString().trim();


        if (email.equals("ce.kenancaltilioglu@gmail.com") || email.equals("sedasenell@gmail.com")) {
            if (db.checkUser(email, sifre)) {
                Intent intent = new Intent(MainActivity.this, YonetimPaneli.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Yönetici paneline hoşgeldiniz", Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
            } else
                Toast.makeText(getApplicationContext(), "Hatalı kullanıcı adı ya da şifre", Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
        }
        else {
            if (db.checkUser(email, sifre)) {
                Intent intent = new Intent(MainActivity.this, Anasayfa.class);
                intent.putExtra("ad",db.isimGoster(email));
                intent.putExtra("id",db.idYolla(email));
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Hoşgeldiniz", Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
            } else
                Toast.makeText(getApplicationContext(), "Hatalı kullanıcı adı ya da şifre", Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
        }
    }

    //Şifremi unuttum sayfasına yönlendir
    public void sifreYolla(View view) {
        Intent intent = new Intent(MainActivity.this, SifremiUnuttum.class);
        startActivity(intent);
    }
}