package com.Neuralsift.Sesvo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Neuralsift.Sesvo.R;
import com.github.mikephil.charting.charts.LineChart;

import static com.Neuralsift.Sesvo.Activities.SellerHomeScreen.screenTitle;


public class SellerDashboardFragment extends Fragment {

    LineChart lchart;
    int s=0;

    public SellerDashboardFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_seller_dashboard, container, false);

        screenTitle.setText("DashBoard");
        //lineChart();
        return v;
    }

   /* public void lineChart(){



        *//*LinearLayout ll = view.findViewById(R.id.linear1);*//*

        lchart = new LineChart(getActivity());
        lchart.setId(s+1);
        LinearLayout.LayoutParams chartParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 800);
        chartParams.setMargins(5,5,5,30);
        lchart.setLayoutParams(chartParams);
        s++;
        //ll.addView(lchart);

        JSONObject obj1 = null;

        //mnth.add(A.getXaxis().toString());


        *//*for(int i = 0; i<A.getYaxis().size(); i++)
        {
            mnth.add(A.getXaxis().get(i));
            linelist.add(new Entry(i,Integer.parseInt(A.getYaxis().get(i))));
            Log.d("values",A.getYaxis().get(i) );
        }*//*



        //Log.d("values",A.getXlable() );

        LineDataSet lineDataSet = new LineDataSet(linelist, A.getXlable());
        lineDataSet.setColor(Color.CYAN);
        lineDataSet.setLineWidth(3f);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillColor(Color.CYAN);
        LineData lineData = new LineData(lineDataSet);
        lchart.setData(lineData);
        XAxis xAxisline = lchart.getXAxis();
        Description description = new Description();
        description.setText(A.getTitle());
        lchart.setDescription(description);
        xAxisline.setValueFormatter(new IndexAxisValueFormatter(mnth));
        // xAxisline.setTextColor(Color.CYAN);
        xAxisline.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxisline.setDrawGridLines(true);
        xAxisline.setDrawAxisLine(false);
        xAxisline.setGranularity(1f);
        xAxisline.setLabelCount(label_names.size());
        YAxis yAxis = lchart.getAxisRight();
        yAxis.setEnabled(false);
        lchart.canScrollHorizontally(2);
        lchart.setGridBackgroundColor(Color.rgb(232,244,248));
        lchart.setDrawGridBackground(true);
        lchart.setDragEnabled(true);
        lchart.setScaleYEnabled(false);
        lchart.setScaleEnabled(true);

        lchart.canScrollVertically(2);
        lchart.setBackgroundColor(Color.WHITE);
        Legend l = lchart.getLegend();
        l.setTextColor(Color.LTGRAY);
        lchart.animateY(1000);
        lchart.invalidate();


    }*/

}