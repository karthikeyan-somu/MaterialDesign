package com.example.kasomu.materialdesign;

import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.Toolbar;


public class FilterActivity extends Activity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        setStatusBarColor();
        setToolBar();
        setTitle("Filter Jobs");
        setHomeButton();
        filterFn();
    }

    private void filterFn() {
        final CheckBox morningJobs,afternoonJobs,eveningJobs,nightJobs;
        morningJobs = (CheckBox)findViewById(R.id.chkMorning);
        afternoonJobs = (CheckBox)findViewById(R.id.chkAfternoon);
        eveningJobs = (CheckBox)findViewById(R.id.chkEvening);
        nightJobs = (CheckBox)findViewById(R.id.chkNight);
        Button applyFilter = (Button)findViewById(R.id.btnFilter);
        applyFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button Click","Check box selected is : "+" "+morningJobs.isChecked()+" "+afternoonJobs.isChecked()+" "+eveningJobs.isChecked()+" "+nightJobs.isChecked());
            }
        });
    }

    private void setHomeButton() {
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_filter, menu);
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
        if(id == android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
