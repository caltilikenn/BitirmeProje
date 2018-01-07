package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TibbiCihazDuzenle extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tibbi_cihaz_duzenle);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        final EditText et5 = (EditText) findViewById(R.id.et5);
        final EditText et6 = (EditText) findViewById(R.id.et6);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        ad = intent.getStringExtra("ad");
        final String tur = intent.getStringExtra("tur");
        final String uretici = intent.getStringExtra("uretici");
        final String konum = intent.getStringExtra("konum");
        final String model = intent.getStringExtra("model");
        final String serino = intent.getStringExtra("serino");
        final String tarih = intent.getStringExtra("tarih");

        et1.setText(tur);
        et2.setText(uretici);
        et3.setText(konum);
        et4.setText(model);
        et5.setText(serino);
        et6.setText(tarih);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(TibbiCihazDuzenle.this);
                final String yeniTur = et1.getText().toString();
                final String yeniUretici = et2.getText().toString();
                final String yeniKonum = et3.getText().toString();
                final String yeniModel = et4.getText().toString();
                final String yeniSerino = et5.getText().toString();
                final String yeniTarih = et6.getText().toString();

                if(yeniTur.isEmpty() || yeniUretici.isEmpty() || yeniKonum.isEmpty() || yeniModel.isEmpty() || yeniSerino.isEmpty() || yeniTarih.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz",Toast.LENGTH_LONG).show();
                }
                else{
                    db.tibbiCihazGuncelle(id,yeniTur,yeniUretici,yeniKonum,yeniModel,serino,yeniSerino,tarih,yeniTarih);
                    Toast.makeText(getApplicationContext(),"Kaydınız Güncellendi",Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");

                    Intent intent = new Intent(getApplicationContext(),TibbiCihazlar.class);
                    intent.putExtra("id",id);
                    intent.putExtra("ad",ad);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(TibbiCihazDuzenle.this);
                db.tibbiCihazSil(id,serino,tarih);
                Toast.makeText(getApplicationContext(),"Kaydınız Silindi",Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");

                Intent intent = new Intent(getApplicationContext(),TibbiCihazlar.class);
                intent.putExtra("id",id);
                intent.putExtra("ad",ad);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TibbiCihazList.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),TibbiCihazList.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
}
