package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class BelgeBuyut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.belge_buyut);
        ImageView iv1 = (ImageView)findViewById(R.id.iv1);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);
        final String ad = intent.getStringExtra("ad");
        Database db = new Database(BelgeBuyut.this);
        byte[] resim = db.resimGoster(id,ad);
        Bitmap bmp = BitmapFactory.decodeByteArray(resim,0,resim.length);
        iv1.setImageBitmap(bmp);

        Intent intent1 = new Intent(BelgeBuyut.this,BelgelerDuzenle.class);
        intent1.putExtra("id",id);
    }
}
