package com.udacity.gradle.builditbigger;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.jochemkleine.com.jokedisplaying.JokeDisplayingActivity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity {

    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (ProgressBar) findViewById(R.id.progressBar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
 //       spinner.setVisibility(View.VISIBLE);
        new ObtainJokeTask(this, this).execute();
    }


    public void tellJoke() {
   //     spinner.setVisibility(View.VISIBLE);
        new ObtainJokeTask(this, this).execute();
    }

    public void launchJoke (String joke) {
        spinner.setVisibility(View.GONE);
        Intent i = new Intent(this, JokeDisplayingActivity.class);
        i.putExtra("joke", joke);

        if (joke.contains("failed to connect")) {
            Toast.makeText(this, "Could not connect to the joke server!", Toast.LENGTH_LONG).show();
        } else {
            startActivity(i);
        }
    }
}
