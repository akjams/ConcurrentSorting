package com.austinkemper.concurrentsorting;
import java.util.ArrayList;
import java.util.List;


/**Class with main method, 
 * Calls methods to instantiates sorters, tests performance, and generate chart.
 * @author austinkemper
 */
public class ConcurrentSortingDriver {
    private final static int SIZE = 1000;
    
    //large xvalue range
    private final static int[] xvalues = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    
    //small xvalue range for testing
    //private final static int[] xvalues = {10, 100, 1000, 10000, 100000};
    
    private static List<Sorter> sorters;
    
    /**Main method. Generate chart and text output.
     * @param args
     */
    public static void main(String[] args) {
        createSorters();
        printArrayTimes(SIZE);
        chartArrayTimes();
    }
    
    //Generate list of sorters.
    //To test new sorters, add them here!
    private static void createSorters() {
        sorters = new ArrayList<Sorter>();
        sorters.add(new SimpleSorter());
        sorters.add(new ThreadSorter());
        sorters.add(new ParallelSorter());
        sorters.add(new ExecutorSorter());
    }
    
    private static void chartArrayTimes() {
        List<SortingDataset> sdList= new ArrayList<SortingDataset>();
        for (Sorter s : sorters) {
            sdList.add(getSortingDataset(s));
        }
        ChartHelper.go(sdList);
    }
    
    //Test performance on sorter and create a data set
    //using the SortingDataset helper class
    private static SortingDataset getSortingDataset(Sorter sorter) {
        String name = sorter.toString();
        int[] yvalues = new int[xvalues.length];
        for (int i = 0; i < xvalues.length; i++){
            int[] reverseArray = getReverseArray(xvalues[i]);
            yvalues[i] = (int) timeToSort(sorter, reverseArray); //Cast to int
        }
        return new SortingDataset(name, xvalues, yvalues);
    }
    
    //Generate an array that is reverse sorted of size size
    private static int[] getReverseArray(int size) {
        int[] array = new int[size]; 
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        return array;
    }
    
    //Test performance on all sorters on reverse arrays of size size
    //output to stdout
    private static void printArrayTimes(int size) {
        int[] array = getReverseArray(size);
        for (Sorter s : sorters) {
            System.out.printf("%15s: %10d\n", s.toString(), timeToSort(s, array));
        }
    }
    
    //Find the time it takes s to sort array
    private static long timeToSort(Sorter s, int[] array) {
        long startTime = System.nanoTime();
        s.sort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
