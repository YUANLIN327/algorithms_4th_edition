package Chap1_Bags_Queues_Stacks;

import edu.princeton.cs.algs4.StdIn;

import java.util.NoSuchElementException;

public class Josephus extends CircularQueue<Integer> {
    private final int CYCLE;

    private int removeNodeAfter(Node node) {
        Node nextNode = node.next;
        if (size() == 1) last = null;
        else {
            node.next = nextNode.next;
            if (nextNode == last) {
                last = node;
            }
        }
        N--;
        nextNode.next = null;
        return nextNode.item;
    }

    public Josephus(int count, int cycle) {
        CYCLE = cycle;
        for (int i = 0; i < count; i++) {
            this.enqueue(i);
        }
    }

    public void start() {
        if (isEmpty()) throw new NoSuchElementException();
        Node iterator = last;
        while (!isEmpty()) {
            for (int i = 0; i < CYCLE - 1; i++) {
                iterator = iterator.next;
            }
            System.out.println(removeNodeAfter(iterator));
        }

    }


    public static void main(String[] args) {
        System.out.println("Please enter the number of people will be: ");
        int count = StdIn.readInt();
        System.out.println("Please enter the iteration cycle: ");
        int cycle = StdIn.readInt();
        Josephus collection = new Josephus(count, cycle);
        collection.start();
    }
}
