package com.yu.allen.crunchtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Allen on 1/25/2016.
 */
public class EquivalenceListActivity  extends Activity{

    private Context mContext;
    private Activity mActivity;

    private ArrayList<String> exercises;
    private ArrayList<Integer> values;
    private EquivalenceListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_list_view);

        mContext = this;
        mActivity = this;

        exercises = getIntent().getStringArrayListExtra(mContext.getString(R.string.equivalent_list_exercises));
        values = getIntent().getIntegerArrayListExtra(mContext.getString(R.string.equivalent_list_values));

        ListView listView = (ListView) findViewById(R.id.basic_list_view_id);

        mAdapter = new EquivalenceListAdapter(mContext, R.layout.equivalent_list_item, exercises, values);

        mAdapter.notifyDataSetChanged();

        listView.setAdapter(mAdapter);

    }

    private class EquivalenceListAdapter extends ArrayAdapter<String> {

        private String TAG = "BasicListAdapter";

        private Context mContext;
        private Activity mActivity;
        private int resourceId;
        private ArrayList<String> exercises = new ArrayList<>();
        private ArrayList<Integer> values = new ArrayList<>();

        public EquivalenceListAdapter(Context context, int resource, ArrayList<String> data, ArrayList<Integer> values) {
            super(context, resource, data);
            mContext = context;
            resourceId = resource;
            this.exercises = data;
            this.values = values;
        }

        @Override
        public int getCount() {
            return exercises.size();
        }

        @Override
        public String getItem(int position) {
            return exercises.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolder holder = null;

            if (row == null) {
                row = LayoutInflater.from(mContext).inflate(resourceId, parent, false);
                holder = new ViewHolder();
                holder.text = (TextView) row.findViewById(R.id.equivlist_exercise);
                holder.number = (TextView) row.findViewById(R.id.equivlist_number);
                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }

            String exercise = exercises.get(position);
            holder.text.setText(exercise);

            String unit = "";
            if (Constants.TIMED_EXERCISES.contains(exercise)) {
                unit = " mins";
            } else {
                unit = " reps";
            }

            holder.number.setText(String.valueOf(values.get(position)) + unit);
            return row;

        }

        class ViewHolder {
            TextView text;
            TextView number;
        }

    }

}
