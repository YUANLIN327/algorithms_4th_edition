import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private int N = 0;
    private Node head;
    private Node tail;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return N;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.item;
    }

    public void push(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        if (N == 0) tail = head;
        else head.next = oldHead;
        N++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Item value = head.item;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        N--;
        return value;
    }

    public void removeAll(Item item) {
        while (head != null && head.item.equals(item))
            head = head.next;
        for (Node current = head; current != null; current = current.next) {
            Node next = current.next;
            while (next != null && next.item.equals(item)) {
                next = next.next;
            }
            current.next = next;
        }
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node i = head;

        public boolean hasNext() {
            return i != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (i == null) throw new NoSuchElementException();
            Item value = i.item;
            i = i.next;
            return value;
        }
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))

                stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        stack.removeAll("item");
        for (String s : stack) {
            System.out.println(s);
        }
        StdOut.println("(" + stack.size() + " left on queue)");
    }

}
