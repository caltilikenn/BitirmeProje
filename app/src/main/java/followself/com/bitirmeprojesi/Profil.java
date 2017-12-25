package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        final EditText et5 = (EditText) findViewById(R.id.et5);
        final EditText et6 = (EditText) findViewById(R.id.et6);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);
        Database db = new Database(getApplicationContext());

        et1.setText(db.profil(id,0));
        et2.setText(db.profil(id,1));
        et3.setText(db.profil(id,2));
        et4.setText(db.profil(id,3));
        et5.setText(db.profil(id,4));
        et6.setText(db.profil(id,5));


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ad = et1.getText().toString();
                String email = et2.getText().toString();
                String dtarihi = et3.getText().toString();
                String ulke = et4.getText().toString();
                String il = et5.getText().toString();
                String cinsiyet = et6.getText().toString();

                if (ad.isEmpty() || email.isEmpty() || dtarihi.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ad-soyad,email ve doğum tarihi boş bırakılamaz", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    Database db = new Database(getApplicationContext());
                    db.profilGuncelle(id,ad,email,dtarihi,ulke,il,cinsiyet);
                    Toast.makeText(getApplicationContext(), "Profiliniz başarıyla güncellendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    Intent intent = new Intent(getApplicationContext(), Profil.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Anasayfa.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }
}


