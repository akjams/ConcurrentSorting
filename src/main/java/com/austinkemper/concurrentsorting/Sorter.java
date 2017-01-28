package com.austinkemper.concurrentsorting;

/**An interface that represents a class that can sort something.
 * @author austinkemper
 */
public interface Sorter {
    /**Returns a sorted array. Does not change the array parameter.
     * @param array the unsorted array
     * @return the sorted array
     */
    public int[] sort(int[] array);
}
