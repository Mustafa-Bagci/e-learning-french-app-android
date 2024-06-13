package mustafa.bagci.learnfrench.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import mustafa.bagci.learnfrench.R;
import mustafa.bagci.learnfrench.chaptertopics.TopicActivity;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    CardView testyourlevel, lessons, exercices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        testyourlevel = view.findViewById(R.id.testyourlevel);
        lessons = view.findViewById(R.id.lessons);
        exercices = view.findViewById(R.id.exercices);

        testyourlevel.setOnClickListener(this);
        lessons.setOnClickListener(this);
        exercices.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), TopicActivity.class);
        if (view.getId() == R.id.testyourlevel) {
            intent.putExtra("topic", "testyourlevel");
        } else if (view.getId() == R.id.lessons) {
            intent.putExtra("topic", "lessons");
        } else if (view.getId() == R.id.exercices) {
            intent.putExtra("topic", "exercices");
        }
        startActivity(intent);
    }
}
