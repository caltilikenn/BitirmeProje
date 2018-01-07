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

public class TibbiCihazList extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tibbi_cihaz_list);
        Button btn1 = (Button) findViewById(R.id.btn1);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        ad = intent.getStringExtra("ad");

        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(TibbiCihazList.this);
        List<String> list = db.showTibbiCihaz(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(TibbiCihazList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = adapterView.getItemAtPosition(i).toString();
                String[] array = txt.split(" - ");

                String tur = array[0];
                String uretici = array[1];
                String konum = array[2];
                String model = array[3];
                String serino = array[4];
                String tarih = array[5];

                Intent intent = new Intent(getApplicationContext(), TibbiCihazDuzenle.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                intent.putExtra("tur",tur);
                intent.putExtra("uretici",uretici);
                intent.putExtra("konum",konum);
                intent.putExtra("model",model);
                intent.putExtra("serino",serino);
                intent.putExtra("tarih", tarih);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TibbiCihazlar.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),TibbiCihazlar.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
}
