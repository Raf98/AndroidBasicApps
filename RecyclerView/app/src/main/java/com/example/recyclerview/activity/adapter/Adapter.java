package com.example.recyclerview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.model.Movie;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>
{
    private List<Movie> listMovies;

    public Adapter(List<Movie> listMovies)
    {
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemsList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_list, viewGroup, false);

        return new MyViewHolder(itemsList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        Movie movie = listMovies.get(i);

        myViewHolder.title.setText(movie.getTitle());
        myViewHolder.year.setText(movie.getGenre());
        myViewHolder.genre.setText(movie.getYear());
    }

    @Override
    public int getItemCount()
    {
        return listMovies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView year;
        TextView genre;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            title = itemView.findViewById(R.id.textTitle);
            year = itemView.findViewById(R.id.textYear);
            genre = itemView.findViewById(R.id.textGenre);
        }


    }

}
