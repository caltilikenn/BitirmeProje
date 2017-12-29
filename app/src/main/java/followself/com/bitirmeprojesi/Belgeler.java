package followself.com.bitirmeprojesi;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Belgeler extends AppCompatActivity {

    final int REQUEST_CODE_GALLERY = 999;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    EditText et1;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.belgeler);
        iv1 = (ImageView) findViewById(R.id.iv1);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        et1 = (EditText) findViewById(R.id.et1);
        Intent intent1 = getIntent();
        final int id = intent1.getIntExtra("id",0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                iv1.setImageDrawable(null);
                ActivityCompat.requestPermissions(Belgeler.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_GALLERY);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad = et1.getText().toString();
                if (ad.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Lütfen resim için bir ad giriniz", Toast.LENGTH_LONG).show();
                    return;
                }
                if (iv1.getDrawable()==null) {
                    Toast.makeText(getApplicationContext(),"Lütfen bir resim seçiniz", Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    Database db = new Database(Belgeler.this);
                    byte[] resim1 = ivToByte(iv1);
                    BelgelerBilgi bb = new BelgelerBilgi(id,ad,resim1);
                    db.resimEkle(bb);
                    Toast.makeText(getApplicationContext(),"Resim başarıyla eklendi", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    iv1.setImageDrawable(null);
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(Belgeler.this);
                String ad = et1.getText().toString();
                byte[] resim = db.resimGoster(id,ad);
                Bitmap bmp = BitmapFactory.decodeByteArray(resim,0,resim.length);
                iv1.setImageBitmap(bmp);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Belgeler.this,Anasayfa.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }

    private byte[] ivToByte(ImageView iv1){
        Bitmap bmp = ((BitmapDrawable)iv1.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] resim = stream.toByteArray();
        return resim;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);
            }
            else{
                Toast.makeText(getApplicationContext(),"Bu dosyaya erişim izniniz yok", Toast.LENGTH_LONG).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
             try {
                InputStream is = getContentResolver().openInputStream(uri);
                Bitmap bmp = BitmapFactory.decodeStream(is);
                iv1.setImageBitmap(bmp);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}
