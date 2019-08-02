package sg.edu.rp.c346.rp_websites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView tvCategory;
    TextView tvsubCategory;
    Spinner Category;
    Spinner subCategory;
    Button btngo;
    ArrayList<String> arList;
    ArrayAdapter<String> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCategory = findViewById(R.id.textViewCategory);
        tvsubCategory = findViewById(R.id.textViewSubCategory);
        Category = findViewById(R.id.spinnerCategory);
        subCategory = findViewById(R.id.spinnerSubCategory);
        btngo = findViewById(R.id.button);

        arList = new ArrayList<>();
        aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arList);

        btngo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int pos = Category.getSelectedItemPosition();
                int subpos = subCategory.getSelectedItemPosition();
                Intent intent = new Intent(MainActivity.this, CustomAdapter.class);

                if (pos == 0) {
                    String[] strOptions = getResources().getStringArray(R.array.RP);
                    arList.addAll(Arrays.asList(strOptions));
                    aa.notifyDataSetChanged();
                    if (subpos == 0) {
                        intent.putExtra("url", "https://www.rp.edu.sg/");
                        startActivity(intent);
                    } else {
                        intent.putExtra("url", "https://www.rp.edu.sg/student-life");

                        startActivity(intent);
                    }
                } else {
                    if (subpos == 0) {
                        intent.putExtra("url", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");

                        startActivity(intent);
                    } else {
                        intent.putExtra("url", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");

                        startActivity(intent);
                    }
                }

            }
        });
    }
}


