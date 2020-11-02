package com.example.slovicka;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.slovicka.ui.main.SectionsPagerAdapter;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(view -> {
            String[] words = getResources().getStringArray(R.array.words);
            int index = viewPager.getCurrentItem();
            textToSpeech.speak(words[index], TextToSpeech.QUEUE_FLUSH, null, null);
        });

        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(new Locale("cs", "CZ"));
            }
        });
    }
}