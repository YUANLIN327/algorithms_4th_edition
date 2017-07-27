package Chap2_Merge_Sort;

import edu.princeton.cs.algs4.In;

public class MergeBU {

    public static void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        int size = 1;
        while (size < arr.length) {
            for (int i = 0; i < arr.length; i += (size + size)) {
                int lo = i;
                int hi = Math.min(lo + size + size - 1, arr.length - 1);
                if (lo >= hi) continue;
                int mid = lo + size - 1;
                if (mid >= hi) continue;
                if (MergeSort.less(arr[mid], arr[mid + 1])) continue;
                MergeSort.merge(arr, aux, lo, mid, hi);
            }
            size *= 2;
        }
    }

    public static void main(String[] args) {

        String[] arr = new In("resources/32Kints.txt").readAllStrings();
        System.out.println("length: " + arr.length);
        MergeBU.sort(arr);
        System.out.println(MergeSort.isSorted(arr, 0, arr.length - 1));
    }

}
