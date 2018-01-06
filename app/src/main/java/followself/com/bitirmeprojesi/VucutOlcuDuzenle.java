package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VucutOlcuDuzenle extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vucut_olcu_duzenle);
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
        id = intent.getIntExtra("id", 0);
        ad = intent.getStringExtra("ad");
        final String tur = intent.getStringExtra("tur");
        final int boyut = intent.getIntExtra("boyut", 0);
        final String tarih = intent.getStringExtra("tarih");
        et1.setText(tur);
        et2.setText(String.valueOf(boyut));
        et3.setText(tarih);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(VucutOlcuDuzenle.this);
                String yeniTur = et1.getText().toString();
                final String yeniBoyut = et2.getText().toString();
                String yeniTarih = et3.getText().toString();

                if (yeniTur.isEmpty() || yeniBoyut.isEmpty() || yeniTarih.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Alanların tamamını doldurunuz", Toast.LENGTH_LONG).show();
                } else {
                    int yeniBoyut1 = Integer.parseInt(yeniBoyut);
                    db.vucutOlcuGuncelle(id, yeniTur, yeniBoyut1, tarih, yeniTarih);
                    Toast.makeText(getApplicationContext(), "Kaydınız Güncellendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    Intent intent = new Intent(getApplicationContext(), VucutOlcu.class);
                    intent.putExtra("id", id);
                    intent.putExtra("ad", ad);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(VucutOlcuDuzenle.this);
                db.vucutOlcuSil(id, tarih);
                Toast.makeText(getApplicationContext(), "Kaydınız Silindi", Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                Intent intent = new Intent(getApplicationContext(), VucutOlcu.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VucutOlcuList.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),VucutOlcuList.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
}
