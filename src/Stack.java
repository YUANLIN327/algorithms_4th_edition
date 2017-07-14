import java.util.NoSuchElementException;

public class Stack<Item> {
    private int N = 0;
    private Node head;
    private Node tail;

    private class Node {
        Item value;
        Node next;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return N;
    }


    public void push(Item item) {
        Node oldHead = head;
        head = new Node();
        head.value = item;
        if (N == 0) tail = head;
        else head.next = oldHead;
        N++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Item value = head.value;
        head = head.next;
        if (isEmpty()){
            tail = null;
        }
        N--;
        return value;
    }

//    public Iterator<Item> iterator() {
//        return new ArrayIterator();
//    }
//
//    private class ArrayIterator implements Iterator<Item> {
//        private int i = 0;
//
//        public boolean hasNext() {
//            return i < n;
//        }
//
//        public void remove() {
//            throw new UnsupportedOperationException();
//        }
//
//        public Item next() {
//            if (!hasNext()) throw new NoSuchElementException();
//            Item item = q[(first + i) % q.length];
//            i++;
//            return item;
//        }
//    }


    public static void main(String[] args) {

    }

}
