package com.example.slovicka.ui.main;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slovicka.MainActivity;
import com.example.slovicka.R;
import com.example.slovicka.StringUtils;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private PageViewModel pageViewModel;
    private MainActivity main;

    @NotNull
    public static PlaceholderFragment newInstance(String word, String[] images) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putString("word", word);
        bundle.putStringArray("images", images);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity) getActivity();
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        pageViewModel.setText(getWord());
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, textView::setText);

        String image0 = getImage(0);
        ImageView imageView0 = root.findViewById(R.id.imageView0);
        imageView0.setImageResource(getDrawableId(image0));
        if (getWord().equalsIgnoreCase(image0)) {
            imageView0.setClickable(true);
            imageView0.setOnClickListener(view -> {
                main.getTextToSpeech().speak(image0, TextToSpeech.QUEUE_FLUSH, null, image0);
            });
        }

        String image1 = getImage(1);
        ImageView imageView1 = root.findViewById(R.id.imageView1);
        imageView1.setImageResource(getDrawableId(getImage(1)));
        if (getWord().equalsIgnoreCase(image1)) {
            imageView1.setClickable(true);
            imageView1.setOnClickListener(view -> {
                main.getTextToSpeech().speak(image1, TextToSpeech.QUEUE_FLUSH, null, image1);
            });
        }

        return root;
    }

    private String getWord() {
        return getArguments().getString("word");
    }

    private String getImage(int i) {
        return getArguments().getStringArray("images")[i];
    }

    private int getDrawableId(String name) {
        Context context = getContext();
        String packageName = context.getPackageName();
        String resourceName = StringUtils.stripDiacritics(name).toLowerCase();
        return context.getResources().getIdentifier(resourceName, "drawable", packageName);
    }

}