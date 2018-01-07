package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TibbiCihazlar extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tibbi_cihazlar);
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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int serino1;

                String tur = et1.getText().toString();
                String uretici = et2.getText().toString();
                String konum = et3.getText().toString();
                String model = et4.getText().toString();
                String serino = et5.getText().toString();
                String tarih = et6.getText().toString();

                if (tur.isEmpty() || uretici.isEmpty() || konum.isEmpty() || model.isEmpty() || serino.isEmpty() || tarih.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    TibbiCihazBilgi tb = new TibbiCihazBilgi(id, tur, uretici, konum, model, serino, tarih);
                    Database db = new Database(getApplicationContext());
                    db.tibbiCihazEkle(tb);
                    Toast.makeText(getApplicationContext(), "Kayıt başarıyla eklendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    Intent intent = new Intent(getApplicationContext(), TibbiCihazlar.class);
                    intent.putExtra("id", id);
                    intent.putExtra("ad", ad);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TibbiCihazList.class);
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


