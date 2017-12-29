package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BoyDuzenle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boy_duzenle);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn4);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id", 0);
        final int boy = intent.getIntExtra("boy", 0);
        final String tarih = intent.getStringExtra("tarih");
        et1.setText(String.valueOf(boy));
        et2.setText(tarih);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(BoyDuzenle.this);
                final String yeniBoy = et1.getText().toString();
                String yeniTarih = et2.getText().toString();

                if (yeniBoy.isEmpty() || yeniTarih.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Alanların tamamını doldurunuz", Toast.LENGTH_LONG).show();
                } else {
                    int yeniboy1 = Integer.parseInt(yeniBoy);
                    db.boyGuncelle(id, yeniboy1, tarih, yeniTarih);
                    Toast.makeText(getApplicationContext(), "Kaydınız Güncellendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    Intent intent = new Intent(getApplicationContext(), Boy.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(BoyDuzenle.this);
                db.boySil(id, tarih);
                Toast.makeText(getApplicationContext(), "Kaydınız Silindi", Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                Intent intent = new Intent(getApplicationContext(), Boy.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BoyList.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
