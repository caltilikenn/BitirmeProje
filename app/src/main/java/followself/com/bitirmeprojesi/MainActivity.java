package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    }

        //Yeni üyelik sayfasına yönlendir
    public void yeniUyelik(View view) {
        Intent intent = new Intent(MainActivity.this, YeniUyelik.class);
        startActivity(intent);
    }

       //Anasayfaya yönlendir.
    public void anaSayfa(View view) {
        Intent intent = new Intent(MainActivity.this, YeniUyelik.class);
        //startActivity(intent);
    }

  }

