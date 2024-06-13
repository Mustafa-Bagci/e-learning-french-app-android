package mustafa.bagci.learnfrench.ui.videos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mustafa.bagci.learnfrench.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideosFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public VideosFragment() {
        // Required empty public constructor
    }

    public static VideosFragment newInstance() {
        VideosFragment fragment = new VideosFragment();
        return fragment;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideosFragment newInstance(String param1, String param2) {
        VideosFragment fragment = new VideosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videos, container, false);

        CardView cardView1 = view.findViewById(R.id.cardView1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=OGkbK9-_BRE&t=2s&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView2 = view.findViewById(R.id.cardView2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=7VOhQ2V4E14&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView3 = view.findViewById(R.id.cardView3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=054MD3i3RDE&t=199s&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView4 = view.findViewById(R.id.cardView4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=V7AjuIDn4oU&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView5 = view.findViewById(R.id.cardView5);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=8LBvMfR7fWc&t=918s&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView6 = view.findViewById(R.id.cardView6);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=84olv0BM4oY&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView7 = view.findViewById(R.id.cardView7);
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=5d3fWNcun28&t=89s&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView8 = view.findViewById(R.id.cardView8);
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=tHh_2s6gI7o&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView9 = view.findViewById(R.id.cardView9);
        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=tuLSsfQ5GOQ&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView10 = view.findViewById(R.id.cardView10);
        cardView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=j3gqgpxxtqI&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView11 = view.findViewById(R.id.cardView11);
        cardView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=2cYZfyeySVA&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView12 = view.findViewById(R.id.cardView12);
        cardView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=0QC1WPR0TNQ&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView13 = view.findViewById(R.id.cardView13);
        cardView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=TFCkx4kl5rc&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView14 = view.findViewById(R.id.cardView14);
        cardView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=4q_s_8MWHfY&ab_channel=TheperfectFrenchwithDylane");
            }
        });

        CardView cardView15 = view.findViewById(R.id.cardView15);
        cardView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=iEyvIzPKuIY&ab_channel=LearnFrenchWithAlexa");
            }
        });

        CardView cardView16 = view.findViewById(R.id.cardView16);
        cardView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo("https://www.youtube.com/watch?v=CshvIcQZZVg&ab_channel=Parlez-vousFRENCH%3ACoursdefran%C3%A7ais");
            }
        });

        return view;
    }

    private void openYouTubeVideo(String videoUrl) {
        // Create an Intent to open the YouTube app or a web browser with the video URL
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));

        // Check if there is an app to handle the Intent
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}