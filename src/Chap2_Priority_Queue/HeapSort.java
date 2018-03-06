package Chap2_Priority_Queue;

public class HeapSort {

    public static void sort(Comparable<Object>[] arr) {
        int N = arr.length - 1;
        for (int i = N / 2; i >= 1; i--) {
            sink(arr, i, N);
        }
        while (N > 0) {
            exch(arr, 0, N--);
            sink(arr, 0, N);
        }
    }

    /**
     * helper funcction
     */
    private static void exch(Comparable<Object>[] arr, int p1, int p2) {
        Comparable<Object> temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    private static void sink(Comparable<Object>[] arr, int k, int N) {
        while ((k + 1) * 2 - 1 <= N) {
            int j = (k + 1) * 2 - 1;
            if ((j + 1 <= N) && less(arr, j, j + 1)) j++;
            if (!less(arr, k, j)) break;
            exch(arr, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable<Object>[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    public static void main(String[] args) {

    }
}
