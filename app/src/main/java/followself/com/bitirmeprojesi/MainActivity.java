package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));

        if( getIntent().getBooleanExtra("Exit", false)){
            finish();
            return;
        }

        //tanımlanan değişkenlere görsel öğeleri ata
        txt1 = (TextView) findViewById(R.id.txt1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt2.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
        System.exit(0);
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
                int id = Integer.parseInt(db.idYolla(email));
                Intent intent = new Intent(MainActivity.this, Anasayfa.class);
                intent.putExtra("ad",db.isimGoster(email));
                intent.putExtra("id",id);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Hoşgeldiniz "+db.isimGoster(email), Toast.LENGTH_LONG).show();
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