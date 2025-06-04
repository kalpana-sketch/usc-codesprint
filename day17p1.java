import java.util.Scanner;
import java.util.Stack;

public class day17p1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your secret message: ");
        String s = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("Reversed message: " + reversed);
    }
}
