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

public class EgzersizList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.egzersiz_list);
        Button btn1 = (Button) findViewById(R.id.btn1);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);

        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(EgzersizList.this);
        List<String> list = db.showEgzersiz(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EgzersizList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txt = adapterView.getItemAtPosition(i).toString();
                String[] array = txt.split(" ");
                String[] array1 = array[0].split("ID=");
                String[] array2 = array[2].split("dk");
                String[] array3 = array[3].split("m");
                String[] array4 = array[4].split("adım");
                String[] array5 = array[5].split("cal");
                int id = Integer.parseInt(array1[1]);
                int sure = Integer.parseInt(array2[0]);
                int mesafe = Integer.parseInt(array3[0]);
                int adim = Integer.parseInt(array4[0]);
                int kalori = Integer.parseInt(array5[0]);
                String tur = array[1];
                String tarih = array[6];
                String saat = array[7];

                Intent intent = new Intent(getApplicationContext(), EgzersizDuzenle.class);
                intent.putExtra("id", id);
                intent.putExtra("tur",tur);
                intent.putExtra("sure",sure);
                intent.putExtra("mesafe",mesafe);
                intent.putExtra("adim",adim);
                intent.putExtra("kalori",kalori);
                intent.putExtra("tarih", tarih);
                intent.putExtra("saat", saat);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Egzersiz.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
