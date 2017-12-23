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

public class KanBasinciList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kan_basinci_list);
        Button btn1 = (Button) findViewById(R.id.btn1);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(KanBasinciList.this);
        List<String> list = db.showKanBasinci(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(KanBasinciList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = adapterView.getItemAtPosition(i).toString();
                String[] array = txt.split("-");
                String[] array1 = array[0].split("ID=");
                String[] array2 = array[1].split("mmHg");
                String[] array3 = array[2].split("mmHg");
                int id = Integer.parseInt(array1[1]);
                int sistolik = Integer.parseInt(array2[0]);
                int diyastolik = Integer.parseInt(array3[0]);
                int nabiz = Integer.parseInt(array[3]);
                String duzen = array[4];
                String tarih = array[5];
                String saat = array[6];

                Intent intent = new Intent(getApplicationContext(), KanBasinciDuzenle.class);
                intent.putExtra("id", id);
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
                startActivity(intent);
            }
        });
    }
}
