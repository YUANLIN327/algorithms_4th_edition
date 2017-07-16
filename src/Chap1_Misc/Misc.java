package Chap1_Misc;

import java.util.Arrays;

public class Misc {
    static String toBinaryString(int n) {
        String s = "";
        while (n > 0) {
            s = n % 2 + s;
            n /= 2;
        }
        return s;
    }

    static int[][] transpose(int[][] arr) {
        int[][] result = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[j][i];
            }
        }
        return result;
    }

    static int[] histogram(int[] source, int M) {
        int[] sort = Arrays.copyOf(source, source.length);
        Arrays.sort(sort);
        int[] res = new int[M];
        for (int i = 0; i < M && i < sort.length && sort[i] <= M; i++) {
            System.out.println("i: " + i + ". sort[i]: " + sort[i]);
            if (sort[i] >= 0) {
                res[sort[i]]++;
            }
        }
        return res;
    }

    //    this is actually a * b
    static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    //    this is actually a ^ b
    static int mystery1(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery1(a * a, b / 2);
        return mystery1(a * a, b / 2) * a;
    }


    static int euclid(int a, int b) {
        if (b == 0) return a;
        int c = a % b;
        return euclid(b, c);
    }

    static void sortThree(int a, int b, int c) {
        int t;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        System.out.println(a + " , " + b + ", " + c);
    }

    public static void main(String[] args) {
        System.out.println(toBinaryString(64));
        int[][] a = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] b = transpose(a);
        System.out.println(Arrays.toString(b));
        int[] c = {5, 2, 7, 8, 12, 0, 5, 3, 8, 9, 20, 10, 19, 6, 4, 3};
        System.out.println(Arrays.toString(histogram(c, 6)));
        System.out.println(mystery(5, 8));
        System.out.println(mystery1(2, 6));
        System.out.println(euclid(120, 90));
        sortThree(5, 3, 1);
    }
}