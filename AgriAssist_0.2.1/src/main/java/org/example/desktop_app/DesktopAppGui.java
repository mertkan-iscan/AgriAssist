package org.example.desktop_app;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.PlotOrientation;
import javax.swing.*;
import java.awt.*;


public class DesktopAppGui {

    private JFrame frame;
    public void initUI() {
        frame = new JFrame("AgriAssist Monitor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1)); // Grid layout for 2 charts

        // Add charts
        frame.add(createChartPanel("Humidity"));
        frame.add(createChartPanel("Temperature"));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private JPanel createChartPanel(String type) {
        XYSeries series = new XYSeries(type);
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Sample data
        series.add(1, Math.random() * 100);
        series.add(2, Math.random() * 100);
        series.add(3, Math.random() * 100);

        JFreeChart chart = ChartFactory.createXYLineChart(
                type + " Data", // Chart title
                "Time", // x-axis Label
                type, // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );

        return new ChartPanel(chart);
    }
}
