package com.austinkemper.concurrentsorting;

import static org.junit.Assert.*;

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
        sorter.sort(array);
        return SortedChecker.isSorted(array);
    }

    @Test
    public void testSimpleSorter() {
        assertTrue(sorterWorks(new SimpleSorter()));
    }

}
