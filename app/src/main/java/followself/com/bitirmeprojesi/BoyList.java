package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BoyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boy_list);
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);

        txt1.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txt2.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txt3.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);

        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(BoyList.this);
        List<String> list = db.showBoy(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(BoyList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = adapterView.getItemAtPosition(i).toString();
                String[] array = txt.split("                    ");
                int id = Integer.parseInt(array[0]);
                String[] array1 = array[1].split("cm");
                int boy = Integer.parseInt(array1[0]);
                String tarih = array[2];

                Intent intent = new Intent(getApplicationContext(), BoyDuzenle.class);
                intent.putExtra("id", id);
                intent.putExtra("boy",boy);
                intent.putExtra("tarih", tarih);
                startActivity(intent);
            }
        });
    }
}
