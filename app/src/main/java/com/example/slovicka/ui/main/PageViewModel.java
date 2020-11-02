package com.example.slovicka.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<String> mText = new MutableLiveData<>();

    public void setText(String text)
    {
        mText.setValue(text);
    }

    public LiveData<String> getText() {
        return mText;
    }
}