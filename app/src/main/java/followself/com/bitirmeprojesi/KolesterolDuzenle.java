package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KolesterolDuzenle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kolesterol_duzenle);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        final EditText et5 = (EditText) findViewById(R.id.et5);
        final EditText et6 = (EditText) findViewById(R.id.et6);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);
        TextView txt4 = (TextView) findViewById(R.id.txt4);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);
        final int ldl = intent.getIntExtra("ldl",0);
        final int hdl = intent.getIntExtra("hdl",0);
        final int trigliserit = intent.getIntExtra("trigliserit",0);
        final int toplam = intent.getIntExtra("toplam",0);
        final String tarih = intent.getStringExtra("tarih");
        final String saat = intent.getStringExtra("saat");
        et1.setText(String.valueOf(ldl));
        et2.setText(String.valueOf(hdl));
        et3.setText(String.valueOf(trigliserit));
        et4.setText(String.valueOf(toplam));
        et5.setText(tarih);
        et6.setText(saat);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(KolesterolDuzenle.this);
                final String yeniLdl = et1.getText().toString();
                final String yeniHdl = et2.getText().toString();
                final String yeniTrigliserit = et3.getText().toString();
                final String yeniToplam = et4.getText().toString();
                String yeniTarih = et5.getText().toString();
                String yeniSaat = et6.getText().toString();

                if(yeniLdl.isEmpty() || yeniHdl.isEmpty() || yeniTrigliserit.isEmpty() || yeniToplam.isEmpty() || yeniTarih.isEmpty() || yeniSaat.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz",Toast.LENGTH_LONG).show();
                }
                else{
                    int yeniLdl1 = Integer.parseInt(yeniLdl);
                    int yeniHdl1 = Integer.parseInt(yeniHdl);
                    int yeniTrigliserit1 = Integer.parseInt(yeniTrigliserit);
                    int yeniToplam1 = Integer.parseInt(yeniToplam);
                    db.kolesterolGuncelle(id,yeniLdl1,yeniHdl1,yeniTrigliserit1,yeniToplam1,tarih,yeniTarih,saat,yeniSaat);
                    Toast.makeText(getApplicationContext(),"Kaydınız Güncellendi",Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    Intent intent = new Intent(getApplicationContext(),Kolesterol.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(KolesterolDuzenle.this);
                db.kolesterolSil(id,tarih,saat);
                Toast.makeText(getApplicationContext(),"Kaydınız Silindi",Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                Intent intent = new Intent(getApplicationContext(),Kolesterol.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KolesterolList.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }
}
