package com.sampa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sampa.activity.R;
import com.sampa.model.Message;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by cclamb on 5/30/15.
 */
public class MessageListAdapter extends ArrayAdapter<Message> {

    public MessageListAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Message msg = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,
                    parent,
                    false
            );
        }

        // Format the date for display.
        String dateString = new SimpleDateFormat("E, MMMM F", Locale.US).format(msg.getWhenCreated());

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.list_item_text_title);
        TextView tvDate = (TextView) convertView.findViewById(R.id.list_item_text_created_at);
        TextView tvMsg = (TextView) convertView.findViewById(R.id.list_item_text_message);

        // Populate the data into the template view using the data object
        tvTitle.setText(msg.getTitle());
        tvDate.setText(dateString);
        tvMsg.setText(msg.getMessage());

        // Return the completed view to render on screen
        return convertView;
    }

}
