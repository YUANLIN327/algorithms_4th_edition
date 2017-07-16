package Chap1_Bags_Queues_Stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueue<Item> implements Iterable<Item> {
    private Node last;

    private class Node {
        Item item;
        Node next;

        public Node(Item i) {
            this.item = i;
        }

        public String toString() {
            return hashCode() + ":" + item;
        }
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void enqueue(Item item) {
        if (last == null) {
            last = new Node(item);
            last.next = last;
        } else {
            Node oldLast = last;
            Node first = last.next;
            last = new Node(item);
            last.next = first;
            oldLast.next = last;
        }
    }

    public Item dequeue() {
        if (last == null) throw new NoSuchElementException();
        Item item = last.next.item;
        if (last.next == last) last = null;
        else last.next = last.next.next;
        return item;
    }

    public Item getFirst() {
        if (last == null) throw new NoSuchElementException();
        return last.next.item;
    }

    public Item getLast() {
        if (last == null) throw new NoSuchElementException();
        return last.item;
    }

    public Iterator<Item> iterator() {
        return new CircularQueueIterator();
    }

    private class CircularQueueIterator implements Iterator<Item> {
        private Node i = last.next;
        private boolean hasVisitedFirst = false;

        @Override
        public boolean hasNext() {
            return i != null &&
                    !(hasVisitedFirst && i == last.next);
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = i.item;
            i = i.next;
            hasVisitedFirst = true;
            return item;
        }
    }

    public static void main(String[] args) {
        CircularQueue<String> cq = new CircularQueue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                cq.enqueue(item);
            else if (!cq.isEmpty()) StdOut.print(cq.dequeue() + " ");
        }
        for (String s : cq) {
            System.out.println(s);
        }
        System.out.println("first: " + cq.getFirst());
        System.out.println("last: " + cq.getLast());
    }

}
