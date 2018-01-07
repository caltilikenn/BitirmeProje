package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KisilerDuzenle extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kisiler_duzenle);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        ad = intent.getStringExtra("ad");
        final String kisiAd = intent.getStringExtra("kisiAd");
        final String uzmanlik = intent.getStringExtra("uzmanlik");
        final String isyeri = intent.getStringExtra("isyeri");
        et1.setText(kisiAd);
        et2.setText(uzmanlik);
        et3.setText(isyeri);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(KisilerDuzenle.this);
                String yeniAd = et1.getText().toString();
                String yeniUzmanlik = et2.getText().toString();
                String yeniIsyeri = et3.getText().toString();

                if(yeniAd.isEmpty() || yeniUzmanlik.isEmpty() || yeniIsyeri.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz",Toast.LENGTH_LONG).show();
                }
                else{
                    db.kisiGuncelle(id,kisiAd,yeniAd,yeniUzmanlik,yeniIsyeri);
                    Toast.makeText(getApplicationContext(),"Kaydınız Güncellendi",Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    Intent intent = new Intent(getApplicationContext(),Kisiler.class);
                    intent.putExtra("id",id);
                    intent.putExtra("ad",ad);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(KisilerDuzenle.this);
                db.kisiSil(id,kisiAd);
                Toast.makeText(getApplicationContext(),"Kaydınız Silindi",Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                Intent intent = new Intent(getApplicationContext(),Kisiler.class);
                intent.putExtra("id",id);
                intent.putExtra("ad",ad);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KisilerList.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),KisilerList.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
}
