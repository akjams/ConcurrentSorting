package com.austinkemper.concurrentsorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortCorrectnessTest {
    
    private final int TEST_SIZE = 1000;
    

    
    private int[] getReverseSortedArray() {
        int[] array = new int[TEST_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = TEST_SIZE - i;
        }
        return array;
    }
    
    private boolean sorterWorks(Sorter sorter) {
        int[] array = getReverseSortedArray();
        int[] sortedArray = sorter.sort(array);
        Arrays.sort(array);
        return Arrays.equals(array, sortedArray);
    }

    @Test
    public void testSimpleSorter() {
        assertTrue(sorterWorks(new SimpleSorter()));
    }
    
    @Test
    public void testParallelSorter() {
        assertTrue(sorterWorks(new ParallelSorter()));
    }    
    @Test
    public void testThreadSorter() {
        assertTrue(sorterWorks(new ThreadSorter()));
    }
    
    @Test
    public void testExecutorSorter() {
        assertTrue(sorterWorks(new ExecutorSorter()));
    }
}
