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

public class TibbiCihazList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tibbi_cihaz_list);
        Button btn1 = (Button) findViewById(R.id.btn1);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(TibbiCihazList.this);
        List<String> list = db.showTibbiCihaz(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(TibbiCihazList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = adapterView.getItemAtPosition(i).toString();
                String[] array = txt.split("-");
                String[] array1 = array[0].split("ID=");
                int id = Integer.parseInt(array1[1]);
                String tur = array[1];
                String uretici = array[2];
                String konum = array[3];
                String model = array[4];
                int serino = Integer.parseInt(array[5]);
                String tarih = array[6];

                Intent intent = new Intent(getApplicationContext(), TibbiCihazDuzenle.class);
                intent.putExtra("id", id);
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
                startActivity(intent);
            }
        });
    }
}
