import edu.princeton.cs.algs4.StdIn;

public class FixedCapacityStack<Item> {
    private Item[] stack;
    private int N;

    public FixedCapacityStack(int cap) {
        stack = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        System.out.println("Is Empty: " + (N == 0));
        return N == 0;
    }

    public void push(Item item) {
        stack[N++] = item;
    }

    public Item pop() {
        return stack[--N];
    }

    public String toString() {
        String result = "";
        for (Item s : stack) {
            result += s + ", ";
        }
        return result;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> a = new FixedCapacityStack<>(5);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-"))
                a.push(s);
            else if (!a.isEmpty())
                System.out.println("Poping: " + a.pop());
            System.out.println(a.toString());
        }
        System.out.println("finish");
    }
}
