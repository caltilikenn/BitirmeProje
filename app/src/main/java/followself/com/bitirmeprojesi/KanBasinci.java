package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KanBasinci extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kan_basinci);
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
                int sistolik1;
                int diyastolik1;
                int nabiz1;

                String sistolik = et1.getText().toString();
                String diyastolik = et2.getText().toString();
                String nabiz = et3.getText().toString();
                String duzen = et4.getText().toString();
                String tarih = et5.getText().toString();
                String saat = et6.getText().toString();


                if (sistolik.isEmpty() || diyastolik.isEmpty() || nabiz.isEmpty() || duzen.isEmpty() || tarih.isEmpty() || saat.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz", Toast.LENGTH_LONG).show();
                    return;
                } else
                    sistolik1 = Integer.parseInt(sistolik.trim());
                    diyastolik1 = Integer.parseInt(diyastolik.trim());
                    nabiz1 = Integer.parseInt(nabiz.trim());
                    KanBasinciBilgi kb = new KanBasinciBilgi(id, sistolik1, diyastolik1, nabiz1, duzen, tarih, saat);
                    Database db = new Database(getApplicationContext());
                    db.kanBasinciEkle(kb);
                    Toast.makeText(getApplicationContext(),"Kayıt başarıyla eklendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    Intent intent = new Intent(getApplicationContext(), KanBasinci.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KanBasinciList.class);
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

