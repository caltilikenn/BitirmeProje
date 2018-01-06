package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class BelgelerDuzenle extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.belgeler_duzenle);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        final ImageView iv1 = (ImageView) findViewById(R.id.iv1);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        ad = intent.getStringExtra("ad");
        final String resimAd = intent.getStringExtra("resimAd");
        Database db = new Database(getApplicationContext());
        byte[] resim = db.resimGoster(id,resimAd);
        Bitmap bmp = BitmapFactory.decodeByteArray(resim,0,resim.length);
        iv1.setImageBitmap(bmp);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),BelgeBuyut.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                intent.putExtra("resimAd", resimAd);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(BelgelerDuzenle.this);
                db.resimSil(id, resimAd);
                Toast.makeText(getApplicationContext(), "Resim Başarıyla Silindi", Toast.LENGTH_LONG).show();
                iv1.setImageDrawable(null);
                Intent intent = new Intent(getApplicationContext(), Belgeler.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BelgelerList.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),BelgelerList.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
}
