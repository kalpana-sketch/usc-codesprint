import java.util.*;

public class day19p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Stack<String> stack = new Stack<>();
        Map<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            if (line.startsWith("PUSH")) {
                String gift = line.substring(5).trim();
                stack.push(gift);
                frequency.put(gift, frequency.getOrDefault(gift, 0) + 1);
            } else if (line.equals("POP")) {
                if (!stack.isEmpty()) {
                    String removed = stack.pop();
                    frequency.put(removed, frequency.get(removed) - 1);
                    if (frequency.get(removed) == 0) {
                        frequency.remove(removed);
                    }
                }
            } else if (line.equals("COUNT")) {
                if (stack.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    String top = stack.peek();
                    System.out.println(frequency.get(top));
                }
            }
        }
    }
}
