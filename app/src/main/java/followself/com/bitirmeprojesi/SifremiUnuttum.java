package followself.com.bitirmeprojesi;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SifremiUnuttum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sifremi_unuttum);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        final TextView txt2 = (TextView) findViewById(R.id.txt2);
        final EditText et1 = (EditText) findViewById(R.id.et1);
        Button btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email = et1.getText().toString();

                Database db = new Database(getApplicationContext());

                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Alanı boş bırakmayınız", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    return;
                }

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(getApplicationContext(), "Lütfen Geçerli bir email adresi giriniz", Toast.LENGTH_LONG).show();
                    et1.setText("");
                    return;
                }

                else {
                    if (db.checkUser(email.trim())) {

                        Toast.makeText(getApplicationContext(),db.sifreGoster(email),Toast.LENGTH_LONG).show();

                        /* Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.setType("plain/text");
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Followself şifre talebi");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                        String emailList[] = {info.followself@gmail.com};
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailList);
                        startActivity(emailIntent);
                        et1.setText(""); */
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Girdiğiniz e-mail adresi sistemde kayıtlı değildir", Toast.LENGTH_LONG).show();
                        et1.setText("");
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}