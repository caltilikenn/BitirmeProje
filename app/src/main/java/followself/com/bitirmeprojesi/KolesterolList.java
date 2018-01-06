package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class KolesterolList extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kolesterol_list);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        Button btn1 = (Button) findViewById(R.id.btn1);

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        ad = intent.getStringExtra("ad");
        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(KolesterolList.this);
        List<String> list = db.showKolesterol(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(KolesterolList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = adapterView.getItemAtPosition(i).toString();
                String[] array = txt.split(" ");
                String[] array1 = array[0].split("ID=");
                String[] array2 = array[1].split("mg/dL");
                String[] array3 = array[2].split("mg/dL");
                String[] array4 = array[3].split("mg/dL");
                String[] array5 = array[4].split("mg/dL");
                int id = Integer.parseInt(array1[1]);
                int ldl = Integer.parseInt(array2[0]);
                int hdl = Integer.parseInt(array3[0]);
                int trigliserit = Integer.parseInt(array4[0]);
                int toplam = Integer.parseInt(array5[0]);
                String tarih = array[5];
                String saat = array[6];

                Intent intent = new Intent(getApplicationContext(), KolesterolDuzenle.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                intent.putExtra("ldl",ldl);
                intent.putExtra("hdl",hdl);
                intent.putExtra("trigliserit",trigliserit);
                intent.putExtra("toplam",toplam);
                intent.putExtra("tarih", tarih);
                intent.putExtra("saat", saat);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Kolesterol.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),Kolesterol.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
}
