package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String>arrayList;
    ArrayAdapter<String>arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lv);
        arrayList=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);

        String s ="{\n" +
                "\t\"Students\": [{\n" +
                "\t\t\t\"Name\": \"Uday\",\n" +
                "\t\t\t\"Phoneno\": 789\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Name\": \"Ajay\",\n" +
                "\t\t\t\"Phoneno\": 456\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Name\": \"Minnela\",\n" +
                "\t\t\t\"Phoneno\": 123\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        try {
            JSONObject rootObject = new JSONObject(s);
            JSONArray jsonArray = rootObject.getJSONArray("Students");
            for (int i=0;i<jsonArray.length();i++)
            {
                JSONObject stu = jsonArray.getJSONObject(i);
                String name = stu.getString("Name");
                int mob = stu.getInt("Phoneno");
                String s1 = name + " "+mob;
                arrayList.add(s1);
                listView.setAdapter(arrayAdapter);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
