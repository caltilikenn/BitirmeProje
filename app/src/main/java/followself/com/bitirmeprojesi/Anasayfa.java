package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Anasayfa extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);
        TextView txt1=(TextView) findViewById(R.id.txt1);
        Button btn1=(Button) findViewById(R.id.btn1);

        Intent intent = getIntent();
        String ad = intent.getStringExtra("ad");
        final int id = intent.getIntExtra("id",0);
        txt1.setText(ad);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),""+id,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),Boy.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }
}

