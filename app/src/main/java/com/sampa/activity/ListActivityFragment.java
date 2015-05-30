package com.sampa.activity;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.sampa.adapter.MessageListAdapter;
import com.sampa.loader.MessageLoader;
import com.sampa.model.Message;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public final class ListActivityFragment
        extends ListFragment
        implements LoaderManager.LoaderCallbacks<List<Message>> {

    private String CLASS_NAME = getClass().getName();

    private MessageListAdapter dataAdapter;
    private static int LOADER_ID = 0x42;

    public ListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataAdapter = new MessageListAdapter(getActivity());
        getLoaderManager().initLoader(LOADER_ID, null, this);
        setListAdapter(dataAdapter);
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public Loader<List<Message>> onCreateLoader(int id, Bundle args) {
        Log.d(CLASS_NAME, "onCreateLoader(.)");
        return (id == LOADER_ID) ? new MessageLoader(getActivity()) : null;
    }

    @Override
    public void onLoadFinished(Loader<List<Message>> loader, List<Message> data) {
        Log.d(CLASS_NAME, "onLoadFinished(.)");
        dataAdapter.addAll(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Message>> loader) {
        Log.d(CLASS_NAME, "onLoaderReset(.)");
        assert false : "unexpected loader reset";
    }
}
