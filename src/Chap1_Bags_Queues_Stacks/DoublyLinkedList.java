package Chap1_Bags_Queues_Stacks;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Item item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }
    }

    private boolean insertNodeAfter(Node ref, Node insert) {
        if (ref == null) return false;
        Node refNext = ref.next;
        ref.next = insert;
        insert.previous = ref;
        if (refNext == null) {
            last = insert;
        } else {
            insert.next = refNext;
            refNext.previous = insert;
        }
        return true;
    }

    private boolean insertNodeBefore(Node ref, Node insert) {
        if (ref == null) return false;
        Node refPrevious = ref.previous;
        ref.previous = insert;
        insert.next = ref;
        if (refPrevious == null) {
            first = insert;
        } else {
            refPrevious.next = insert;
            insert.previous = refPrevious;
        }
        return true;
    }

    private boolean removeNode(Node remove) {
        if (remove == null) return false;
        Node prev = remove.previous;
        Node next = remove.next;
        if (prev != null && next != null) {
            prev.next = next;
            next.previous = prev;
        } else if (prev != null) {
            prev.next = next;
            last = prev;
        } else {
            next.previous = prev;
            first = next;
        }
        return true;
    }

    public DoublyLinkedList() {
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insertFront(Item item) {
        Node newFirst = new Node(item);
        if (isEmpty()) {
            first = newFirst;
            last = newFirst;
        } else {
            newFirst.next = first;
            first.previous = newFirst;
            first = newFirst;
        }
        N++;
    }

    public void insertEnd(Item item) {
        Node newLast = new Node(item);
        if (isEmpty()) {
            first = newLast;
            last = newLast;
        } else {
            last.next = newLast;
            newLast.previous = last;
            last = newLast;
        }
        N++;
    }

    public boolean insertBefore(Item key, Item item) {
        Node keyNode = first;
        while (keyNode != null && !keyNode.item.equals(item)) {
            keyNode = keyNode.next;
        }
        return keyNode != null && insertNodeBefore(keyNode, new Node(item));
    }

    public boolean insertAfter(Item key, Item item) {
        Node keyNode = first;
        while (keyNode != null && !keyNode.item.equals(item)) {
            keyNode = keyNode.next;
        }
        return keyNode != null && insertNodeAfter(keyNode, new Node(item));
    }

    public Item getFront() {
        return first.item;
    }

    public Item getEnd() {
        return last.item;
    }

    public Item removeFront() {
        if (isEmpty()) throw new NoSuchElementException();
        Item result = first.item;
        first = first.next;
        if (first != null) {
            first.previous = null;
        } else {
            last = null;
        }
        N--;
        return result;
    }

    public Item removeEnd() {
        if (isEmpty()) throw new NoSuchElementException();
        Item result = last.item;
        last = last.previous;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        N--;
        return result;
    }

    public boolean remove(Item item) {
        Node remove = first;
        while (remove != null && !remove.item.equals(item)) {
            remove = remove.next;
        }
        return removeNode(remove);
    }

    @Override
    public Iterator<Item> iterator() {
        return new DoubleLinkedListIterator();
    }

    class DoubleLinkedListIterator implements Iterator<Item> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
