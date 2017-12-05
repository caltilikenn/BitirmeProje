package followself.com.bitirmeprojesi;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class YeniUyelik extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeni_uyelik);

        TextView txt1 = (TextView) findViewById(R.id.txt1);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        Button btn1 = (Button) findViewById(R.id.btn1);
        RelativeLayout  rel1 = (RelativeLayout) findViewById(R.id.rel1);

        //Geçici olarak listelemeye bakmak için kullanıyorum
        ImageButton liste = (ImageButton)findViewById(R.id.liste);

        //Yeni kullanıcı oluşturma kısmı
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String email = et1.getText().toString();
                final String sifre = et2.getText().toString();

                if(email.isEmpty() || sifre.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanların tamamı doldurulmalıdır",Toast.LENGTH_LONG).show();
                    return;
                }

                UyelikBilgi ub = new UyelikBilgi(email,sifre);
                Database db = new Database(getApplicationContext());
                long id = db.insert(ub);

                if (id>0) {
                    Toast.makeText(getApplicationContext(), "Üyelik işleminiz tamamlandı ID="+id, Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Üyelik işleminiz başarısız", Toast.LENGTH_LONG).show();
                }

                Intent basaDon = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(basaDon);

                }
            });

        //veritabanındaki bilgileri göstermek için
        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listele = new Intent(getApplicationContext(),DatabaseList.class);
                startActivity(listele);
            }
        });


    }
}
