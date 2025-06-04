import java.util.Scanner;
import java.util.Stack;

public class day17p2 {
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {
            if (isOperator(ch)) {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String expr = ch + op1 + op2;
                stack.push(expr);
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a valid postfix expression: ");
        String postfix = scanner.nextLine();

        String prefix = postfixToPrefix(postfix);
        System.out.println("Prefix expression: " + prefix);
    }
}
