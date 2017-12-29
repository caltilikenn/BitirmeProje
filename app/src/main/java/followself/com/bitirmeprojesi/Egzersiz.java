package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Egzersiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.egzersiz);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        final EditText et5 = (EditText) findViewById(R.id.et5);
        final EditText et6 = (EditText) findViewById(R.id.et6);
        final EditText et7 = (EditText) findViewById(R.id.et7);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn4);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sure1;
                int mesafe1;
                int adim1;
                int kalori1;

                String tur = et1.getText().toString();
                String sure = et2.getText().toString();
                String mesafe = et3.getText().toString();
                String adim = et4.getText().toString();
                String kalori = et5.getText().toString();
                String tarih = et6.getText().toString();
                String saat = et7.getText().toString();

                if (tur.isEmpty() || sure.isEmpty() || mesafe.isEmpty() || adim.isEmpty() || kalori.isEmpty() || tarih.isEmpty() || saat.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    sure1 = Integer.parseInt(sure.trim());
                    mesafe1 = Integer.parseInt(mesafe.trim());
                    adim1 = Integer.parseInt(adim.trim());
                    kalori1 = Integer.parseInt(kalori.trim());
                    EgzersizBilgi eb = new EgzersizBilgi(id, tur, sure1, mesafe1, adim1, kalori1, tarih, saat);
                    Database db = new Database(getApplicationContext());
                    db.egzersizEkle(eb);
                    Toast.makeText(getApplicationContext(), "Kayıt başarıyla eklendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    et7.setText("");
                    Intent intent = new Intent(getApplicationContext(), Egzersiz.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EgzersizList.class);
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


