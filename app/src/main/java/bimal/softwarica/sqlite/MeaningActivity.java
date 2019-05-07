package bimal.softwarica.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MeaningActivity extends AppCompatActivity {

    private TextView tvMeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);

        tvMeaning = findViewById(R.id.tvMeaning);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            String meaning = bundle.getString("meaning");
            tvMeaning.setText(meaning);
        }


    }
}
