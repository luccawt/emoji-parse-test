package com.example.luccawolf.emoji;

import java.util.HashMap;
import java.util.Map;

public class EmojiRepository {

    private static final Map<String, Integer> emojiMap;

    static {
        emojiMap = new HashMap<>();
        emojiMap.put(":)", R.drawable.happyface);
        emojiMap.put("OSfrog", R.drawable.osfrog);
        emojiMap.put(";)", R.drawable.piscada);
        emojiMap.put(";P", R.drawable.lingua);
        emojiMap.put("S2", R.drawable.coracao);
        emojiMap.put(":D",R.drawable.sorriso);


    }

    public int getEmoji(String symbol) {
        return emojiMap.get(symbol);
    }

    public boolean hasEmoji(String symbol) {
        return emojiMap.containsKey(symbol);
    }
}
