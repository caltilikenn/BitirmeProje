package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.graphics.Paint;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ilac_list);
        Button btn1 = (Button) findViewById(R.id.btn1);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(IlacList.this);
        List<String> list = db.showIlac(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(IlacList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = adapterView.getItemAtPosition(i).toString();
                String[] array = txt.split("-");
                String[] array1 = array[0].split("ID=");
                String[] array2 = array[2].split("mg");
                int id = Integer.parseInt(array1[1]);
                int etkinlik = Integer.parseInt(array2[0]);
                String ad = array[1];
                String dozaj = array[3];
                String sekil = array[4];
                String siklik = array[5];
                String neden = array[6];
                String baslangic = array[7];
                String bitis = array[8];

                Intent intent = new Intent(getApplicationContext(), IlacDuzenle.class);
                intent.putExtra("id", id);
                intent.putExtra("ad",ad);
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
                startActivity(intent);
            }
        });
    }
}
