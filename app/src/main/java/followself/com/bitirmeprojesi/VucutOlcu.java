package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VucutOlcu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vucut_olcu);
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
                int boyut1;
                final String tur = et1.getText().toString();
                final String boyut = et2.getText().toString();
                String tarih = et3.getText().toString();

                if (tur.isEmpty() || boyut.isEmpty() || tarih.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz", Toast.LENGTH_LONG).show();
                    return;
                } else
                    boyut1 = Integer.parseInt(boyut.trim());
                    VucutOlcuBilgi v = new VucutOlcuBilgi(id, tur, boyut1, tarih);
                    Database db = new Database(getApplicationContext());
                    db.vucutOlcuEkle(v);
                    Toast.makeText(getApplicationContext(),"Kayıt başarıyla eklendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    Intent intent = new Intent(getApplicationContext(), VucutOlcu.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VucutOlcuList.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Olcumler.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
}


