import edu.princeton.cs.algs4.StdIn;

public class CopyStack {

    public static Stack copy(Stack originalStack) {
        Stack intermediate = new Stack();
        Stack copyStack = new Stack();
        for (Object o : originalStack) {
            intermediate.push(o);
        }
        while (!intermediate.isEmpty()) {
            copyStack.push(intermediate.pop());
        }
        return copyStack;
    }

    public static void main(String[] args) {
        Stack<String> aStack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-")) aStack.push(s);
            else if (aStack.isEmpty()) System.out.println("pop: " + aStack.pop());
        }
        Stack<String> bStack = CopyStack.copy(aStack);
        System.out.println("Now printing bStack: ");
        for (String s : bStack) {
            System.out.println(s + ", ");
        }
    }
}
