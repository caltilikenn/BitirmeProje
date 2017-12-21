package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Kolesterol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kolesterol);
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
        final int id = intent.getIntExtra("id",0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ldl1;
                int hdl1;
                int trigliserit1;
                int toplam1;

                String ldl = et1.getText().toString();
                String hdl = et2.getText().toString();
                String trigliserit = et3.getText().toString();
                String toplam = et4.getText().toString();
                String tarih = et5.getText().toString();
                String saat = et6.getText().toString();


                if (ldl.isEmpty() || hdl.isEmpty() || trigliserit.isEmpty() || toplam.isEmpty() || tarih.isEmpty() || saat.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz", Toast.LENGTH_LONG).show();
                    return;
                } else
                    ldl1 = Integer.parseInt(ldl.trim());
                    hdl1 = Integer.parseInt(hdl.trim());
                    trigliserit1 = Integer.parseInt(trigliserit.trim());
                    toplam1 = Integer.parseInt(toplam.trim());
                    KolesterolBilgi kol = new KolesterolBilgi(id, ldl1, hdl1, trigliserit1, toplam1, tarih, saat);
                    Database db = new Database(getApplicationContext());
                    db.kolesterolEkle(kol);
                    Toast.makeText(getApplicationContext(),"Kayıt başarıyla eklendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    Intent intent = new Intent(getApplicationContext(), Kolesterol.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KolesterolList.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Olcumler.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}


