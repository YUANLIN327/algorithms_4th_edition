package Chap1_Union_Find;

public class QuickUnionUF {
    private int[] parents;
    private int count;

    public QuickUnionUF(int count) {
        this.count = count;
        parents = new int[count];
        for (int i = 0; i < count; i++) {
            parents[i] = i;
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
        parents[rootP] = rootQ;
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

}
