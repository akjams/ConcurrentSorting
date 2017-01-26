package com.austinkemper.concurrentsorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergerTest {
    
    private final int[] sortedArray1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final int[] sortedArray2 = {-1000012, -9987, -3, 0, 8, 12, 283984};
    private final int[] sortedArray3 = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
    private final int[] sortedArray4 = {-1};
    private final int[] sortedArray5 = {};


    @Test
    public void testMerger() {
        assertTrue(SortedChecker.isSorted(Merger.merge(sortedArray1, sortedArray2)));
        assertTrue(SortedChecker.isSorted(Merger.merge(sortedArray1, sortedArray3)));
        assertTrue(SortedChecker.isSorted(Merger.merge(sortedArray1, sortedArray4)));
        assertTrue(SortedChecker.isSorted(Merger.merge(sortedArray1, sortedArray5)));        assertTrue(SortedChecker.isSorted(Merger.merge(sortedArray1, sortedArray2)));
        assertTrue(SortedChecker.isSorted(Merger.merge(sortedArray2, sortedArray3)));
        assertTrue(SortedChecker.isSorted(Merger.merge(sortedArray2, sortedArray4)));
        assertTrue(SortedChecker.isSorted(Merger.merge(sortedArray2, sortedArray5)));
    }

}
