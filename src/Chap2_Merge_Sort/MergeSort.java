package Chap2_Merge_Sort;

import edu.princeton.cs.algs4.In;

public class MergeSort {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0;
    }

    public static boolean isSorted(Comparable[] arr, int lo, int hi) {
        for (int i = lo; i < hi - 1; i++) {
            if (!less(arr[i], arr[i + 1])) return false;
        }
        return true;
    }

    public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(arr, lo, mid);
        assert isSorted(arr, mid, hi);
        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }
        int m = lo, n = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (m > mid) arr[k] = aux[n++];
            else if (n > hi) arr[k] = aux[m++];
            else if (less(aux[m], aux[n])) arr[k] = aux[m++];
            else arr[k] = aux[n++];
        }
        assert isSorted(arr, lo, hi);
    }

    public static void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }


    public static void main(String[] args) {
        String[] arr = new In("resources/32Kints.txt").readAllStrings();
        System.out.println("length: " + arr.length);
        MergeSort.sort(arr);
        System.out.println(MergeSort.isSorted(arr, 0, arr.length));
    }
}
