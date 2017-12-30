package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlerjiDuzenle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alerji_duzenle);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);
        final String ad = intent.getStringExtra("ad");
        final String belirti = intent.getStringExtra("belirti");
        final String tur = intent.getStringExtra("tur");
        final String tarih = intent.getStringExtra("tarih");
        et1.setText(ad);
        et2.setText(belirti);
        et3.setText(tur);
        et4.setText(tarih);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(AlerjiDuzenle.this);
                final String yeniAd = et1.getText().toString();
                final String yeniBelirti = et2.getText().toString();
                final String yeniTur = et3.getText().toString();
                final String yeniTarih = et4.getText().toString();

                if(yeniAd.isEmpty() || yeniBelirti.isEmpty() || yeniTur.isEmpty() ||  yeniTarih.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz",Toast.LENGTH_LONG).show();
                }
                else{
                    db.alerjiGuncelle(id,ad,yeniAd,yeniBelirti,yeniTur,tarih,yeniTarih);
                    Toast.makeText(getApplicationContext(),"Kaydınız Güncellendi",Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    Intent intent = new Intent(getApplicationContext(),Alerjiler.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(AlerjiDuzenle.this);
                db.alerjiSil(id,ad,tarih);
                Toast.makeText(getApplicationContext(),"Kaydınız Silindi",Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                Intent intent = new Intent(getApplicationContext(),Alerjiler.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlerjiList.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }
}
