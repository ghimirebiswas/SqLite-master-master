package bimal.softwarica.sqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helper.MyHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etWord, etMeaning;
    private Button btnSave, btnMeaningPage;
    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnSave = findViewById(R.id.btnSave);
        btnMeaningPage = findViewById(R.id.btnMeaningPage);

        btnSave.setOnClickListener(this);
        btnMeaningPage.setOnClickListener(this);

//        final MyHelper myHelper = new MyHelper(this);
//        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                long id = myHelper.InsertData(etWord.getText().toString(), etMeaning.getText().toString(), sqLiteDatabase);
//
//                if (id>0)
//                {
//                    Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnSave){
            myHelper = new MyHelper(this);
            sqLiteDatabase = myHelper.getWritableDatabase();
            long id = myHelper.InsertData(etWord.getText().toString(), etMeaning.getText().toString(), sqLiteDatabase);

            if (id>0)
            {
                Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId()==R.id.btnMeaningPage){
            Intent intent = new Intent(MainActivity.this, DisplayWordActivity.class);
            startActivity(intent);
        }
    }
}
