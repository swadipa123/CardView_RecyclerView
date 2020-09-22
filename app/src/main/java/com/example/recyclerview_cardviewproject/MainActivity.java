package com.example.recyclerview_cardviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

        buttonInsert = findViewById(R.id.btn_insert);
        buttonRemove = findViewById(R.id.btn_remove);
        editTextInsert = findViewById(R.id.editText_insert);
        editTextRemove = findViewById(R.id.editText_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);

            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });

    }

    public void insertItem(int position) {

        mExampleList.add(position, new ExampleItem(R.drawable.ic_android, "New item at position" + position, "This is Line2"));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void createExampleList() {

        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Line 1", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_baseline_audiotrack_24, "Line 3", "Line 4"));
        mExampleList.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24, "Line 5", "Line 6"));

        //only  for effect of recyclerview
       /* exampleList.add(new ExampleItem(R.drawable.ic_android,"Line 7","Line 8"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_audiotrack_24,"Line 9","Line 10"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24,"Line 11","Line 12"));

        exampleList.add(new ExampleItem(R.drawable.ic_android,"Line 13","Line 14"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_audiotrack_24,"Line 15","Line 16"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24,"Line 17","Line 18"));

        exampleList.add(new ExampleItem(R.drawable.ic_android,"Line 19","Line 20"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_audiotrack_24,"Line 21","Line 22"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24,"Line 23","Line 24"));

        exampleList.add(new ExampleItem(R.drawable.ic_android,"Line 25","Line 26"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_audiotrack_24,"Line 27","Line 28"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24,"Line 29","Line 30"));
*/
    }

    public void buildRecyclerView() {

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}