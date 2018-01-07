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

public class IlacList extends AppCompatActivity {

    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ilac_list);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        Button btn1 = (Button) findViewById(R.id.btn1);

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        ad = intent.getStringExtra("ad");
        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(IlacList.this);
        List<String> list = db.showIlac(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(IlacList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = adapterView.getItemAtPosition(i).toString();
                String[] array = txt.split(" - ");
                String[] array1 = array[1].split("mg");
                int etkinlik = Integer.parseInt(array1[0]);
                String ilacAd = array[0];
                String dozaj = array[2];
                String sekil = array[3];
                String siklik = array[4];
                String neden = array[5];
                String baslangic = array[6];
                String bitis = array[7];

                Intent intent = new Intent(getApplicationContext(), IlacDuzenle.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                intent.putExtra("ilacAd",ilacAd);
                intent.putExtra("etkinlik",etkinlik);
                intent.putExtra("dozaj",dozaj);
                intent.putExtra("sekil",sekil);
                intent.putExtra("siklik",siklik);
                intent.putExtra("neden", neden);
                intent.putExtra("baslangic", baslangic);
                intent.putExtra("bitis", bitis);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Ilaclar.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),Ilaclar.class);
        intent.putExtra("id", id);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
}
