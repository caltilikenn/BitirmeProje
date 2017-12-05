package followself.com.bitirmeprojesi;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DatabaseList extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_list);

      //Listeleme işlemi
        final EditText et1=(EditText)findViewById(R.id.et1);
      Database db = new Database(getApplicationContext());
        List<UyelikBilgi> list = new ArrayList<UyelikBilgi>();
        list=db.showList();
        StringBuilder sb = new StringBuilder();

        for(UyelikBilgi ub: list){
            String icerik="";
            icerik="ID: " + ub.getId() + " EMAIL: " + ub.getEmail() + " SIFRE: " + ub.getSifre() + "\n";
            sb.append(icerik);
        }
        et1.setText(sb);
    }
}