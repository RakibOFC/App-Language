package com.rakibofc.applanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView messageView;
    Button btnBangla, btnEnglish;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referencing the text and button views
        messageView = findViewById(R.id.textView);
        btnBangla = findViewById(R.id.btnBangla);
        btnEnglish = findViewById(R.id.btnEnglish);

        context = LocaleHelper.getDefault(this);
        resources = context.getResources();
        messageView.setText(resources.getString(R.string.language));

        // setting up on click listener event over the button
        // in order to change the language with the help of
        // LocaleHelper class
        btnEnglish.setOnClickListener(view -> {

            context = LocaleHelper.setLocale(MainActivity.this, "en");
            resources = context.getResources();
            messageView.setText(resources.getString(R.string.language));
        });

        btnBangla.setOnClickListener(view -> {

            context = LocaleHelper.setLocale(MainActivity.this, "bn");
            resources = context.getResources();
            messageView.setText(resources.getString(R.string.language));
        });
    }
}