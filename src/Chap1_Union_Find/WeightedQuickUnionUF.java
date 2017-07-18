package Chap1_Union_Find;

public class WeightedQuickUnionUF {
    private int[] parents;
    private int[] size;
    private int count;

    public WeightedQuickUnionUF(int count) {
        this.count = count;
        parents = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    private void validate(int p) {
        int length = parents.length;
        if (p < 0 || p > length - 1)
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (length - 1));
    }

    public int getCount() {
        return count;
    }

    public int find(int p) {
        validate(p);
        while (parents[p] != p) p = parents[p];
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (size[rootP] < size[rootQ]) {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parents[rootQ] = rootQ;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
