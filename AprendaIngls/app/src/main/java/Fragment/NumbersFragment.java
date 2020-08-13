package Fragment;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment implements View.OnClickListener {

    private ImageButton oneImage;
    private ImageButton twoImage;
    private ImageButton threeImage;
    private ImageButton fourImage;
    private ImageButton fiveImage;
    private ImageButton sixImage;

    MediaPlayer mediaPlayer;


    public NumbersFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);

        oneImage = view.findViewById(R.id.oneImage);
        twoImage = view.findViewById(R.id.twoImage);
        threeImage = view.findViewById(R.id.threeImage);
        fourImage = view.findViewById(R.id.fourImage);
        fiveImage = view.findViewById(R.id.fiveImage);
        sixImage = view.findViewById(R.id.sixImage);

        oneImage.setOnClickListener(this);
        twoImage.setOnClickListener(this);
        threeImage.setOnClickListener(this);
        fourImage.setOnClickListener(this);
        fiveImage.setOnClickListener(this);
        sixImage.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v)
    {
            //Log.i("Elemento clicado", "Item: "+v.getId());

            switch (v.getId()) {
                case R.id.oneImage:
                    playSound(R.raw.one);
                    break;

                case R.id.twoImage:
                    playSound(R.raw.two);
                    break;

                case R.id.threeImage:
                    playSound(R.raw.three);
                    break;

                case R.id.fourImage:
                    playSound(R.raw.four);
                    break;

                case R.id.fiveImage:
                    playSound(R.raw.five);
                    break;

                case R.id.sixImage:
                    playSound(R.raw.six);
                    break;
            }

        }


        public void playSound ( int sound)
        {
            mediaPlayer = MediaPlayer.create(getActivity(), sound);

            if (mediaPlayer != null) {
                mediaPlayer.start();

                MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                };

                mediaPlayer.setOnCompletionListener(completionListener);
            }


        }


}

