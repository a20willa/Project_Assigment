package com.example.projectassigment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Globabala variabler
    private Locations[] locations;
    private final ArrayList<Locations> list = new ArrayList<Locations>();
    private ArrayAdapter<Locations> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Kör JSON funktionen (Relevant kod i onPostExecute)
        new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=a20willa");

        //Sätter listView
        listView = findViewById(R.id.list_view);

        //TODO: Add more content and map positions inside the web serivce to satisfy assigment goalls
    }

    //Options meny
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.settings_meny,menu);
        return true;
    }

    //Öppnar hemsida vid tryck
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Log.d("Text:","Success!");
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                return  true;

            default:return super.onOptionsItemSelected(item);
        }
    }

    //Parser
    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {

        private HttpURLConnection connection = null;
        private BufferedReader reader = null;

        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    builder.append(line).append("\n");
                }
                return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //Post execute parsing
        @Override
        protected void onPostExecute(String json) {
            Log.d("TAG", json);

            //Skapar adaptern och parsar datan, samt sätter listView
            Gson gson = new Gson();
            final Locations[] newLocation = gson.fromJson(json, Locations[].class);

            //Lägger till data i ArrayLissten
            for(int i = 0; i < newLocation.length; i++)
            {
                list.add(newLocation[i]);
            }

            //Adaptern använder sig av ArrayList (list)
            adapter = new ArrayAdapter<Locations>(MainActivity.this, R.layout.listview_item, R.id.item, list);
            adapter.notifyDataSetChanged();
            //ListView sätter sig till det av adaptern
            listView.setAdapter(adapter);

            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent2 = new Intent(MainActivity.this, map.class);
                    intent2.putExtra(Intent.EXTRA_TEXT, newLocation[position].getAuxdata());
                    startActivity(intent2);

                    return true;
                }
            });

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Context context = getApplicationContext();
                    CharSequence text = "Hint: " + newLocation[position].getName() + "\nLocation: " + newLocation[position].getLocation() + "\nRadius: " + newLocation[position].getSize() + "m^2";

                    TextView tv1 = (TextView)findViewById(R.id.exp_info);
                    tv1.setTextColor(Color.parseColor("#000000"));
                    tv1.setText(text);
                }
            });
        }
    }
}