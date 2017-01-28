package com.austinkemper.concurrentsorting;

import java.util.ArrayList;
import java.util.List;


public class ConcurrentSortingDriver {
    final static int SIZE = 1000;
    
    public static void main(String[] args) {
        printArrayTimes();
        chart();
    }
    
    private static void chart() {
        int[] xs = {1, 2, 3, 4, 5};
        int[] ys = {1, 4, 9, 16, 25};
        SortingDataset sd = new SortingDataset("Test", xs, ys);
        List<SortingDataset> sdList= new ArrayList<SortingDataset>();
        sdList.add(sd);
        ChartHelper.go(sdList);
    }
    
    private static void printArrayTimes() {
        int[] array = new int[SIZE]; 
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        
        List<Sorter> sorters= new ArrayList<Sorter>();
        sorters.add(new SimpleSorter());
        sorters.add(new ThreadSorter());
        sorters.add(new ParallelSorter());
        sorters.add(new ExecutorSorter());
        
        for (Sorter s : sorters) {
            System.out.printf("%15s: %10d\n", s.toString(), timeToSort(s, array));
        }
    }
    
    private static long timeToSort(Sorter s, int[] array) {
        long startTime = System.nanoTime();
        s.sort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
