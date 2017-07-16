import java.util.LinkedList;

public class LinkListPractice<Item> {
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

    Node reverse(Node node) {
        Node reverse = null;
        Node first = node;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    Node reverseRecrusively(Node first) {
        if (first == null) return null;
        if (first.next == null) return first;
        Node nextNode = first.next;
        first.next = null;
        Node rest = reverseRecrusively(nextNode);
        rest.next = first;
        return rest;
    }

    public static void main(String[] args) {
        LinkListPractice lp = new LinkListPractice();
    }
}
