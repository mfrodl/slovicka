package com.example.slovicka.ui.main;

import android.content.Context;

import com.example.slovicka.R;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final String[] words;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.words = context.getResources().getStringArray(R.array.words);
        Collections.shuffle(Arrays.asList(words));
    }

    @NotNull
    @Override
    public Fragment getItem(int index) {
        return PlaceholderFragment.newInstance(words[index]);
    }

    @Override
    public int getCount() {
        return words.length;
    }

    public String getWord(int index) {
        return words[index];
    }
}