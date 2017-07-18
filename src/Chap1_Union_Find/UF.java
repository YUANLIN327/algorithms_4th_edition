package Chap1_Union_Find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int componentCount;
    private int[] parent;
    private int[] rank;

    public UF(int count) {
        assert count > 0;
        this.componentCount = count;
        parent = new int[count];
        rank = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int getComponentCount() {
        return componentCount;
    }

    public boolean connected(int i, int j) {
        int parentI = root(i);
        int parentJ = root(j);
        return parentI == parentJ;
    }

    public void union(int i, int j) {
        int parentI = root(i);
        int parentJ = root(j);
        if (parentI == parentJ) return;
        if (rank[parentI] < rank[parentJ]) parent[parentI] = parentJ;
        else if (rank[parentJ] < rank[parentI]) parent[parentJ] = parentI;
        else {
            parent[parentI] = parentJ;
            rank[parentJ]++;
        }
        componentCount--;
    }

    public int root(int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public static void main(String[] args) {
        UF uf = new UF(StdIn.readInt());
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            if (uf.connected(i, j)) continue;
            uf.union(i, j);
            StdOut.println(i + " " + j);
        }
        System.out.println("Component: " + uf.getComponentCount());
    }
}
