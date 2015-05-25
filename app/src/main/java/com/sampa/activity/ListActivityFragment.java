package com.sampa.activity;

import android.app.ListFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A placeholder fragment containing a simple view.
 */
public final class ListActivityFragment extends ListFragment {

    public ListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        populateList(view);
        return view;
    }

    private void populateList(View view) {
        ListView listView = (ListView) view.findViewById(R.id.listView);

    }
}
