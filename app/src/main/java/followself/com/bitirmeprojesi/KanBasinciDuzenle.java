package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KanBasinciDuzenle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kan_basinci_duzenle);
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
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);
        final float sistolik = intent.getFloatExtra("sistolik",0);
        final float diyastolik = intent.getFloatExtra("diyastolik",0);
        final int nabiz = intent.getIntExtra("nabiz",0);
        final String duzen = intent.getStringExtra("duzen");
        final String tarih = intent.getStringExtra("tarih");
        final String saat = intent.getStringExtra("saat");
        et1.setText(String.valueOf(sistolik));
        et2.setText(String.valueOf(diyastolik));
        et3.setText(String.valueOf(nabiz));
        et4.setText(duzen);
        et5.setText(tarih);
        et6.setText(saat);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(KanBasinciDuzenle.this);
                final String yeniSistolik = et1.getText().toString();
                final String yeniDiyastolik = et2.getText().toString();
                final String yeniNabiz = et3.getText().toString();
                final String yeniDuzen = et4.getText().toString();
                String yeniTarih = et5.getText().toString();
                String yeniSaat = et6.getText().toString();

                if(yeniSistolik.isEmpty() || yeniDiyastolik.isEmpty() || yeniNabiz.isEmpty() || yeniDuzen.isEmpty() || yeniTarih.isEmpty() || yeniSaat.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz",Toast.LENGTH_LONG).show();
                }
                else{
                    float yeniSistolik1 = Float.parseFloat(yeniSistolik);
                    float yeniDiyastolik1 = Float.parseFloat(yeniDiyastolik);
                    int yeniNabiz1 = Integer.parseInt(yeniNabiz);
                    db.kanBasinciGuncelle(id,yeniSistolik1,yeniDiyastolik1,yeniNabiz1,yeniDuzen,tarih,yeniTarih,saat,yeniSaat);
                    Toast.makeText(getApplicationContext(),"Kaydınız Güncellendi",Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    Intent intent = new Intent(getApplicationContext(),KanBasinci.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(KanBasinciDuzenle.this);
                db.kanBasinciSil(id,tarih,saat);
                Toast.makeText(getApplicationContext(),"Kaydınız Silindi",Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                Intent intent = new Intent(getApplicationContext(),KanBasinci.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KanBasinciList.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }
}
