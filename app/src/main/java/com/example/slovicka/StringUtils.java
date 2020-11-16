package com.example.slovicka;

import java.text.Normalizer;

public class StringUtils {
    public static String stripDiacritics(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        String output = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return output;
    }
}
