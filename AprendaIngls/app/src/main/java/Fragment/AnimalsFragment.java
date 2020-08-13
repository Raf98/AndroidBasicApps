package Fragment;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.example.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalsFragment extends Fragment implements View.OnClickListener
{

    private ImageButton dogImage;
    private ImageButton catImage;
    private ImageButton lionImage;
    private ImageButton monkeyImage;
    private ImageButton sheepImage;
    private ImageButton cowImage;

    private MediaPlayer mediaPlayer;

    public AnimalsFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        dogImage = view.findViewById(R.id.dogImage);
        catImage = view.findViewById(R.id.catImage);
        lionImage = view.findViewById(R.id.lionImage);
        monkeyImage = view.findViewById(R.id.monkeyImage);
        sheepImage = view.findViewById(R.id.sheepImage);
        cowImage = view.findViewById(R.id.cowImage);

        dogImage.setOnClickListener(this);
        catImage.setOnClickListener(this);
        lionImage.setOnClickListener(this);
        monkeyImage.setOnClickListener(this);
        sheepImage.setOnClickListener(this);
        cowImage.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v)
    {
        //Log.i("Elemento clicado", "Item: "+v.getId());

        switch (v.getId())
        {
            case R.id.dogImage:
                playSound(R.raw.dog);
                break;

            case R.id.catImage:
                playSound(R.raw.cat);
                break;

            case R.id.lionImage:
                playSound(R.raw.lion);
                break;

            case R.id.monkeyImage:
                playSound(R.raw.monkey);
                break;

            case R.id.sheepImage:
                playSound(R.raw.sheep);
                break;

            case R.id.cowImage:
                playSound(R.raw.cow);
                break;
        }

    }


    public void playSound(int sound)
    {
        mediaPlayer = MediaPlayer.create(getActivity(), sound);

        if(mediaPlayer != null)
        {
            mediaPlayer.start();

            MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener()
            {
                @Override
                public void onCompletion(MediaPlayer mp)
                {
                    mp.release();
                }
            };

            mediaPlayer.setOnCompletionListener(completionListener);
        }
    }
}
