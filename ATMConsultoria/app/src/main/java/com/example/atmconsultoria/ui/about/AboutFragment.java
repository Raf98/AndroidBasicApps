package com.example.atmconsultoria.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutFragment extends Fragment {

    private AboutViewModel aboutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*aboutViewModel =
                ViewModelProviders.of(this).get(AboutViewModel.class);*/
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        //final TextView textView = root.findViewById(R.id.text_send);
        /*aboutViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/


        View aboutPage = new AboutPage(getContext())
                .isRTL(false)
                .setImage(R.drawable.logo)
                .setDescription("A ATM Consultorisa tem como objetivo pipipipopopo...")
                //.addItem(versionElement)
                //.addItem(adsElement)
                .addGroup("Fale conosco")
                .addWebsite("https://google.com.br/", "Acesse nosso site!")
                .addEmail("atmConsultoria@android.com", "Envie-nos um e-mail!")
                .addGroup("Redes Sociais")
                .addFacebook("google", "Acesse nosso Facebook")
                .addTwitter("medyo80")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addGitHub("medyo")
                .addInstagram("medyo80")
                .create();


        this.getActivity().setTitle("Sobre");
        return aboutPage;
    }
}