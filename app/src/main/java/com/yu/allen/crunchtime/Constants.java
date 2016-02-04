package com.yu.allen.crunchtime;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Allen on 1/24/2016.
 */
public class Constants {

    public static final String PUSH_UP = "Push Up";
    public static final String SIT_UP = "Sit Up";
    public static final String SQUAT = "Squats";
    public static final String LEG_LIFT = "Leg-lift";
    public static final String PLANK = "Plank";
    public static final String JUMPING_JACK = "Jumping Jacks";
    public static final String PULL_UP = "Pull Up";
    public static final String CYCLING = "Cycling";
    public static final String WALKING = "Walking";
    public static final String JOGGING = "Jogging";
    public static final String SWIMMING = "Swimming";
    public static final String STAIR_CLIMBING = "Stair Climbing";

    // Exercise unit per Calorie
    // repetitions is repetition/calorie
    // time is minute/calorie
    public static final double PUSH_UP_UNIT = 3.5;
    public static final double SIT_UP_UNIT = 2.0;
    public static final double SQUAT_UNIT = 2.25;
    public static final double LEG_LIFT_UNIT = 0.25;
    public static final double PLANK_UNIT = 0.25;
    public static final double JUMPING_JACK_UNIT = 0.10;
    public static final double PULL_UP_UNIT = 1;
    public static final double CYCLING_UNIT = 0.12;
    public static final double WALKING_UNIT = 0.20;
    public static final double JOGGING_UNIT = 0.12;
    public static final double SWIMMING_UNIT = 0.13;
    public static final double STAIR_CLIMBING_UNIT = 0.15;


    public static final List<String> EXERCISES = Arrays.asList(
            PUSH_UP, SIT_UP, SQUAT, LEG_LIFT, PLANK, JUMPING_JACK, PULL_UP, CYCLING,
            WALKING, JOGGING, SWIMMING, STAIR_CLIMBING );

    public static final String[] TIMED_VALUES = new String[] {LEG_LIFT, PLANK, JUMPING_JACK, CYCLING, WALKING, JOGGING, SWIMMING, STAIR_CLIMBING};
    public static final Set<String> TIMED_EXERCISES = new HashSet<>(Arrays.asList(TIMED_VALUES));

    public static final String[] REP_VALUES = new String[] {PUSH_UP, SIT_UP, SQUAT, PULL_UP};
    public static final Set<String> REP_EXERCISES = new HashSet<>(Arrays.asList(REP_VALUES));

}
