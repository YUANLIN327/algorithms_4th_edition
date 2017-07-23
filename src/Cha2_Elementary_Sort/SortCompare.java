package Cha2_Elementary_Sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.security.InvalidParameterException;

public class SortCompare {

    public static double time(String alg, Comparable[] arr) {
        double time = System.currentTimeMillis();
        switch (alg) {
            case "selection":
                ElementarySort.selectionSort(arr);
                break;
            case "insertion":
                ElementarySort.insertionSort(arr);
                break;
            case "shell":
                ElementarySort.shellSort(arr);
                break;
            default:
                throw new InvalidParameterException("No such name: " + alg);
        }
        return (System.currentTimeMillis() - time) / 1000;
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void doCompare(String alg1, String alg2, int N, int T) {
        double total1 = timeRandomInput(alg1, N, T);
        double total2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles,\n    %s is", N, alg1);
        StdOut.printf("  %.1f times faster than %s\n", total2 / total1, alg2);
    }

    public static void main(String[] args) {
        SortCompare.doCompare("insertion", "selection", 1000, 100);
        SortCompare.doCompare("shell", "selection", 10000, 3);
        SortCompare.doCompare("shell", "insertion", 1000, 10);
    }
}
