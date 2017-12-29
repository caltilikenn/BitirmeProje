package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EgzersizDuzenle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.egzersiz_duzenle);
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
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);
        TextView txt4 = (TextView) findViewById(R.id.txt4);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);
        final String tur = intent.getStringExtra("tur");
        final int sure = intent.getIntExtra("sure",0);
        final int mesafe = intent.getIntExtra("mesafe",0);
        final int adim = intent.getIntExtra("adim",0);
        final int kalori = intent.getIntExtra("kalori",0);
        final String tarih = intent.getStringExtra("tarih");
        final String saat = intent.getStringExtra("saat");
        et1.setText(tur);
        et2.setText(String.valueOf(sure));
        et3.setText(String.valueOf(mesafe));
        et4.setText(String.valueOf(adim));
        et5.setText(String.valueOf(kalori));
        et6.setText(tarih);
        et7.setText(saat);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(EgzersizDuzenle.this);
                final String yeniTur = et1.getText().toString();
                final String yeniSure = et2.getText().toString();
                final String yeniMesafe = et3.getText().toString();
                final String yeniAdim = et4.getText().toString();
                final String yeniKalori = et5.getText().toString();
                String yeniTarih = et6.getText().toString();
                String yeniSaat = et7.getText().toString();

                if(yeniTur.isEmpty() || yeniSure.isEmpty() || yeniMesafe.isEmpty() || yeniAdim.isEmpty() || yeniKalori.isEmpty() || yeniTarih.isEmpty() || yeniSaat.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz",Toast.LENGTH_LONG).show();
                }
                else{
                    int yeniSure1 = Integer.parseInt(yeniSure);
                    int yeniMesafe1 = Integer.parseInt(yeniMesafe);
                    int yeniAdim1 = Integer.parseInt(yeniAdim);
                    int yeniKalori1 = Integer.parseInt(yeniKalori);
                    db.egzersizGuncelle(id,yeniTur,yeniSure1,yeniMesafe1,yeniAdim1,yeniKalori1,tarih,yeniTarih,saat,yeniSaat);
                    Toast.makeText(getApplicationContext(),"Kaydınız Güncellendi",Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    et7.setText("");
                    Intent intent = new Intent(getApplicationContext(),Egzersiz.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(EgzersizDuzenle.this);
                db.egzersizSil(id,tarih,saat);
                Toast.makeText(getApplicationContext(),"Kaydınız Silindi",Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                et7.setText("");
                Intent intent = new Intent(getApplicationContext(),Egzersiz.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EgzersizList.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }
}
