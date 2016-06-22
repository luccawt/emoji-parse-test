package com.example.luccawolf.emoji;


public class Token {

    private final String symbol;

    public Token(String symbol) {
        this.symbol = symbol;
    }

    public boolean isEmoji(EmojiRepository emojiRepository) {
        return emojiRepository.hasEmoji(symbol);
    }

    public int getEmojiImage(EmojiRepository emojiRepository) {
        return emojiRepository.getEmoji(symbol);
    }

    public String getSymbol() {
        return symbol;
    }



}
