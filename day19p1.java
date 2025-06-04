import java.util.*;

public class day19p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            if (line.startsWith("PUSH")) {
                int temp = Integer.parseInt(line.substring(5).trim());
                mainStack.push(temp);
                if (minStack.isEmpty() || temp <= minStack.peek()) {
                    minStack.push(temp);
                }
            } else if (line.equals("POP")) {
                if (!mainStack.isEmpty()) {
                    int popped = mainStack.pop();
                    if (popped == minStack.peek()) {
                        minStack.pop();
                    }
                }
            } else if (line.equals("MIN")) {
                if (minStack.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(minStack.peek());
                }
            }
        }
    }
}
