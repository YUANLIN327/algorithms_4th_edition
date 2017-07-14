import edu.princeton.cs.algs4.StdIn;

public class Parentheses {
    private String[] testInputSeries;

    public Parentheses(String input) {
        System.out.println("input: " + input);
        testInputSeries = input.split("");
    }

    public boolean isValid() {
        Stack<String> stack = new Stack<>();
        for (String notation : testInputSeries) {
            System.out.println("current notation: " + notation);
            switch (notation) {
                case "{":
                    if (!stack.isEmpty()) return false;
                    stack.push(notation);
                    break;
                case "[":
                    if (!stack.isEmpty() && !stack.peek().equals("{")) return false;
                    stack.push(notation);
                    break;
                case ")":
                    if (stack.isEmpty() || !stack.pop().equals("(")) return false;
                    break;
                case "]":
                    if (stack.isEmpty() || !stack.pop().equals("[")) return false;
                    break;
                case "}":
                    if (stack.isEmpty() || !stack.pop().equals("{")) return false;
                    break;
                case "(":
                    stack.push(notation);
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        while (!StdIn.isEmpty()) {
            sb.append(StdIn.readString());
        }
        Parentheses p = new Parentheses(sb.toString());
        System.out.println("Is Valid: " + p.isValid());
    }
}
