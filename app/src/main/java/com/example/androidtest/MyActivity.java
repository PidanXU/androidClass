package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public SearchAdapter mSearchAdapter = new SearchAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mSearchAdapter);
        List<String> items = new ArrayList<>();
        for(int i=0;i<100;i++){
            items.add(String.valueOf(i));
        }
        mSearchAdapter.notifyItems(items);
        final List<String> tmpItems = new ArrayList<>();
        tmpItems.addAll(items);
        EditText mSearchText = (EditText)findViewById(R.id.search_text);
        mSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    return;
                }
                List<String> items1 = new ArrayList<>();
                for (int i = 0; i < tmpItems.size(); i++) {
                    if (tmpItems.get(i).contains(editable.toString())) {
                        items1.add(tmpItems.get(i));
                    }
                }
                mSearchAdapter.notifyItems(items1);
            }
        });


    }
}