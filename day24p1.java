import java.util.*;

public class day24p1 {

    public static String firstNonRepeating(String s) {
        int[] freq = new int[26];
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
            queue.offer(ch);

            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            result.append(queue.isEmpty() ? '#' : queue.peek());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter character stream:");
        String s = sc.nextLine();

        String output = firstNonRepeating(s);
        System.out.println("Output: " + output);
    }
}
