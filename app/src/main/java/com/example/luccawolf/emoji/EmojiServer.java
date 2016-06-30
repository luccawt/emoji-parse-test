package com.example.luccawolf.emoji;

public final class EmojiServer {

    private static EmojiServer instance;

    public static EmojiServer getInstance() {
        if (instance == null) {
            instance = new EmojiServer();
        }
        return instance;
    }

    private String url;

    private EmojiServer() {
        url = "http://luccawt-195389.nitrousapp.com:8081";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
