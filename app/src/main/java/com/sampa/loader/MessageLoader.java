package com.sampa.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.sampa.model.Message;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by cclamb on 5/29/15.
 */
public class MessageLoader extends AsyncTaskLoader<List<Message>> {

    public MessageLoader(Context ctx) {
        super(ctx);
    }

    @Override
    public List<Message> loadInBackground() {
        return Arrays.asList(new Message[] {
                new Message(new Date(), "1", "a"),
                new Message(new Date(), "2", "b"),
                new Message(new Date(), "3", "c"),
                new Message(new Date(), "4", "d")
        });
    }
}
