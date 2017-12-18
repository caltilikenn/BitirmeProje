package followself.com.bitirmeprojesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class YonetimPaneli extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yonetim_paneli);

        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(YonetimPaneli.this);
        List<String> list = db.showUserList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(YonetimPaneli.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);
    }
}
