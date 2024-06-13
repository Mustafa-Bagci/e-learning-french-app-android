package mustafa.bagci.learnfrench.navdrawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import mustafa.bagci.learnfrench.R;

public class EbooksActivity extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ebooks);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView1 = findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPDF("French_visual_phrasebook.pdf");
            }
        });

        imageView2 = findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPDF("Easy_French_Step_by_step_Master_High_frequency_Grammar.pdf");
            }
        });

        imageView3 = findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPDF("Learn_French_with_Paul_Noble.pdf");
            }
        });

        imageView4 = findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPDF("collins_easy_learning_french_ grammar.pdf");
            }
        });

        imageView5 = findViewById(R.id.imageView5);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPDF("The_Complete_Idiots_Guide_to _Learning_French.pdf");
            }
        });

        imageView6 = findViewById(R.id.imageView6);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPDF("The-100-Most-Common-French-Words-Book.pdf");
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
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openPDF(String pdfFileName) {
        Intent intent = new Intent(getApplicationContext(), PDFViewerActivity.class);
        intent.putExtra("pdfFileName", pdfFileName);
        startActivity(intent);
    }
}