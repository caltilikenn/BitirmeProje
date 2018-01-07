package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class BelgeBuyut extends AppCompatActivity {

    int id;
    String ad;
    String resimAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.belge_buyut);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        ImageView iv1 = (ImageView)findViewById(R.id.iv1);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        ad = intent.getStringExtra("ad");
        resimAd = intent.getStringExtra("resimAd");
        Database db = new Database(BelgeBuyut.this);
        byte[] resim = db.resimGoster(id,resimAd);
        Bitmap bmp = BitmapFactory.decodeByteArray(resim,0,resim.length);
        iv1.setImageBitmap(bmp);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(BelgeBuyut.this,BelgelerDuzenle.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        intent.putExtra("resimAd", resimAd);
        startActivity(intent);
    }
}
