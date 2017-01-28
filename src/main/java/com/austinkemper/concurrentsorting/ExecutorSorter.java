package com.austinkemper.concurrentsorting;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**Implementation of Sorter using two threads and the ExecutorService.
 * @author austinkemper
 */
public class ExecutorSorter implements Sorter{
    
    public int[] sort(int[] array) {
        int[] firstHalf = Arrays.copyOfRange(array, 0, array.length/2);
        int[] secondHalf = Arrays.copyOfRange(array, array.length/2, array.length);
        ExecutorService e = Executors.newSingleThreadExecutor();
        e.execute(new SortTask(secondHalf));
        Arrays.sort(firstHalf);
        e.shutdown();
        return Merger.merge(firstHalf, secondHalf);
    }
    
    //Private runnable class to sort half of the array.
    private static class SortTask implements Runnable {
        int[] array;
        SortTask(int[] array) {
            this.array = array;
        }
        public void run() {
            Arrays.sort(array);
        }
    }
    
    @Override
    public String toString() {
        return "ExecutorSorter";
    }
}
