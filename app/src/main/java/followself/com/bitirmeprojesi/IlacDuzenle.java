package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IlacDuzenle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ilac_duzenle);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        final EditText et5 = (EditText) findViewById(R.id.et5);
        final EditText et6 = (EditText) findViewById(R.id.et6);
        final EditText et7 = (EditText) findViewById(R.id.et7);
        final EditText et8 = (EditText) findViewById(R.id.et8);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);
        final String ad = intent.getStringExtra("ad");
        final int etkinlik = intent.getIntExtra("etkinlik",0);
        final String dozaj = intent.getStringExtra("dozaj");
        final String sekil = intent.getStringExtra("sekil");
        final String siklik = intent.getStringExtra("siklik");
        final String neden = intent.getStringExtra("neden");
        final String baslangic = intent.getStringExtra("baslangic");
        final String bitis = intent.getStringExtra("bitis");
        et1.setText(ad);
        et2.setText(String.valueOf(etkinlik));
        et3.setText(dozaj);
        et4.setText(sekil);
        et5.setText(siklik);
        et6.setText(neden);
        et7.setText(baslangic);
        et8.setText(bitis);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(IlacDuzenle.this);
                final String yeniAd = et1.getText().toString();
                final String yeniEtkinlik = et2.getText().toString();
                final String yeniDozaj = et3.getText().toString();
                final String yeniSekil = et4.getText().toString();
                final String yeniSiklik = et5.getText().toString();
                final String yeniNeden = et6.getText().toString();
                final String yeniBaslangic = et7.getText().toString();
                final String yeniBitis = et8.getText().toString();

                if(yeniAd.isEmpty() || yeniEtkinlik.isEmpty() || yeniDozaj.isEmpty() || yeniSekil.isEmpty() || yeniSiklik.isEmpty() || yeniNeden.isEmpty() || yeniBaslangic.isEmpty() || yeniBitis.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz. Boş bırakmak istediğiniz yere 0 giriniz",Toast.LENGTH_LONG).show();
                }
                else{
                    int yeniEtkinlik1 = Integer.parseInt(yeniEtkinlik);
                    db.ilacGuncelle(id,ad,yeniAd,yeniEtkinlik1,yeniDozaj,yeniSekil,yeniSiklik,yeniNeden,baslangic,yeniBaslangic,bitis,yeniBitis);
                    Toast.makeText(getApplicationContext(),"Kaydınız Güncellendi",Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    et7.setText("");
                    et8.setText("");
                    Intent intent = new Intent(getApplicationContext(),Ilaclar.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(IlacDuzenle.this);
                db.ilacSil(id,ad,baslangic,bitis);
                Toast.makeText(getApplicationContext(),"Kaydınız Silindi",Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                et7.setText("");
                et8.setText("");
                Intent intent = new Intent(getApplicationContext(),Ilaclar.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IlacList.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }
}
