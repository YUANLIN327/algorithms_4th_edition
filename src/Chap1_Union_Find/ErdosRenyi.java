package Chap1_Union_Find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {
    public ErdosRenyi(int count) {
    }

    public static int start(int count) {
        assert count > 1;
        int trial = 0;
        UF uf = new UF(count);
        while (uf.getComponentCount() > 1) {
            int p = StdRandom.uniform(count);
            int q = StdRandom.uniform(count);
            uf.union(p, q);
            trial++;
        }
        return trial;
    }

    public static void main(String[] args) {
        System.out.println("Please enter N: ");
        int N = StdIn.readInt();
        int result = ErdosRenyi.start(N);
        System.out.println("It takes " + result + " times to connect all " + N + " components.");
    }
}
