package com.austinkemper.concurrentsorting;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartHelper extends JFrame {
    private static final long serialVersionUID = 1L;
    
    final String chartTitle = "Concurrent Sorting Results";
    final String xAxisLabel = "Number of Elements";
    final String yAxisLabel = "Sorting Time (ns)";
    final String chartDestination = "images/ConcurrentSortingChart.png";
    final List<SortingDataset> datasets;
    JFreeChart jFreeChart;
    
    public ChartHelper(List<SortingDataset> datasets) {
        super("Concurrent Sorting Results");
        this.datasets = datasets;
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    private JPanel createChartPanel() {
        XYDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset);
        styleChart(chart);
        this.jFreeChart = chart;
        return new ChartPanel(chart);
    }
    
    private void styleChart(JFreeChart chart) {
        //Make x axis logarithmic scale
        chart.getXYPlot().setDomainAxis(new LogarithmicAxis(xAxisLabel));
        chart.getXYPlot().setRangeAxis(new LogarithmicAxis(yAxisLabel));
        XYItemRenderer renderer = chart.getXYPlot().getRenderer();
        for (int i = 0; i < datasets.size(); i++) {
            renderer.setSeriesStroke(i, new BasicStroke(4));
        }
    }
 
    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (SortingDataset sortingDS : this.datasets) {
            dataset.addSeries(sortingDS.getSeries());
        }
        return dataset;
    }
 
    public static void go(List<SortingDataset> datasets) {
        ChartHelper ch = new ChartHelper(datasets);
        //ch.setVisible(true);
        ch.saveChart();
    }
    
    private void saveChart() {
        File imageFile = new File(chartDestination);
        int width = 640;
        int height = 480;
        try {
            ChartUtilities.saveChartAsPNG(imageFile, this.jFreeChart, width, height);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
