package einkaufsliste.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List ekliste = new ArrayList<String>();
    // Global database object.
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Grab contents of both EditText fields and transform them to Strings.
                EditText anzahl = (EditText)findViewById(R.id.input_anzahl);
                EditText artikel = (EditText)findViewById(R.id.input_artikel);
                String artikelString = artikel.getText().toString();
                String anzahlString = anzahl.getText().toString();

                Snackbar.make(view, anzahlString + " x " + artikelString, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                hinzufügen();

                myDB.insertArticle(artikelString, Integer.parseInt(anzahlString));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Initialization of globally available database object. Pass context of this MainActivity.
        myDB = new DatabaseHelper(this);

    }
    public void hinzufügen(){
        EditText et1 = (EditText)findViewById(R.id.input_artikel);
        EditText et2 = (EditText)findViewById(R.id.input_anzahl);
        String s = et1.getText().toString() + "     Anzahl:  " + et2.getText();
        et2.setText("");
        et1.setText("");
        ekliste.add(s);
        ListAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.list_item_ekliste, R.id.list_item_ekliste_textview, ekliste);
        ListView lv = (ListView)findViewById(R.id.ekliste);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ekinfo = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), ekinfo, Toast.LENGTH_LONG).show();
            }
        });
        et1.setSelection(0);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       // drawer.onDraw();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
