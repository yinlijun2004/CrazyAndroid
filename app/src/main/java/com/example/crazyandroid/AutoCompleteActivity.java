package com.example.crazyandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteActivity extends AppCompatActivity {
    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mauto;
    String[] books = new String[] {
            "Crazy Java",
            "Crazy Ajax",
            "Crazy XML",
            "Crazy Android"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, books);
        actv = (AutoCompleteTextView)findViewById(R.id.auto);
        mauto = (MultiAutoCompleteTextView)findViewById(R.id.mauto);
        actv.setAdapter(aa);
        mauto.setAdapter(aa);
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
