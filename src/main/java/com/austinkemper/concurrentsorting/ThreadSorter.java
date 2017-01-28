package com.austinkemper.concurrentsorting;

import java.util.Arrays;

/**Implementation of Sorter using two threads and the Thread class.
 * @author austinkemper
 */
public class ThreadSorter implements Sorter {

    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        final int[] firstHalf = Arrays.copyOfRange(array, 0, array.length/2);
        final int[] secondHalf = Arrays.copyOfRange(array, array.length/2, array.length);
        
        Thread background = new Thread(new Runnable() {
            public void run() {
                Arrays.sort(secondHalf);
            }
        });
        background.start();

        Arrays.sort(firstHalf);
        try {
            background.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[] sorted = Merger.merge(firstHalf, secondHalf);
        return sorted;
    }
    
    @Override
    public String toString() {
        return "ThreadSorter";
    }

}
