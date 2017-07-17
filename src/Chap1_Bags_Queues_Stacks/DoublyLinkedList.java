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

    private void insertNodeAfter(Node ref, Node insert) {
        if (ref == null) {
            first = insert;
            last = insert;
        } else {
            Node refNext = ref.next;
            ref.next = insert;
            insert.previous = ref;
            if (refNext == null) {
                last = insert;
            } else {
                insert.next = refNext;
                refNext.previous = insert;
            }
        }
        N++;
    }

    private void insertNodeBefore(Node ref, Node insert) {
        if (ref == null) {
            first = insert;
            last = insert;
        } else {
            Node refPrevious = ref.previous;
            ref.previous = insert;
            insert.next = ref;
            if (refPrevious == null) {
                first = insert;
            } else {
                refPrevious.next = insert;
                insert.previous = refPrevious;
            }
        }
        N++;
    }

    private boolean removeNode(Node remove) {
        if (remove == null) return false;
        Node prev = remove.previous;
        Node next = remove.next;
        if (prev != null && next != null) {
            prev.next = next;
            next.previous = prev;
        } else if (prev != null) {
            prev.next = null;
            last = prev;
        } else if (next != null) {
            next.previous = null;
            first = next;
        } else {
            first = null;
            last = null;
        }
        N--;
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

    public Item getFront() {
        return first.item;
    }

    public Item getEnd() {
        return last.item;
    }

    //    insert method
    public void insertFront(Item item) {
        Node insert = new Node(item);
        insertNodeBefore(first, insert);
    }

    public void insertEnd(Item item) {
        Node insert = new Node(item);
        insertNodeAfter(last, insert);
    }

    public boolean insertBefore(Item key, Item item) {
        Node keyNode = first;
        while (keyNode != null && !keyNode.item.equals(item)) {
            keyNode = keyNode.next;
        }
        if (keyNode == null) return false;
        insertNodeBefore(keyNode, new Node(item));
        return true;
    }

    public boolean insertAfter(Item key, Item item) {
        Node keyNode = first;
        while (keyNode != null && !keyNode.item.equals(item)) {
            keyNode = keyNode.next;
        }
        if (keyNode == null) return false;
        insertNodeAfter(keyNode, new Node(item));
        return true;
    }

    // remove method
    public Item removeFront() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        removeNode(first);
        return item;
    }

    public Item removeEnd() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        removeNode(last);
        return item;
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
        Node iterator = first;

        @Override
        public boolean hasNext() {
            return iterator != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = iterator.item;
            iterator = iterator.next;
            return item;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dllInteger = new DoublyLinkedList();
        dllInteger.insertFront(5);
        dllInteger.insertFront(6);
        System.out.println(dllInteger.getFront());
        System.out.println(dllInteger.getEnd());
        dllInteger.remove(5);
        dllInteger.removeEnd();
        System.out.println("size: " + dllInteger.size());

    }
}
