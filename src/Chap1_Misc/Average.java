package Chap1_Misc;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Average {
    public static void main(String[] args) { // Average the numbers on StdIn.
        double sum = 0.0;
        int cnt = 0;
        In readStream = new In("resources/1kints.txt");
        while (!readStream.isEmpty()) { // Read a number and cumulate the sum.
            sum += readStream.readInt();
            cnt++;
        }
        double avg = sum / cnt;
        StdOut.printf("Average is %.5f\n", avg);
    }
}