package com.example.slovicka;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.slovicka.ui.main.SectionsPagerAdapter;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        FloatingActionButton fab = findViewById(R.id.fab);

        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                    @Override
                    public void onStart(String utteranceId) {
                        fab.setClickable(false);
                    }

                    @Override
                    public void onDone(String utteranceId) {
                        fab.setClickable(true);
                    }

                    @Override
                    public void onError(String utteranceId) {
                        // There was an error.
                    }
                });
                textToSpeech.setLanguage(new Locale("cs", "CZ"));
            }
        });

        fab.setOnClickListener(view -> {
            int index = viewPager.getCurrentItem();
            String word = sectionsPagerAdapter.getWord(index);
            textToSpeech.speak(word, TextToSpeech.QUEUE_ADD, null, word);
        });
    }
}