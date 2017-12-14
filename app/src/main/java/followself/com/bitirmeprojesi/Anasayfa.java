package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;


public class Anasayfa extends AppCompatActivity {

    TextView txt1;
    TextView txt2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);
        Intent intent = getIntent();
        String ad = intent.getStringExtra("ad");
        String id = intent.getStringExtra("id");

        txt1=(TextView) findViewById(R.id.txt1);
        txt1.setText(ad);
        txt2=(TextView) findViewById(R.id.txt2);
        txt2.setText(id);

    }







}

