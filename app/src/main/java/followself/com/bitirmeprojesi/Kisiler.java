package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Kisiler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kisiler);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad = et1.getText().toString();
                String uzmanlik = et2.getText().toString();
                String isyeri = et3.getText().toString();

                if (ad.isEmpty() || uzmanlik.isEmpty() || isyeri.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Alanların tamamını doldurunuz", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    KisilerBilgi kb = new KisilerBilgi(id, ad, uzmanlik, isyeri);
                    Database db = new Database(getApplicationContext());
                    db.kisiEkle(kb);
                    Toast.makeText(getApplicationContext(), "Kayıt başarıyla eklendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    Intent intent = new Intent(getApplicationContext(), Kisiler.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KisilerList.class);
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


