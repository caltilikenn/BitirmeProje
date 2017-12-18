package followself.com.bitirmeprojesi;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HesapAyarlari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hesap_ayarlari);
        Button btn1=(Button) findViewById(R.id.btn1);
        Button btn2=(Button) findViewById(R.id.btn2);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SifreDegistir.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HesapAyarlari.this);
                builder.setTitle("Hesap Silmeyi Onayla");
                builder.setMessage("Hesabınızı silerseniz hesabınız kalıcı olarak kaldırılır ve tüm verileriniz silinir. Onaylıyor musunuz?");
                builder.setNegativeButton("VAZGEÇ", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });

                builder.setPositiveButton("HESABI SİL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        Database db = new Database(HesapAyarlari.this);
                        db.kullaniciSil(id);
                        Toast.makeText(getApplicationContext(),"Hesabınız ve verileriniz kalıcı olarak silindi", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }
}
