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

public class Olcumler extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    int id;
    String ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olcumler);
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
        else if (itemId == R.id.boy) {
            Intent intent = new Intent(getApplicationContext(),Boy.class);
            intent.putExtra("id",id);
            intent.putExtra("ad",ad);
            startActivity(intent);
        }
        else if (itemId == R.id.kilo) {
            Intent intent = new Intent(getApplicationContext(),Kilo.class);
            intent.putExtra("id",id);
            intent.putExtra("ad",ad);
            startActivity(intent);
        }
        else if (itemId == R.id.egzersiz) {
            Intent intent = new Intent(getApplicationContext(),Egzersiz.class);
            intent.putExtra("id",id);
            intent.putExtra("ad",ad);
            startActivity(intent);
        }
        else if (itemId == R.id.kan_basinci) {
            Intent intent = new Intent(getApplicationContext(),KanBasinci.class);
            intent.putExtra("id",id);
            intent.putExtra("ad",ad);
            startActivity(intent);
        }
        else if (itemId == R.id.kan_sekeri){
            Intent intent = new Intent(getApplicationContext(),KanSekeri.class);
            intent.putExtra("id",id);
            intent.putExtra("ad",ad);
            startActivity(intent);
        }

        else if (itemId == R.id.kolesterol){
            Intent intent = new Intent(getApplicationContext(),Kolesterol.class);
            intent.putExtra("id",id);
            intent.putExtra("ad",ad);
            startActivity(intent);
        }

        else if (itemId == R.id.vucut_olculeri){
            Intent intent = new Intent(getApplicationContext(),VucutOlcu.class);
            intent.putExtra("id",id);
            intent.putExtra("ad",ad);
            startActivity(intent);
        }

        else if (itemId == R.id.cikis_yap) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Olcumler.this);
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
