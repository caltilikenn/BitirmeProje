package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SifreDegistir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sifre_degistir);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        Button btn1=(Button) findViewById(R.id.btn1);
        Button btn2=(Button) findViewById(R.id.btn2);
        Button btn3=(Button) findViewById(R.id.btn3);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

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
                Intent intent = new Intent(getApplicationContext(), Anasayfa.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HesapAyarlari.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
