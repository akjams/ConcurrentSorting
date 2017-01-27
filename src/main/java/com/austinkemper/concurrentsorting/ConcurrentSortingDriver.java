package com.austinkemper.concurrentsorting;

import java.util.ArrayList;
import java.util.List;


public class ConcurrentSortingDriver {
    final static int SIZE = 1000;
    
    public static void main(String[] args) {
        printArrayTimes();
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
