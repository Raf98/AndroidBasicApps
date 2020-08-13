package com.example.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.R;
import com.example.cardview.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder>
{
    private List<Post> posts;

    public  PostAdapter(List<Post> listPosts)
    {
        this.posts = listPosts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemList = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.post_details, parent, false);

        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Post post = posts.get(position);

        holder.textName.setText(post.getName());
        holder.textPost.setText(post.getPost());
        holder.imagePost.setImageResource(post.getImage());

    }

    @Override
    public int getItemCount()
    {
        return posts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textName;
        private TextView textPost;
        private ImageView imagePost;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textPost = itemView.findViewById(R.id.textPost);
            imagePost = itemView.findViewById(R.id.imagePost);
        }
    }



}
