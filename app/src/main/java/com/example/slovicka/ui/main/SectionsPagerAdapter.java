package com.example.slovicka.ui.main;

import android.content.Context;

import com.example.slovicka.R;
import com.example.slovicka.StringUtils;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final String[] words;
    private final Random random;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.words = context.getResources().getStringArray(R.array.words);
        Collections.shuffle(Arrays.asList(words));
        random = new Random();
    }

    @NotNull
    @Override
    public Fragment getItem(int index) {
        String word = words[index];
        String other;

        do {
            int otherIndex = random.nextInt(words.length);
            other = words[otherIndex];
        } while (other.toLowerCase().equals(word.toLowerCase()));

        String[] images = {word, other};
        Collections.shuffle(Arrays.asList(images));

        return PlaceholderFragment.newInstance(word, images);
    }

    @Override
    public int getCount() {
        return words.length;
    }

    public String getWord(int index) {
        return words[index];
    }
}