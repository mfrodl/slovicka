package com.example.slovicka.ui.main;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.util.Arrays;
import java.util.Collections;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<SpannableString> text = new MutableLiveData<>();

    public void setText(String text) {
        SpannableString spannableString = new SpannableString(text);

        Integer[] colors = {
                Color.rgb(0, 0, 0),
                Color.rgb(255, 0, 0),
                Color.rgb(0, 127, 0),
                Color.rgb(0, 0, 255),
                Color.rgb(255, 0, 255),
                Color.rgb(127, 0, 191),
        };

        Collections.shuffle(Arrays.asList(colors));

        for (int i = 0; i < text.length(); i++) {
            int color = colors[i % colors.length];
            spannableString.setSpan(new ForegroundColorSpan(color), i,i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        this.text.setValue(spannableString);
    }

    public LiveData<SpannableString> getText() {
        return text;
    }
}