package followself.com.bitirmeprojesi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class HesapAyarlari extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hesap_ayarlari);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        ad = intent.getStringExtra("ad");
        TextView txt1 = (TextView) findViewById(R.id.nav_txt1);
        txt1.setText(ad);
        ActionBar ab = getSupportActionBar();
        ab.setIcon(R.drawable.bg);
        ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_renk));

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(getApplicationContext(),Anasayfa.class);
            intent.putExtra("id",id);
            intent.putExtra("ad",ad);
            startActivity(intent);
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int itemId = item.getItemId();

        if (itemId == R.id.anasayfa) {
            Intent intent = new Intent(getApplicationContext(),Anasayfa.class);
            intent.putExtra("id",id);
            intent.putExtra("ad",ad);
            startActivity(intent);
        }
        else if (itemId == R.id.sifre_degistir) {
            Intent intent = new Intent(getApplicationContext(),SifreDegistir.class);
            intent.putExtra("id",id);
            intent.putExtra("ad",ad);
            startActivity(intent);
        }
        else if (itemId == R.id.hesabi_sil) {
            AlertDialog.Builder builder = new AlertDialog.Builder(HesapAyarlari.this);
                builder.setTitle("Hesap Silmeyi Onayla");
                builder.setMessage("Hesabınızı silerseniz hesabınız kalıcı olarak kaldırılır ve tüm verileriniz silinir. Onaylıyor musunuz?");
                builder.setNegativeButton("VAZGEÇ", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });

                builder.setPositiveButton("HESABI SİL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        Database db = new Database(HesapAyarlari.this);
                        db.kullaniciSil(id);
                        Toast.makeText(getApplicationContext(),"Hesabınız ve verileriniz kalıcı olarak silindi", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                });
                builder.show();
        }

        else if (itemId == R.id.cikis_yap) {
            AlertDialog.Builder builder = new AlertDialog.Builder(HesapAyarlari.this);
            builder.setTitle("Çıkış Yap");
            builder.setMessage("Çıkış yapmak istediğinize emin misiniz?");
            builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int i) {

                }
            });
            builder.setPositiveButton("ÇIKIŞ YAP", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int i) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                    System.exit(0);
                }
            });
            builder.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
