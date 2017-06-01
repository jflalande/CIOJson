package fr.insa_cvl.ciojson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            String s = null;
            JSONObject json = null;Iterator<String> it = null;

            Log.i("CIO", "Message 1:");
            Log.i("CIO", "----------");
            s = new String("{\n" +
                    "  \"clef1\": \"value1\",\n" +
                    "  \"clef2\": 10,\n" +
                    "  \"clef3\": \"value3\"\n" +
                    "}");

            json = new JSONObject(s);

            it = json.keys();
            while (it.hasNext())
            {
                String key = it.next();
                Log.i("CIO", "JSON key: " + key);
                Log.i("CIO", "     value: " + json.getString(key));
            }

            Log.i("CIO", "Message 2:");
            Log.i("CIO", "----------");
            s = new String("{\n" +
                    "  \"clef1\": \"value1\",\n" +
                    "  \"clef2\": 10,\n" +
                    "  \"clef3\": \"value3\",\n" +
                    "  \"objet\": { \"clefa\": \"value4\" }\n" +
                    "}");

            json = new JSONObject(s);

            it = json.keys();
            while (it.hasNext())
            {
                String key = it.next();
                Log.i("CIO", "JSON key: " + key);
                Log.i("CIO", "     value: " + json.getString(key));
                Log.i("CIO", "     value of type: " + json.get(key).getClass());
            }

            Log.i("CIO", "Sous objet, valeur: " +
                            json.getJSONObject("objet")
                            .getString("clefa"));


            Log.i("CIO", "Message 3:");
            Log.i("CIO", "----------");

            s = new String("{\n" +
                "  \"tableau\" : [\n" +
                "    { \"nom\" : \"objet1\" },\n" +
                "    { \"nom\" : \"objet2\" },\n" +
                "    { \"nom\" : \"objet3\" }\n" +
                "    ]\n" +
                "}");

            json = new JSONObject(s);

            JSONArray array = json.getJSONArray("tableau");
            Log.i("CIO", "Taille du tableau: " + array.length());
            for (int i=0; i<array.length(); i++)
                Log.i("CIO", "Nom: " + array.getJSONObject(i).getString("nom"));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
