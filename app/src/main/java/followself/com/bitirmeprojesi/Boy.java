package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Boy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boy);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int boy1;
                final String boy = et1.getText().toString();
                String tarih = et2.getText().toString();

                if (boy.isEmpty() || tarih.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Alanların tamamını doldurunuz", Toast.LENGTH_LONG).show();
                    return;
                } else
                    boy1 = Integer.parseInt(boy);
                    BoyBilgi b = new BoyBilgi(id, boy1, tarih);
                    Database db = new Database(getApplicationContext());
                    db.boyEkle(b);
                    Toast.makeText(getApplicationContext(),"Kayıt başarıyla eklendi", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Boy.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BoyList.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
}


