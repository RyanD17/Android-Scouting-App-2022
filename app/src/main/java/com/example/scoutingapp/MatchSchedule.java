package com.example.scoutingapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class MatchSchedule extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] blueAlliance;
    private final String[] redAlliance;
    private final Integer[] match;

    public MatchSchedule(Activity context, String[] blueAlliance, String[] redAlliance, Integer[] match){
        super(context, R.layout.match_row, blueAlliance);

        this.context = context;
        this.blueAlliance = blueAlliance;
        this.redAlliance = redAlliance;
        this.match = match;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.match_row, null, true);

        TextView r1 = rowView.findViewById(R.id.r1);
        TextView r2 = rowView.findViewById(R.id.r2);
        TextView r3 = rowView.findViewById(R.id.r3);
        TextView b1 = rowView.findViewById(R.id.b1);
        TextView b2 = rowView.findViewById(R.id.b2);
        TextView b3 = rowView.findViewById(R.id.b3);
        TextView matchNum = rowView.findViewById(R.id.match);

        matchNum.setText(match[position].toString());
        r1.setText(redAlliance[position]);
        r2.setText(redAlliance[position]);
        r3.setText(redAlliance[position]);
        b1.setText(blueAlliance[position]);
        b2.setText(blueAlliance[position]);
        b3.setText(blueAlliance[position]);

        return rowView;
    }
}
