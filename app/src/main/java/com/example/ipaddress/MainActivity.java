package com.example.ipaddress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private String responseString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
        new GetData().execute();

    //POST METHOD
//        https://api.freedomrobotics.ai/accounts/AF9111FB06CD795D636B8E2AA/devices/D8252D3D5B65C5E1CE9A1C7A684/?mc_token=T6e1428e1e4499aa7f7146cf6&mc_secret=Sfccd4c788405f188bed3be27

       }

    public class GetData extends AsyncTask<Void, Void, Void> {

        private static final String TAG = "Response";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {

            OkHttpClient client = new OkHttpClient();

//            URLS
//            1 http://pratikbutani.x10.mx/json_data.json
//            2 http://api.androidhive.info/json/movies.json
//            3 https://api.freedomrobotics.ai/accounts/AF9111FB06CD795D636B8E2AA/devices/D8252D3D5B65C5E1CE9A1C7A684/?mc_token=T6e1428e1e4499aa7f7146cf6&mc_secret=Sfccd4c788405f188bed3be27

            Request request = new Request.Builder()
                    .url("https://api.freedomrobotics.ai/accounts/AF9111FB06CD795D636B8E2AA/devices/D8252D3D5B65C5E1CE9A1C7A684/?mc_token=T6e1428e1e4499aa7f7146cf6&mc_secret=Sfccd4c788405f188bed3be27")
                    .build();

            Response response = null;

            try {

                response = client.newCall(request).execute();
                responseString = response.body().string();

            } catch (Exception e) {

                Log.e(TAG, "doInBackground: Error"+e );
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            TextView response = (TextView) findViewById(R.id.response);
            response.setText(responseString);
            Log.i(TAG, "onPostExecute: " + responseString);
        }

    }


}