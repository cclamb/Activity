package com.sampa.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.sampa.loader.MessageLoader;
import com.sampa.model.Message;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public final class ListActivityFragment
        extends Fragment
        implements LoaderManager.LoaderCallbacks<List<Message>> {

    private ArrayAdapter<Message> dataAdapter;
    private static int LOADER_ID = 0x42;

    public ListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataAdapter = new ArrayAdapter<>(getActivity(), R.layout.list_item);
        getLoaderManager().initLoader(LOADER_ID, null, this);
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public Loader<List<Message>> onCreateLoader(int id, Bundle args) {
        return (id == LOADER_ID) ? new MessageLoader(getActivity()) : null;
    }

    @Override
    public void onLoadFinished(Loader<List<Message>> loader, List<Message> data) {
        dataAdapter.addAll(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Message>> loader) {
        assert false : "unexpected loader reset";
    }
}
