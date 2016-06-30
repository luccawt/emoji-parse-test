package com.example.luccawolf.emoji;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface EmojiService {

    @POST("/parserEmoji")
    Call<List<Token>> parseEmoji(@Body Phrase phrase);

}
