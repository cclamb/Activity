package com.sampa.loader;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.sampa.model.Message;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by cclamb on 5/29/15.
 */
public final class MessageLoader extends AsyncTaskLoader<List<Message>> {

    private String CLASS_NAME = getClass().getName();

    public MessageLoader(Context ctx) {
        super(ctx);
        onContentChanged();
    }

    @Override
    public List<Message> loadInBackground() {
        Log.d(CLASS_NAME, "loadInBackground(.)");
        return Arrays.asList(
                new Message(new Date(), "Hey!", "What's up doodbro!?!"),
                new Message(new Date(), "Better B#@ers", "Text me for the good stuff"),
                new Message(new Date(), "Ponies", "Pinky Pie is the best"),
                new Message(new Date(), "Coffee", "Need morez plz")
        );
    }

    @Override
    protected void onStartLoading() {
        if (takeContentChanged()) forceLoad();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }
}
