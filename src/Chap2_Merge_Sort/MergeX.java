package Chap2_Merge_Sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class MergeX {
    private static final int CUT_OFF = 7;

    private static void insertionSort(Comparable[] arr, int lo, int hi) {
        assert lo > 0 && lo < hi;
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && less(arr[j], arr[j - 1]); j--) {
                Comparable temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    private static void show(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }


    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0;
    }

    public static boolean isSorted(Comparable[] arr, int lo, int hi) {
        for (int i = lo; i <= hi - 1; i++) {
            if (!less(arr[i], arr[i + 1])){
                return false;
            }
        }
        return true;
    }

    public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (less(aux[i], aux[j])) arr[k] = aux[i++];
            else {
                arr[k] = aux[j++];
            }
        }
    }

    public static void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        System.arraycopy(arr, 0, aux, 0, arr.length);
        sort(arr, aux, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        if (hi <= lo + CUT_OFF) {
            insertionSort(arr, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, arr, lo, mid);
        sort(aux, arr, mid + 1, hi);
//
//        if (less(aux[mid], aux[mid + 1])) {
//            System.arraycopy(aux, lo, arr, lo, hi - lo + 1);
//            return;
//        }
        merge(arr, aux, lo, mid, hi);
    }


    public static void main(String[] args) {
        String[] arr = new In("resources/32Kints.txt").readAllStrings();
        System.out.println("length: " + arr.length);
        MergeX.sort(arr);
//        MergeX.show(arr);
        System.out.println(MergeX.isSorted(arr, 0, arr.length - 1));
    }
}
