package Chap1_Union_Find;

public class QuickUnionPathCompressionUF {
    private int[] parents;
    private int count;

    public QuickUnionPathCompressionUF(int count) {
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
        int o = p;
        while (parents[p] != p) p = parents[p];
        while (parents[o] != o) {
            int next = parents[o];
            parents[o] = p;
            o = next;
        }
        return p;
    }

    public int findWithRecursion(int p) {
        validate(p);
        if (p == parents[p]) return p;
        int root = findWithRecursion(parents[p]);
        parents[p] = root;
        return root;
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
