package com.example.luccawolf.emoji;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Phrase {

    private final String text;

    public Phrase(String text) {
        this.text = text;
    }




    public List<Token> getTokens() {
        final List<Token> tokens = new ArrayList<>();
        final StringTokenizer tokenizer = new StringTokenizer(text, " ");
        while (tokenizer.hasMoreTokens()) {
            tokens.add(new Token(tokenizer.nextToken()));
        }
        return tokens;
    }

}
