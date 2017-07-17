package Chap1_Bags_Queues_Stacks;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizeArrayQueue<Item> implements Iterable<Item> {
    protected int N = 0;
    private int first = 0;
    private int last = 0;
    protected Item[] q;

    public ResizeArrayQueue() {
        q = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    public void resize(int capacity) {
        assert capacity > N && capacity > q.length;
        Item[] tmp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tmp[i] = q[(first + i) % q.length];
        }
        first = 0;
        last = N;
        q = tmp;
    }

    public void enqueue(Item item) {
        if (N == q.length) resize(q.length * 2);
        q[last++] = item;
        if (last == q.length) last = 0;
        N++;
    }

    public Item dequeue() {
        Item tmp = q[first];
        q[first] = null;
        first++;
        N--;
        if (N == q.length / 4) resize(q.length / 2);
        if (N == q.length) first = 0;
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
            return i < N;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(first + i) % q.length];
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
