package mustafa.bagci.learnfrench.chaptertopics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import mustafa.bagci.learnfrench.R;
import mustafa.bagci.learnfrench.exercices.accents;
import mustafa.bagci.learnfrench.exercices.alphabet;
import mustafa.bagci.learnfrench.exercices.articles;
import mustafa.bagci.learnfrench.exercices.cedilla;
import mustafa.bagci.learnfrench.exercices.demonstrativeAdjectives;
import mustafa.bagci.learnfrench.exercices.futurOftheIndicative;
import mustafa.bagci.learnfrench.exercices.genderOfNouns;
import mustafa.bagci.learnfrench.exercices.imperative;
import mustafa.bagci.learnfrench.exercices.imperfectIndicatives;
import mustafa.bagci.learnfrench.exercices.pluralOfNouns;
import mustafa.bagci.learnfrench.exercices.possessiveAdjectives;
import mustafa.bagci.learnfrench.exercices.prepositions;
import mustafa.bagci.learnfrench.exercices.presentTense;
import mustafa.bagci.learnfrench.exercices.qualifyingAdjectivesAgreements;
import mustafa.bagci.learnfrench.exercices.qualifyingAdjectivesGeneral;
import mustafa.bagci.learnfrench.exercices.subjectPersonalPronouns;
import mustafa.bagci.learnfrench.exercices.typesOfSentences;
import mustafa.bagci.learnfrench.exercices.verbSubjectGroups;
import mustafa.bagci.learnfrench.exercices.verbesBeHaveGo;
import mustafa.bagci.learnfrench.lessons.allOtherCourses;
import mustafa.bagci.learnfrench.lessons.progCourses6Levels;
import mustafa.bagci.learnfrench.lessons.thousandOfExercices;
import mustafa.bagci.learnfrench.testyourlevel.frequentConfusionParonyms;
import mustafa.bagci.learnfrench.testyourlevel.leveTest2;
import mustafa.bagci.learnfrench.testyourlevel.levelTest1;
import mustafa.bagci.learnfrench.testyourlevel.spellingLevelTest;

public class TopicActivity extends AppCompatActivity {

    Toolbar toolbar;
    String topic;
    String arr[];
    String subHeading[];
    TopicAdapter adapter;
    ImageView topicImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_LearnFrench);
        super.onCreate(savedInstanceState);
        // Assuming EdgeToEdge is a custom utility class
        EdgeToEdge.enable(this);
        setContentView(R.layout.topic_activity);

        toolbar = findViewById(R.id.toolbar);
        topicImage = findViewById(R.id.topic_image);


        // Assuming TopicAdapter is a custom adapter class
        topic = getIntent().getStringExtra("topic");

        compareAndOpen();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = findViewById(R.id.listView);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Handle the click event for the selected item
            String selectedItem = arr[position];
            String selectedSubHeading = subHeading[position];
            openNewActivity(selectedItem, selectedSubHeading);
        });
    }

    private void compareAndOpen() {
        if (topic.equals("testyourlevel")) {
            arr = getResources().getStringArray(R.array.topic1); // Add array resource
            subHeading = getResources().getStringArray(R.array.subHeading1); // Add array resource
            topicImage.setImageResource(R.drawable.testyourlevel);
        } else if (topic.equals("lessons")) {
            arr = getResources().getStringArray(R.array.topic2); // Add array resource
            subHeading = getResources().getStringArray(R.array.subHeading2); // Add array resource
            topicImage.setImageResource(R.drawable.lessons);
        } else if (topic.equals("exercices")) {
            arr = getResources().getStringArray(R.array.topic3); // Add array resource
            subHeading = getResources().getStringArray(R.array.subHeading3); // Add array resource
            topicImage.setImageResource(R.drawable.exercices);
        } else {
            arr = null;
        }

        adapter = new TopicAdapter(arr, subHeading, TopicActivity.this);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    private void openNewActivity(String selectedItem, String selectedSubHeading) {
        String url = null;

        switch (selectedItem) {
            case "Level Test 1":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-8922.php";
                break;
            case "Level Test 2":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-38001.php";
                break;
            case "Spelling Level Test":
                url = "https://www.francaisfacile.com/test-de-niveau-francais-orthographe.php";
                break;
            case "Frequent Confusions/Paronyms":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-67241.php";
                break;
            case "Progressive courses 6 levels / Work guide":
                url = "https://www.francaisfacile.com/guide/";
                break;
            case "All other courses":
                url = "https://www.francaisfacile.com/cours/";
                break;
            case "Thousands of exercises classified by genres, themes, difficulties":
                url = "https://www.francaisfacile.com/exercices/";
                break;
            case "The alphabet":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-4479.php";
                break;
            case "Accents":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-56617.php";
                break;
            case "Cedilla":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-12494.php";
                break;
            case "The articles":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-114496.php";
                break;
            case "The gender of nouns":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-4047.php";
                break;
            case "Subject personal pronouns":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-48636.php";
                break;
            case "Verbs be-have":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-28110.php";
                break;
            case "Types of sentences":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-10771.php";
                break;
            case "The plural of nouns":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-13742.php";
                break;
            case "The verb, the subject and the groups":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-37843.php";
                break;
            case "The present tense":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-5665.php";
                break;
            case "The future of the indicative":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-48466.php";
                break;
            case "Imperfect indicative":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-5340.php";
                break;
            case "Qualifying adjectives - general":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-2766.php";
                break;
            case "Qualifying adjectives - agreements":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-27382.php";
                break;
            case "Possessive adjectives":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-22032.php";
                break;
            case "Demonstrative adjectives":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-31111.php";
                break;
            case "Prepositions":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-34101.php";
                break;
            case "The imperative":
                url = "https://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-32611.php";
                break;

            default:
                return;
        }

        if (url != null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }

}
