package com.austinkemper.concurrentsorting;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartHelper extends JFrame {
    List<SortingDataset> datasets;
    
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
        String chartTitle = "Concurrent Sorting Results";
        String xAxisLabel = "Number of Elements";
        String yAxisLabel = "Sorting Time (ns)";
     
        XYDataset dataset = createDataset();
     
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset);
     
        return new ChartPanel(chart);
    }
 
    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (SortingDataset sortingDS : this.datasets) {
            dataset.addSeries(sortingDS.getSeries());
        }
        return dataset;
    }
 
    public static void go(List<SortingDataset> datasets) {
        new ChartHelper(datasets).setVisible(true);
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new ChartHelper(datasets).setVisible(true);
//            }
//        });
    }
}
