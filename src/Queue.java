import java.util.NoSuchElementException;

public class Queue<Item>{
    private Node first;
    private Node last;
    private int N = 0;

    private class Node {
        Item value;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enque(Item item) {
        Node oldLast = last;
        last = new Node();
        last.value = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        Item value = first.value;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return value;
    }

    public static void main(String[] args) {

    }

}
