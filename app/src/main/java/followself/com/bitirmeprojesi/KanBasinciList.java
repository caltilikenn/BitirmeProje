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

public class KanBasinciList extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kan_basinci_list);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        Button btn1 = (Button) findViewById(R.id.btn1);

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        ad = intent.getStringExtra("ad");
        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(KanBasinciList.this);
        List<String> list = db.showKanBasinci(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(KanBasinciList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = adapterView.getItemAtPosition(i).toString();
                String[] array = txt.split(" - ");

                String[] array1 = array[0].split("mmHg");
                String[] array2 = array[1].split("mmHg");
                int sistolik = Integer.parseInt(array1[0]);
                int diyastolik = Integer.parseInt(array2[0]);
                int nabiz = Integer.parseInt(array[2]);
                String duzen = array[3];
                String tarih = array[4];
                String saat = array[5];

                Intent intent = new Intent(getApplicationContext(), KanBasinciDuzenle.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                intent.putExtra("sistolik",sistolik);
                intent.putExtra("diyastolik",diyastolik);
                intent.putExtra("nabiz",nabiz);
                intent.putExtra("duzen",duzen);
                intent.putExtra("tarih", tarih);
                intent.putExtra("saat", saat);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KanBasinci.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),KanBasinci.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
}
