package Cha2_Elementary_Sort;

public class ElementarySort {
    private static void exchange(Comparable[] arr, int p, int q) {
        if (p == q) return;
        Comparable temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) return false;
        }
        return true;
    }

    public static void selectionSort(Comparable[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (less(arr[j], arr[minIndex])) minIndex = j;
            }
            exchange(arr, i, minIndex);
        }
    }

    public static void insertionSort(Comparable[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                exchange(arr, j, j - 1);
            }
        }
    }

    public static void shellSort(Comparable[] arr) {
        int length = arr.length;
        int k = 1;
        while (k < length / 3) {
            k = 3 * k + 1;
        }
        while (k >= 1) {
            for (int i = k; i < length; i++) {
                for (int j = i; j >= k && less(arr[j], arr[j - k]); j -= k) {
                    exchange(arr, j, j - k);
                }
            }
            k /= 3;
        }
    }

    public static void printAll(Comparable[] arr) {
        for (Comparable item : arr) {
            System.out.println("Current: " + item.toString());
        }
    }

    public static void main(String[] args) {
//        Integer[] insertionTestArr = {5, 7, 0, 11, 13, 19, 30, 32};
//        ElementarySort.shellSort(insertionTestArr);
//        System.out.println("Is insertion sorted after: " + ElementarySort.isSorted(insertionTestArr));
//
//        String[] selectionSortArr = new In("resources/word3.txt").readAllStrings();
//        ElementarySort.shellSort(selectionSortArr);
//        System.out.println("Is selection sorted after: " + ElementarySort.isSorted(selectionSortArr));
//
//        String[] shellSortArr = new In("resources/word3.txt").readAllStrings();
//        ElementarySort.shellSort(shellSortArr);
//        System.out.println("Is shell sorted after: " + ElementarySort.isSorted(shellSortArr));
    }
}
