package ketan.example.com.projectangel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;

import java.util.ArrayList;
import java.util.List;


public class TabFragment4 extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.graph_view_layout, container, false);

        AnyChartView anyChartView = view.findViewById(R.id.any_chart_view);
        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("0:02", 3920.21));
        data.add(new ValueDataEntry("0:05", 4900.20));
        data.add(new ValueDataEntry("0:07", 5000));
        data.add(new ValueDataEntry("0:08", 4900.20));
        data.add(new ValueDataEntry("0:10", 5000));
        data.add(new ValueDataEntry("0:18", 4000));
        data.add(new ValueDataEntry("0:22", 3920.21));
        data.add(new ValueDataEntry("0:27", 4900.20));
        data.add(new ValueDataEntry("0:34", 5000));
        data.add(new ValueDataEntry("0:37", 4000));
        data.add(new ValueDataEntry("0:40", 3920.21));
        data.add(new ValueDataEntry("0:43", 4900.20));
        data.add(new ValueDataEntry("0:50", 5000));
        data.add(new ValueDataEntry("0:52", 4900.20));
        data.add(new ValueDataEntry("0:54", 5000));
        data.add(new ValueDataEntry("0:58", 4000));
        data.add(new ValueDataEntry("0:60", 3920.21));
        data.add(new ValueDataEntry("0:63", 4900.20));
        data.add(new ValueDataEntry("0:62", 5000));
        data.add(new ValueDataEntry("0:65", 4000));
        data.add(new ValueDataEntry("0:70", 3920.21));
        data.add(new ValueDataEntry("0:75", 4900.20));
        data.add(new ValueDataEntry("0:79", 5000));
        data.add(new ValueDataEntry("0:82", 4900.20));
        data.add(new ValueDataEntry("0:85", 5000));
        data.add(new ValueDataEntry("0:95", 4000));
        data.add(new ValueDataEntry("0:99", 3920.21));
        data.add(new ValueDataEntry("1:02", 4900.20));
        data.add(new ValueDataEntry("1:10", 5000));
        data.add(new ValueDataEntry("1:05", 4000));

        Column column = cartesian.column(data);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .format("{%Value}{groupsSeparator: }");

        cartesian.animation(true);

        cartesian.yScale().minimum(0d);
        cartesian.background(false);
        cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");
        cartesian.maxPointWidth(2);
        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);
        anyChartView.setBackgroundColor("#05020f");
        anyChartView.setChart(cartesian);
        return view;
    }
}
