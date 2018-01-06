package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ilaclar extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ilaclar);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        final EditText et5 = (EditText) findViewById(R.id.et5);
        final EditText et6 = (EditText) findViewById(R.id.et6);
        final EditText et7 = (EditText) findViewById(R.id.et7);
        final EditText et8 = (EditText) findViewById(R.id.et8);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        ad = intent.getStringExtra("ad");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int etkinlik1;

                String ilacAd = et1.getText().toString();
                String etkinlik = et2.getText().toString();
                String dozaj = et3.getText().toString();
                String sekil = et4.getText().toString();
                String siklik = et5.getText().toString();
                String neden = et6.getText().toString();
                String baslangic = et7.getText().toString();
                String bitis = et8.getText().toString();

                if (ilacAd.isEmpty() || etkinlik.isEmpty() || dozaj.isEmpty() || sekil.isEmpty() || siklik.isEmpty() || neden.isEmpty() || baslangic.isEmpty() || bitis.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    etkinlik1 = Integer.parseInt(etkinlik.trim());
                    IlacBilgi ib = new IlacBilgi(id, ilacAd, etkinlik1, dozaj, sekil, siklik, neden, baslangic, bitis);
                    Database db = new Database(getApplicationContext());
                    db.ilacEkle(ib);
                    Toast.makeText(getApplicationContext(), "Kayıt başarıyla eklendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    et7.setText("");
                    et8.setText("");
                    Intent intent = new Intent(getApplicationContext(), Ilaclar.class);
                    intent.putExtra("id", id);
                    intent.putExtra("ad", ad);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IlacList.class);
                intent.putExtra("id",id);
                intent.putExtra("ad",ad);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SaglikGecmisi.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),SaglikGecmisi.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
}


