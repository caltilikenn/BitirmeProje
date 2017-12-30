package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class BelgelerDuzenle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.belgeler_duzenle);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        final ImageView iv1 = (ImageView) findViewById(R.id.iv1);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id", 0);
        final String ad = intent.getStringExtra("ad");
        Database db = new Database(getApplicationContext());
        byte[] resim = db.resimGoster(id,ad);
        Bitmap bmp = BitmapFactory.decodeByteArray(resim,0,resim.length);
        iv1.setImageBitmap(bmp);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),BelgeBuyut.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(BelgelerDuzenle.this);
                db.resimSil(id, ad);
                Toast.makeText(getApplicationContext(), "Resim Başarıyla Silindi", Toast.LENGTH_LONG).show();
                iv1.setImageDrawable(null);
                Intent intent = new Intent(getApplicationContext(), Belgeler.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BelgelerList.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
