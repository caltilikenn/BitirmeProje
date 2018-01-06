package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SifreDegistir extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sifre_degistir);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        Button btn1=(Button) findViewById(R.id.btn1);
        Button btn2=(Button) findViewById(R.id.btn2);

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        ad = intent.getStringExtra("ad");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String eskiSifre = et1.getText().toString();
                final String yeniSifre = et2.getText().toString();
                final String yeniSifreOnay = et3.getText().toString();
                Database db = new Database(SifreDegistir.this);

                if(eskiSifre.isEmpty() || yeniSifre.isEmpty() || yeniSifreOnay.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz",Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    return;
                }

                if(!(yeniSifre.length()>=6 & yeniSifre.length()<=10)){
                    Toast.makeText(getApplicationContext(),"Şifreniz en az 6 en fazla 10 karakter içerebilir", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    return;
                }

                if(!(yeniSifre.equals(yeniSifreOnay))){
                    Toast.makeText(getApplicationContext(),"Girdiğiniz şifreler eşleşmiyor",Toast.LENGTH_LONG).show();
                    et2.setText("");
                    et3.setText("");
                    return;
                }

                else{
                    if(db.checkPassword(id,eskiSifre)){
                        db.sifreDegistir(id,yeniSifre);
                        Toast.makeText(getApplicationContext(),"Şifreniz başarıyla değiştirildi",Toast.LENGTH_LONG).show();
                        et1.setText("");
                        et2.setText("");
                        et3.setText("");
                        Intent intent = new Intent(getApplicationContext(),Anasayfa.class);
                        intent.putExtra("id",id);
                        intent.putExtra("ad",ad);
                        startActivity(intent);
                    }

                    else
                        Toast.makeText(getApplicationContext(),"Mevcut şifrenizi hatalı girdiniz",Toast.LENGTH_LONG).show();
                        et1.setText("");
                        et2.setText("");
                        et3.setText("");
                        return;
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HesapAyarlari.class);
                intent.putExtra("id",id);
                intent.putExtra("ad",ad);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),HesapAyarlari.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
}
