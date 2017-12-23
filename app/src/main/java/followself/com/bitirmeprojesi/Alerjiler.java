package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Alerjiler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alerjiler);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad = et1.getText().toString();
                String belirti = et2.getText().toString();
                String tur = et3.getText().toString();
                String tarih = et4.getText().toString();

                if (ad.isEmpty() || belirti.isEmpty() || tur.isEmpty() || tarih.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    AlerjiBilgi a = new AlerjiBilgi(id, ad, belirti, tur, tarih);
                    Database db = new Database(getApplicationContext());
                    db.alerjiEkle(a);
                    Toast.makeText(getApplicationContext(), "Kayıt başarıyla eklendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    Intent intent = new Intent(getApplicationContext(), Alerjiler.class);
                    intent.putExtra("id", id);
                    startActivity(intent);

                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlerjiList.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SaglikGecmisi.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}


