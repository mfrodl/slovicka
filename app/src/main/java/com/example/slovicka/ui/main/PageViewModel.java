package com.example.slovicka.ui.main;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<SpannableString> mText = new MutableLiveData<>();

    public void setText(String text)
    {
        SpannableString spannableString = new SpannableString(text);
        Random randomGenerator = new Random();

        Integer[] colors = {
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.CYAN,
                Color.MAGENTA,
                Color.BLACK
        };

        Collections.shuffle(Arrays.asList(colors));

        for (int i = 0; i < text.length(); i++) {
            int color = colors[i % colors.length];
            spannableString.setSpan(new ForegroundColorSpan(color), i,i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        mText.setValue(spannableString);
    }

    public LiveData<SpannableString> getText() {
        return mText;
    }
}