package Chap1_Bags_Queues_Stacks;

import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> extends ResizeArrayQueue {

    private void switchItem(int pos1, int pos2) {
        Item temp = (Item) q[pos1];
        q[pos1] = q[pos2];
        q[pos2] = temp;
    }

    public Item sample() {
        int randomPos = StdRandom.uniform(N - 1);
        return (Item) q[randomPos];
    }

    @Override
    public Item dequeue() {
        int randomPos = StdRandom.uniform(N - 1);
        switchItem(randomPos, N - 1);
        return (Item) super.dequeue();
    }


    public static void main(String[] args) {
        RandomQueue<Integer> rq = new RandomQueue<>();
        for (int i = 0; i < 10; i++) {
            rq.enqueue(i);
        }
        System.out.println(rq.sample());
        System.out.println(rq.sample());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
    }
}
