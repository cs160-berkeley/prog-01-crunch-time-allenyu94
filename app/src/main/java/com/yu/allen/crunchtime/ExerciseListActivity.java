package com.yu.allen.crunchtime;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Allen on 1/23/2016.
 */
public class ExerciseListActivity extends Activity {

    private Context mContext;
    private Activity mActivity;

    private final ArrayList<String> exercises = new ArrayList<>(Constants.EXERCISES);
    private BasicListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_list_view);

        mContext = this;
        mActivity = this;

        ListView listView = (ListView) findViewById(R.id.basic_list_view_id);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent calorieDetails = new Intent(mContext, CalorieDetailsActivity.class);
                calorieDetails.putExtra(mContext.getString(R.string.exercise_type), exercises.get(position));
                startActivity(calorieDetails);
            }
        });

        mAdapter = new BasicListAdapter(mContext, R.layout.basic_list_item, exercises);

        mAdapter.notifyDataSetChanged();

        listView.setAdapter(mAdapter);

    }


}
