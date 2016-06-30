package com.example.luccawolf.emoji;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button button = (Button) findViewById(R.id.button);
        assert button != null;

        final MainActivity mySelf = this;

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(mySelf, "Consultando servidor de emojis. Aguarde um instante, por favor...", Toast.LENGTH_LONG).show();

                final ListView listView = (ListView) findViewById(R.id.listView);
                assert listView != null;

                final TextView viewText = (TextView) findViewById(R.id.editText);
                assert viewText != null;

                final String text = viewText.getText().toString();
                final Phrase phrase = new Phrase(text);

                final ParseEmojiTask task = new ParseEmojiTask(mySelf, listView);
                task.execute(phrase);
            }
        });
    }

    private class ParseEmojiTask extends AsyncTask<Phrase, Void, List<Token>> {

        private final MainActivity activity;
        private final ListView listView;

        private ParseEmojiTask(MainActivity activity, ListView listView) {
            this.activity = activity;
            this.listView = listView;
        }

        @Override
        protected List<Token> doInBackground(Phrase... params) {
            final Phrase phrase = params[0];

            final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EmojiServer.getInstance().getUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

            final EmojiService service = retrofit.create(EmojiService.class);

            final Call<List<Token>> callExecutor = service.parseEmoji(phrase);

            try {
                final Response<List<Token>> response = callExecutor.execute();
                return response.body();
            } catch (IOException e) {
                Log.e(getClass().getSimpleName(), "Error parsing emoji", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Token> tokens) {
            if (tokens != null && tokens.size() > 0) {
                listView.setAdapter(new TokenListAdapter(activity, tokens.toArray(new Token[tokens.size()])));
            } else {
                activity.showWarningMessage("Nenhum emoji foi encontrado");
            }
        }
    }

    private void showWarningMessage(final String message) {
        final MainActivity activity = this;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
