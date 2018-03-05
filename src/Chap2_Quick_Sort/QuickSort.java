package Chap2_Quick_Sort;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    public static void main(String[] args) {

    }

    public static void sort(Comparable[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        Comparable v = arr[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (v.compareTo(arr[++i]) > 0) if (i == hi) break;
            while (v.compareTo(arr[--j]) < 0) if (j == lo) break;
            if (i >= j) break;
            exchange(arr, i, j);
        }
        exchange(arr, lo, j);
        return j;
    }

    private static void exchange(Comparable[] array, int pos1, int pos2) {
        Comparable temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
