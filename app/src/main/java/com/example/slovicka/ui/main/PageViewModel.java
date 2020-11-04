package com.example.slovicka.ui.main;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.util.Random;
import java.util.stream.IntStream;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<SpannableString> mText = new MutableLiveData<>();

    public void setText(String text)
    {
        SpannableString spannableString = new SpannableString(text);
        Random randomGenerator = new Random();

        for (int i = 0; i < text.length(); i++) {
            int red = randomGenerator.nextInt(256);
            int green = randomGenerator.nextInt(256);
            int blue = randomGenerator.nextInt(256);
            int color = Color.rgb(red, green, blue);
            spannableString.setSpan(new ForegroundColorSpan(color), i,i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        mText.setValue(spannableString);
    }

    public LiveData<SpannableString> getText() {
        return mText;
    }
}