package com.sampa.activity;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private static final String CLASS_NAME = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activateStrictMode();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void buttonWidgetsClick(View view) {
        Log.d(CLASS_NAME, "entered MainActivity.buttonWidgetsClick(.)");
        Intent listIntent = new Intent(
                getApplicationContext(),
                ListActivity.class
        );
        startActivity(listIntent);
    }

    private void activateStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                    new StrictMode
                            .ThreadPolicy
                            .Builder()
                            .detectAll()
                            .penaltyLog()
                            .build()
            );
            StrictMode.setVmPolicy(
                    new StrictMode.
                            VmPolicy.
                            Builder()
                            .detectAll()
                            .penaltyLog()
                            .penaltyDeath()
                            .build()
            );
        }
    }
}
