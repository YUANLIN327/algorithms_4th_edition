import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N = 0;

    private class Node {
        Item item;
        Node next;
        public Node(Item i)      { this.item = i; }
        public String toString() { return hashCode() + ":" + item; }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node(item);
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        Item value = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return value;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Node i = first;

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

    }

}
