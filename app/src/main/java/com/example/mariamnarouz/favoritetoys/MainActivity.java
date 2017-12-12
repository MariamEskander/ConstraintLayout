package com.example.mariamnarouz.favoritetoys;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.chart)
    PieChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mChart.setUsePercentValues(false);


        mChart.setExtraOffsets(-35,0,-10,-10);

        mChart.setDragDecelerationFrictionCoef(0.95f);

        mChart.setDescription(null);

        mChart.setDrawHoleEnabled(false);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(false);


        setData(3, 100);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);


    }


    private void setData(int count, float range) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();


        entries.add(new PieEntry((float) 12.5));
        entries.add(new PieEntry((float) 62.5));
        entries.add(new PieEntry((float) 25));


        PieDataSet dataSet = new PieDataSet(entries, "");

        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(ContextCompat.getColor(this,R.color.paris_green));
        colors.add(ContextCompat.getColor(this,R.color.dark_tangerine));
        colors.add(ContextCompat.getColor(this,R.color.cardinal));
        dataSet.setColors(colors);
        dataSet.setSliceSpace(10);



        PieData data = new PieData(dataSet);
        mChart.setData(data);
        data.setDrawValues(false);
        mChart.setDrawEntryLabels(false);



        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }


}
