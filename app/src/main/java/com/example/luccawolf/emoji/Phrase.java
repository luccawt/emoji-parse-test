package com.example.luccawolf.emoji;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Phrase {

    @JsonProperty("phrase")
    private final String text;

    public Phrase(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
