package com.sampa.activity;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sampa.loader.MessageLoader;
import com.sampa.model.Message;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class ListActivityFragment
        extends Fragment
        implements LoaderManager.LoaderCallbacks<List<Message>> {

    public ListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public Loader<List<Message>> onCreateLoader(int id, Bundle args) {
        return new MessageLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Message>> loader, List<Message> data) {

    }

    @Override
    public void onLoaderReset(Loader<List<Message>> loader) {

    }
}
