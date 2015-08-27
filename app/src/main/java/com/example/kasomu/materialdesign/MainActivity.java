package com.example.kasomu.materialdesign;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toolbar;


public class MainActivity extends Activity{
    private Toolbar toolbar;
    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP","J C","C asjkfhasjkhfuiwruhasjfjksahfuqwiurhakkjsankxnvkjasgfyuwgfkasjfhkj"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBarColor();
        setToolBar();
        setTitle("OSM Main");
        setNavigationDrawer();
        setAutoComplete();
    }

    private void setAutoComplete() {
        /*TextView text = (TextView) findViewById(R.id.search_box);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Search bar click","You have clicked searched bar");
                ((TextView) findViewById(R.id.search_box)).setText(" ");
            }
        });*/
        //Creating the instance of ArrayAdapter containing list of language names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,language);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.search_box);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        //actv.setTextColor(Color.RED);
    }

    private void setNavigationDrawer() {
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)getFragmentManager().findFragmentById(R.id.nav_drawer_fragment);
        drawerFragment.setUp(R.id.nav_drawer_fragment,(DrawerLayout)findViewById(R.id.drawerLayoutid),toolbar);
    }

    private void setStatusBarColor() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.primaryColorDark));
    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.app_barid);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setDisplayShowHomeEnabled(true);
        //getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //Based on menu_main.xml file
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("Mainactivity", "inside main");
       int id = item.getItemId();

        //If we click on filter icon
        if(id == R.id.menu_filter)
        {
            startActivity(new Intent(this,FilterActivity.class));
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (NavigationDrawerFragment.mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
