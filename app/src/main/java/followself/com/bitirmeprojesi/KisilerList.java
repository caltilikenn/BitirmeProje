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

public class KisilerList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kisiler_list);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(KisilerList.this);
        List<String> list = db.showKisi(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(KisilerList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = adapterView.getItemAtPosition(i).toString();
                String[] array = txt.split("-");
                String[] array1 = array[0].split("ID=");
                int id = Integer.parseInt(array1[1]);
                String ad = array[1];
                String uzmanlik = array[2];
                String isyeri = array[3];

                Intent intent = new Intent(getApplicationContext(), KisilerDuzenle.class);
                intent.putExtra("id", id);
                intent.putExtra("ad",ad);
                intent.putExtra("uzmanlik", uzmanlik);
                intent.putExtra("isyeri", isyeri);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Kisiler.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
