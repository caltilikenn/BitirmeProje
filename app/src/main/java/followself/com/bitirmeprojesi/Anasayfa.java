package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;


public class Anasayfa extends AppCompatActivity {

    TextView txt1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        txt1=(TextView) findViewById(R.id.txt1);
        txt1.setText(email);
    }







}

