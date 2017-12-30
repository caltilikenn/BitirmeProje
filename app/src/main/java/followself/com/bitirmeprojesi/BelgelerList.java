package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class BelgelerList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.belgeler_list);
        Button btn1 = (Button) findViewById(R.id.btn1);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);
        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(BelgelerList.this);
        List<String> list = db.showResimler(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(BelgelerList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String ad = adapterView.getItemAtPosition(i).toString();
                Intent intent = new Intent(getApplicationContext(), BelgelerDuzenle.class);
                intent.putExtra("id", id);
                intent.putExtra("ad", ad);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Belgeler.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}
