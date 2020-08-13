package com.example.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragments.R;
import com.example.fragments.fragment.ChatFragment;
import com.example.fragments.fragment.ContactFragment;

public class MainActivity extends AppCompatActivity
{

    private Button buttonChat, buttonContact;
    private ChatFragment chatFrag;
    private ContactFragment contactFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonContact = findViewById(R.id.buttonContact);
        buttonChat = findViewById(R.id.buttonChat);

        //remover sombra do ActionBar
        getSupportActionBar().setElevation(0);

        chatFrag = new ChatFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, chatFrag);
        transaction.commit();

        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                contactFrag = new ContactFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, contactFrag);
                transaction.commit();
            }
        });

        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                chatFrag = new ChatFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, chatFrag);
                transaction.commit();
            }
        });


    }
}
