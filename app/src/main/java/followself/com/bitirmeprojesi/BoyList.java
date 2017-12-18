package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class BoyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boy_list);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);

        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(BoyList.this);
        List<String> list = db.showBoy(id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(BoyList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);
    }
}
