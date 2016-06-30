package com.example.luccawolf.emoji;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {

    @JsonProperty
    private String symbol;

    @JsonProperty
    private String imageName;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return String.format("%s/image/%s", EmojiServer.getInstance().getUrl(), imageName);
    }
}
