package com.austinkemper.concurrentsorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortCorrectnessTest {
    
    private final int TEST_SIZE = 1000;
    
    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
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
        return isSorted(array);
    }

    @Test
    public void testSimpleSorter() {
        assertTrue(sorterWorks(new SimpleSorter()));
    }

}
