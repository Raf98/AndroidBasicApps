package com.example.recyclerview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Movie> listMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        this.fillMoviesList();

        Adapter adapter = new Adapter( listMovies );

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);


        recyclerView.addOnItemTouchListener
                (
                        new RecyclerItemClickListener
                                (
                                        getApplicationContext(),
                                        recyclerView,
                                        new RecyclerItemClickListener.OnItemClickListener()
                                        {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                                            {

                                            }

                                            @Override
                                            public void onItemClick(View view, int position)
                                            {
                                                String movieTitle = listMovies.get(position).getTitle();

                                                Toast.makeText
                                                        (
                                                                getApplicationContext(),
                                                                "Item pressionado: " + movieTitle,
                                                                Toast.LENGTH_SHORT
                                                        ).show();
                                            }

                                            @Override
                                            public void onLongItemClick(View view, int position)
                                            {
                                                String movieTitle = listMovies.get(position).getTitle();

                                                Toast.makeText
                                                        (
                                                                getApplicationContext(),
                                                                "Click longo: "  + movieTitle,
                                                                Toast.LENGTH_SHORT
                                                        ).show();
                                            }
                                        }
                                )
                );

    }

    public void fillMoviesList()
    {
        listMovies.add( new Movie( "Batman Vs Superman", "2016", "Ação" ) );
        listMovies.add( new Movie( "Liga da Justiça", "2017", "Ação" ) );
        listMovies.add( new Movie( "Mulher Maravilha", "2017", "Ação" ) );
        listMovies.add( new Movie( "Vingadores Ultimato", "2019", "Ação" ) );
        listMovies.add( new Movie( "Shrek 2", "2004", "Comédia" ) );
        listMovies.add( new Movie( "Capitão América: Guerra Civil", "2016", "Ação" ) );
        listMovies.add( new Movie( "Star Wars", "1977", "Ficção Científica" ) );
        listMovies.add( new Movie("Homem de Aço", "2013", "Ação") );
    }
}
