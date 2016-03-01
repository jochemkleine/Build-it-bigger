package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.example.jochemkleine.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Jochemkleine on 17-2-2016.
 */
public class ObtainJokeTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressDialog dialog;
    private MainActivity mainActivity;

    public ObtainJokeTask (Context context, MainActivity mainActivity) {
        this.context = context;
        dialog = new ProgressDialog(context);
        this.mainActivity = mainActivity;
    }

    public ObtainJokeTask (){

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.dialog.setMessage("Fetching Jokes!");
        this.dialog.show();
    }


    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    // .setRootUrl("http://10.0.2.2:8080/_ah/api/")

                    // The current IP server is meant for execution on a genymotion emulator
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        //context = params[0].first;
      //  String name = params[0].second;

        try {
            return myApiService.sendJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String result) {
      //  Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        mainActivity.launchJoke(result);
    }
}