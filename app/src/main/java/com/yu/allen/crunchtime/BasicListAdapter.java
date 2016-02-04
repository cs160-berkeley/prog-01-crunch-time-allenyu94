package com.yu.allen.crunchtime;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Allen on 1/24/2016.
 */
public class BasicListAdapter extends ArrayAdapter<String> {

    private String TAG = "BasicListAdapter";

    private Context mContext;
    private Activity mActivity;
    private int resourceId;
    private ArrayList<String> data = new ArrayList<>();

    public BasicListAdapter(Context context, int resource, ArrayList<String> data) {
        super(context, resource, data);
        mContext = context;
        resourceId = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            row = LayoutInflater.from(mContext).inflate(resourceId, parent, false);
            holder = new ViewHolder();
            holder.text = (TextView) row.findViewById(R.id.basic_list_item_text);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        holder.text.setText(data.get(position));
        return row;

    }

    static class ViewHolder {
        TextView text;
    }

}


