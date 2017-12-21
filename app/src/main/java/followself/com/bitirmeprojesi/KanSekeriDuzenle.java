package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KanSekeriDuzenle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kan_sekeri_duzenle);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        final EditText et5 = (EditText) findViewById(R.id.et5);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);
        final int olcum = intent.getIntExtra("olcum",0);
        final String zaman = intent.getStringExtra("zaman");
        final String tur = intent.getStringExtra("tur");
        final String tarih = intent.getStringExtra("tarih");
        final String saat = intent.getStringExtra("saat");
        et1.setText(String.valueOf(olcum));
        et2.setText(zaman);
        et3.setText(tur);
        et4.setText(tarih);
        et5.setText(saat);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(KanSekeriDuzenle.this);
                final String yeniOlcum = et1.getText().toString();
                String yeniZaman = et2.getText().toString();
                String yeniTur = et3.getText().toString();
                String yeniTarih = et4.getText().toString();
                String yeniSaat = et5.getText().toString();

                if(yeniOlcum.isEmpty() || yeniZaman.isEmpty() || yeniTur.isEmpty() || yeniTarih.isEmpty() || yeniSaat.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz",Toast.LENGTH_LONG).show();
                }
                else{
                    int yeniOlcum1 = Integer.parseInt(yeniOlcum);
                    db.kanSekeriGuncelle(id,yeniOlcum1,yeniZaman,yeniTur,tarih,yeniTarih,saat,yeniSaat);
                    Toast.makeText(getApplicationContext(),"Kaydınız Güncellendi",Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    Intent intent = new Intent(getApplicationContext(),KanSekeri.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(KanSekeriDuzenle.this);
                db.kanSekeriSil(id,tarih,saat);
                Toast.makeText(getApplicationContext(),"Kaydınız Silindi",Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                Intent intent = new Intent(getApplicationContext(),KanSekeri.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KanSekeriList.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }
}
