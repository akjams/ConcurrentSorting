package com.austinkemper.concurrentsorting;

import org.jfree.data.xy.XYSeries;

public class SortingDataset {
    private XYSeries series;
    
    public SortingDataset(String name, int[] xvalues, int[] yvalues) {
        if (xvalues.length != yvalues.length) {
            throw new IllegalArgumentException("X and Y series must be of same length");
        }
        series = new XYSeries(name, false);
        for (int i = 0; i < xvalues.length; i++) {
            series.add(xvalues[i], yvalues[i]);
        }
    }
    public XYSeries getSeries() {
        return series;
    }
}
