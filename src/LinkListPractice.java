import java.util.LinkedList;

public class LinkListPractice<Item> {
    private class Node {
        Item item;
        Node next;
    }

    static boolean find(Object o, LinkedList ll) {
        Object current = ll.getFirst();
        for (Object item : ll) {
            if (item.equals(o)) return true;
        }
        return false;
    }

    void removeAfter(Node node) {
        if (node != null && node.next != null) {
            node.next = node.next.next;
        }
    }

    void insertAfter(Node first, Node second) {
        if (first != null && second != null) {
            second.next = first.next;
            first.next = second;
        }
    }

    void remove(Object o, Stack stack) {

    }


    public static void main(String[] args) {
    }
}
