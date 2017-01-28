# ConcurrentSorting
Test the performance of concurrent sorting using various strategies.

##Results
All results are from my machine. See specs below.

[<img src="images/ConcurrentSortingChart.png">]

### Notes on Sorting Strategies
* SimpleSorter: plain old Arrays.sort
* Parallel Sorter: Arrays.parallelSort
* ThreadSorter: Arrays.sort with two threads using java.lang.Thread
* ExecutorSorter: Arrays.sort with two threads using  java.util.concurrent.ExecutorService

##Specs
I am running a MacBook Air with a 1.4 GHz Intel Core i5 processor (2 cores), 8GB ram.

## Dependencies
* JUnit 4.12
* JFreeChart 1.0.19

## Authors
* Austin Kemper
