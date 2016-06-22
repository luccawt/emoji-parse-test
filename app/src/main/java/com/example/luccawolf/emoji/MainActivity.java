package com.example.luccawolf.emoji;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EmojiRepository emojiRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        emojiRepository = new EmojiRepository();
        final Button button = (Button) findViewById(R.id.button);
        assert button != null;

        final Activity mySelf = this;

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final ListView listView = (ListView) findViewById(R.id.listView);
                assert listView != null;

                final TextView viewText = (TextView) findViewById(R.id.editText);
                assert viewText != null;

                final String text = viewText.getText().toString();
                final Phrase phrase = new Phrase(text);
                final List<Token> tokens = phrase.getTokens();

                listView.setAdapter(new TokenListAdapter(mySelf, tokens.toArray(new Token[tokens.size()]), emojiRepository));
            }
        });
    }
}
