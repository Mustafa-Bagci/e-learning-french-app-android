package mustafa.bagci.learnfrench.ui.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import mustafa.bagci.learnfrench.MainActivity;
import mustafa.bagci.learnfrench.R;

public class ScoreActivity extends AppCompatActivity {
    EditText scoreTxt,totalTxt;
    int score,total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);

        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 0);

        TextView scoreTextView = findViewById(R.id.score);
        TextView totalTextView = findViewById(R.id.total);

        scoreTextView.setText(String.valueOf(score));
        totalTextView.setText(String.valueOf(total));

        // Handle the button click to go back to the main quiz page
        Button backToQuizButton = findViewById(R.id.backToQuizButton);
        backToQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the button click, e.g., navigate to the main quiz page
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}