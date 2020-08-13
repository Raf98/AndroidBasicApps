package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ListView listPlaces;
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPlaces = findViewById(R.id.listPlaces);
        items = new ArrayList<>();

        items.add("Angra dos Reis");
        items.add("Caldas Novas");
        items.add("Campos do Jordão");
        items.add("Costa do Sauípe");
        items.add("Ilhéus");
        items.add("Porto Seguro");
        items.add("Tiradentes");
        items.add("Praga");
        items.add("Santiago");
        items.add("Zurique");
        items.add("Caribe");
        items.add("Buenos Aires");
        items.add("Budapeste");
        items.add("Cancún");
        items.add("Aruba");

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        items
                );

        listPlaces.setAdapter(adapter);

        listPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String itemSelected = listPlaces.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), itemSelected, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
