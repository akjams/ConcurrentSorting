package com.austinkemper.concurrentsorting;

/**Helper class with one method to merge two sorted arrays into a sorted array.
 * @author austinkemper
 *
 */
public final class Merger {

    /**Merge two sorted arrays into a larger sorted array.
     * @param first the first array.
     * @param second the second array.
     * @return a merged sorted array.
     */
    public static int[] merge(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];
        int firstIndex = 0, secondIndex = 0, mergedIndex = 0;
        
        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] < second[secondIndex]) {
                merged[mergedIndex] = first[firstIndex];
                firstIndex++;
            } else {
                merged[mergedIndex] = second[secondIndex];
                secondIndex++;
            }
            mergedIndex++;
        }
        while(firstIndex < first.length) {
            merged[mergedIndex] = first[firstIndex];
            firstIndex++;
            mergedIndex++;
        }
        while(secondIndex < second.length) {
            merged[mergedIndex] = second[secondIndex];
            secondIndex++;
            mergedIndex++;
        }
        return merged;
    }
}
