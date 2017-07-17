package Chap1_Bags_Queues_Stacks;

//
//public class Josephus extends CircularQueue<Integer> {
//    private final int CYCLE;
//
//    private int removeNodeAfter(Node node) {
//        Node nextNode = node.next;
//        if (node == nextNode) last = null;
//        else {
//            node.next = nextNode.next;
//            if (nextNode == last) {
//                last = node;
//            }
//        }
//        return nextNode.item;
//    }
//
//    public Josephus(int count, int cycle) {
//        CYCLE = cycle;
//        for (int i = 0; i < count; i++) {
//            this.enqueue(i);
//        }
//    }
//
//    public void start() {
//        if (isEmpty()) throw new NoSuchElementException();
//        Node iterator = last;
//        while (!isEmpty()) {
//            for (int i = 0; i < CYCLE - 1; i++) {
//                iterator = iterator.next;
//            }
//            System.out.println(removeNodeAfter(iterator));
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println("Please enter the number of people will be: ");
//        int count = StdIn.readInt();
//        System.out.println("Please enter the iteration cycle: ");
//        int cycle = StdIn.readInt();
//        Josephus collection = new Josephus(count, cycle);
//        collection.start();
//    }
//}

import edu.princeton.cs.algs4.StdIn;

public class Josephus extends CircularQueue<Integer> {
    private final int COUNT;
    private final int CYCLE;

    public Josephus(int count, int cycle) {
        COUNT = count;
        CYCLE = cycle;
    }

    public void start() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < COUNT; i++) {
            queue.enqueue(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < CYCLE - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.println(queue.dequeue());
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
