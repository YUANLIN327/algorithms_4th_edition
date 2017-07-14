import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizeArrayQueue<Item> implements Iterable<Item> {
    private int n = 0;
    private int first = 0;
    private int last = 0;
    private Item[] q;

    public ResizeArrayQueue() {
        q = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }


    public void resize(int capacity) {
        assert capacity > n && capacity > q.length;
        Item[] tmp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tmp[i] = q[(first + i) % q.length];
        }
        first = 0;
        last = n;
        q = tmp;
    }

    public void enqueue(Item item) {
        if (n == q.length) resize(q.length * 2);
        q[last++] = item;
        if (last == q.length) last = 0;
        n++;
    }

    public Item dequeue() {
        Item tmp = q[first];
        q[first] = null;
        first++;
        n--;
        if (n == q.length / 4) resize(q.length / 2);
        if (n == q.length) first = 0;
        return tmp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : q) {
            String s = item + ", ";
            sb.append(s);
        }
        return sb.toString();
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(first + i) & q.length];
            i++;
            return item;
        }
    }


    public static void main(String[] args) {

        ResizeArrayQueue<String> q = new ResizeArrayQueue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-")) q.enqueue(s);
            else if (!q.isEmpty()) System.out.println("Deque: " + q.dequeue());
        }
        System.out.println("Final queue: " + q.toString());
    }


}
