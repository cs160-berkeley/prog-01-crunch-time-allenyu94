package com.yu.allen.crunchtime;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Allen on 1/24/2016.
 */
public class CalorieDetailsActivity extends Activity {

    private Context mContext;
    private Activity mActivity;

    private String exercise;
    private boolean isTimedActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_details);

        mContext = this;
        mActivity = this;

        Button convertBtn;
        Button equivalentBtn;

        exercise = getIntent().getStringExtra(mContext.getString(R.string.exercise_type));

        TextView exerciseTitle = (TextView) findViewById(R.id.convert_exercise);
        exerciseTitle.setText(exercise);

        EditText textInput = (EditText) findViewById(R.id.convert_input);

        if (Constants.TIMED_EXERCISES.contains(exercise)) {
            // exercise is type timed
            isTimedActivity = true;
            textInput.setHint("Number of Minutes");
        } else {
            // exercise is type repetitions
            isTimedActivity = false;
            textInput.setHint("Number of Repetitions");
        }

        convertBtn = (Button) findViewById(R.id.convert_btn);
        equivalentBtn = (Button) findViewById(R.id.equivalent_btn);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = (EditText) findViewById(R.id.convert_input);
                if (input.getText().toString().equals("")) {
                    String unit = "";
                    if (isTimedActivity) {
                        unit = "minutes";
                    } else {
                        unit = "repetitions";
                    }

                    String prompt = "Please Enter number of " + unit + " of " + exercise + " you have done.";
                    Toast.makeText(mContext, prompt, Toast.LENGTH_SHORT).show();
                    return;
                }

                double calories = exerciseToCalorieConverter(Integer.valueOf(input.getText().toString()), exercise);
                int burnedCalories = (int) Math.round(calories);

                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

                builder.setMessage("You have burned " + burnedCalories + " Calories!");
                builder.setCancelable(false);
                builder.setPositiveButton("Awesome!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        equivalentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = (EditText) findViewById(R.id.convert_input);
                if (input.getText().toString().equals("")) {
                    String unit = "";
                    if (isTimedActivity) {
                        unit = "minutes";
                    } else {
                        unit = "repetitions";
                    }

                    String prompt = "Please Enter number of " + unit + " of " + exercise + " you have done.";
                    Toast.makeText(mContext, prompt, Toast.LENGTH_SHORT).show();
                    return;
                }

                double calories = exerciseToCalorieConverter(Integer.valueOf(input.getText().toString()), exercise);

                ArrayList<String> exercises = new ArrayList<>();
                ArrayList<Integer> values = new ArrayList<>();
                for (String currExercise : Constants.EXERCISES) {
                    if (!currExercise.equals(exercise)) {
                        double currVal = calories * exerciseToUnit(currExercise);
                        exercises.add(currExercise);
                        values.add((int) Math.round(currVal));
                    }
                }

                Intent equivalenceListActivity = new Intent(mContext, EquivalenceListActivity.class);
                equivalenceListActivity.putExtra(mContext.getString(R.string.equivalent_list_exercises), exercises);
                equivalenceListActivity.putExtra(mContext.getString(R.string.equivalent_list_values), values);
                startActivity(equivalenceListActivity);
            }
        });

    }

    /**
     *
     * @param value: unit in repetitions or minutes
     * @param exerciseInput: exercise name
     * @return calories burned
     */
    public double exerciseToCalorieConverter(int value, String exerciseInput) {
        return value / exerciseToUnit(exerciseInput);
    }

    public double exerciseToUnit(String exercise) {
        switch(exercise) {
            case Constants.PUSH_UP:
                return  Constants.PUSH_UP_UNIT;
            case Constants.SIT_UP:
                return Constants.SIT_UP_UNIT;
            case Constants.SQUAT:
                return Constants.SQUAT_UNIT;
            case Constants.LEG_LIFT:
                return Constants.LEG_LIFT_UNIT;
            case Constants.PLANK:
                return  Constants.PLANK_UNIT;
            case Constants.JUMPING_JACK:
                return Constants.JUMPING_JACK_UNIT;
            case Constants.PULL_UP:
                return  Constants.PULL_UP_UNIT;
            case Constants.CYCLING:
                return Constants.CYCLING_UNIT;
            case Constants.WALKING:
                return Constants.WALKING_UNIT;
            case Constants.JOGGING:
                return Constants.JOGGING_UNIT;
            case Constants.SWIMMING:
                return Constants.SWIMMING_UNIT;
            case Constants.STAIR_CLIMBING:
                return Constants.STAIR_CLIMBING_UNIT;
            default:
                // should not get here.
                return -1;
        }
    }

}
