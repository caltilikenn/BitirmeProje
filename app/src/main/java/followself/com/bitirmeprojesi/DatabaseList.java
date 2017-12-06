package followself.com.bitirmeprojesi;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;

public class DatabaseList extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_list);

        final ListView lv = (ListView)findViewById(R.id.lv);
        Database db = new Database(DatabaseList.this);
        List<String> list = db.showList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DatabaseList.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lv.setAdapter(adapter);

    }
}