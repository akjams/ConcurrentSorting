package com.austinkemper.concurrentsorting;

import org.jfree.data.xy.XYSeries;

/**Helper class represents a dataset of sorting performance.
 * @author austinkemper
 */
public class SortingDataset {
    private XYSeries series;
    
    /**Construct a SortingDataset.
     * @param name the name of the data set (shows up in chart legend)
     * @param xvalues values for the x axis
     * @param yvalues values for the y axis
     */
    public SortingDataset(String name, int[] xvalues, int[] yvalues) {
        if (xvalues.length != yvalues.length) {
            throw new IllegalArgumentException("X and Y series must be of same length");
        }
        series = new XYSeries(name, false);
        for (int i = 0; i < xvalues.length; i++) {
            series.add(xvalues[i], yvalues[i]);
        }
    }

    /**
     * @return the XYSeries representation of sorting performance.
     */
    public XYSeries getSeries() {
        return series;
    }
}
