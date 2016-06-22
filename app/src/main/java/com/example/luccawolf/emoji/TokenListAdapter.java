package com.example.luccawolf.emoji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TokenListAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;

    private final EmojiRepository emojiRepository;

    private Context context;
    private Token[] tokens;

    public TokenListAdapter(Context context, Token[] tokens, EmojiRepository emojiRepository) {
        this.tokens = tokens;
        this.context = context;
        this.emojiRepository = emojiRepository;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tokens.length;
    }

    @Override
    public Object getItem(int position) {
        return tokens[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null) {
            vi = inflater.inflate(R.layout.sample_token_view, null);
        }

        final Token token = tokens[position];
        TextView text = (TextView) vi.findViewById(R.id.message_view);
        text.setText(token.getSymbol());

        final ImageView image = (ImageView) vi.findViewById(R.id.thumbnail_view);
        if (token.isEmoji(emojiRepository)) {
            image.setImageResource(token.getEmojiImage(emojiRepository));
        } else {
            image.setVisibility(View.INVISIBLE);
        }
        return vi;
    }
}
