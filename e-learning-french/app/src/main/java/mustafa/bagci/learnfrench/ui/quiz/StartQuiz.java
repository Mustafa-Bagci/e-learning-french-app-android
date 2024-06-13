package mustafa.bagci.learnfrench.ui.quiz;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mustafa.bagci.learnfrench.R;

public class StartQuiz extends AppCompatActivity {

    private TextView questionTxt, indicator;
    private LinearLayout container;
    private int score = 0;
    private int position = 0;
    private int count = 0;

    DatabaseReference reference;

    private List<QuestionData> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_quiz);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        questionTxt = findViewById(R.id.question);
        indicator = findViewById(R.id.indicator);
        container = findViewById(R.id.linearLayout2);

        list = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference();

        reference.child("Questions").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String question = snapshot.child("question").getValue().toString();
                    String option1 = snapshot.child("option1").getValue().toString();
                    String option2 = snapshot.child("option2").getValue().toString();
                    String option3 = snapshot.child("option3").getValue().toString();
                    String option4 = snapshot.child("option4").getValue().toString();
                    String answer = snapshot.child("answer").getValue().toString();

                    list.add(new QuestionData(option1, option2, option3, option4, question, answer));

                }
                if (list.size() > 0) {
                    loadQuestion(questionTxt, 0, list.get(position).getQuestion());

                    for (int i = 0; i < 4; i++) {
                        container.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                checkAnswer((Button) view);
                            }
                        });
                    }

                } else {
                    Toast.makeText(StartQuiz.this, "No Questions found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(StartQuiz.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Handle the Up button click
                finish(); // or navigateUpTo(new Intent(this, YourParentActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void checkAnswer(Button selectedOption) {
        if (position < list.size()) {
            String selectedAnswer = selectedOption.getText().toString();
            String correctAnswer = list.get(position).getAnswer();

            // Disable buttons after an answer is selected
            enabled(false);

            // Check if the selected answer is correct
            if (selectedAnswer.equals(correctAnswer)) {
                score++;
                selectedOption.setBackgroundColor(Color.parseColor("#4CAF50")); // Green color for correct answer
            } else {
                selectedOption.setBackgroundColor(Color.parseColor("#ff0000")); // Red color for incorrect answer
                if (correctAnswer != null) {
                    Button correctOption = container.findViewWithTag(correctAnswer);
                    if (correctOption != null) {
                        correctOption.setBackgroundColor(Color.parseColor("#4CAF50")); // Green color for correct answer
                    }
                }
            }

            // Move to the next question after a short delay
            container.postDelayed(new Runnable() {
                @Override
                public void run() {
                    moveToNextQuestion();
                }
            }, 500); // Adjust the delay duration as needed (in milliseconds)
        }
    }




    private void moveToNextQuestion() {
        // Enable buttons for the next question
        enabled(true);

        // Delay to show the correct/incorrect feedback for a short duration
        container.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if there are more questions
                if (position < list.size() - 1) {
                    position++;
                    count = 0;
                    loadQuestion(questionTxt, 0, list.get(position).getQuestion());
                } else {
                    // If there are no more questions, navigate to the ScoreActivity
                    Intent intent = new Intent(StartQuiz.this, ScoreActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("total", list.size());
                    startActivity(intent);
                    finish();
                }
            }
        }, 500); // Adjust the delay duration as needed (in milliseconds)
    }



    private void enabled (Boolean enable){
        for (int i = 0; i < 4; i++){
            container.getChildAt(i).setEnabled(enable);
            if (enable){
                ((Button) container.getChildAt(i)).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
            }
        }
    }


    private void loadQuestion(final View view, final int value, final String data) {
        // Reset the background color for each button
        for (int i = 0; i < 4; i++) {
            container.getChildAt(i).setBackgroundColor(Color.parseColor("#989898"));
        }

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(200)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {
                        if (value == 0 && count < 4) {
                            String option = "";
                            if (count == 0)
                                option = list.get(position).getOption1();
                            else if (count == 1)
                                option = list.get(position).getOption2();
                            else if (count == 2)
                                option = list.get(position).getOption3();
                            else if (count == 3)
                                option = list.get(position).getOption4();

                            loadQuestion(container.getChildAt(count), 0, option);
                            count++;
                        }
                    }

                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {
                        if (value == 0) {
                            try {
                                ((TextView) view).setText(data);
                                indicator.setText((position + 1) + "/" + list.size()); // Update indicator value
                            } catch (ClassCastException e) {
                                ((Button) view).setText(data);
                            }
                            view.setTag(data);
                            loadQuestion(view, 1, data);
                        }
                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {
                    }
                });
    }
}