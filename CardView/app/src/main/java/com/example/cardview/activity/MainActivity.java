package com.example.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.cardview.R;
import com.example.cardview.adapter.PostAdapter;
import com.example.cardview.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerPost;
    private List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts = new ArrayList<>();

        recyclerPost = findViewById(R.id.recyclerPost);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        recyclerPost.setLayoutManager(layoutManager);

        this.preparePosts();

        PostAdapter adapter = new PostAdapter(posts);
        recyclerPost.setAdapter(adapter);
    }

    public void preparePosts()
    {
        Post p = new Post("Jamilton Damasceno", "#tbt viagem legal!", R.drawable.imagem1);
        this.posts.add(p);

        p = new Post("Jamilton Damasceno", "#tbt viagem legal!", R.drawable.imagem2);
        this.posts.add(p);

        p = new Post("Jamilton Damasceno", "#tbt viagem legal!", R.drawable.imagem3);
        this.posts.add(p);

        p = new Post("Jamilton Damasceno", "#tbt viagem legal!", R.drawable.imagem4);
        this.posts.add(p);
    }
}
