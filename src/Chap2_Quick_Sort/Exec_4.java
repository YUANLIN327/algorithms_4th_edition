package Chap2_Quick_Sort;

public class Exec_4 {

    public static void main(String[] args) {
        Comparable[] arr = new Comparable[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (Math.random() < 0.5 ? 1 : 2);
        }
        System.out.println("before");
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("after");
        sortArrWithTwoDistinctVal(arr);
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sortArrWithTwoDistinctVal(Comparable[] arr) {
        int i = 0;
        int lastOne = arr.length - 1;
        Comparable pivot = arr[0];
        while (pivot.compareTo(arr[++i]) == 0) {
            if (i == lastOne) break;
        }
        pivot = pivot.compareTo(arr[i]) < 0 ? pivot : arr[i];
        int hi = arr.length;
        int lo = -1;
        while (true) {
            while (pivot.compareTo(arr[++lo]) >= 0) {
                if (lo >= hi) break;
            }
            while (pivot.compareTo(arr[--hi]) < 0) if (hi <= lo) break;
            if (lo >= hi) break;
            exchange(arr, lo, hi);
        }
    }

    private static void exchange(Comparable[] array, int pos1, int pos2) {
        Comparable temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

}
