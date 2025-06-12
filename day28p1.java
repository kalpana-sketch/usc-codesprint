import java.util.*;

public class day28p1 {

    public static String rearrangeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freq[b - 'a'] - freq[a - 'a']
        );

        for (char c = 'a'; c <= 'z'; c++) {
            if (freq[c - 'a'] > 0) {
                maxHeap.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        char prev = 0;
        int prevFreq = 0;

        while (!maxHeap.isEmpty()) {
            char curr = maxHeap.poll();
            result.append(curr);
            freq[curr - 'a']--;

            if (prevFreq > 0) {
                maxHeap.offer(prev);
            }

            prev = curr;
            prevFreq = freq[curr - 'a'];
        }

        return result.length() == s.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(rearrangeString("aab"));
        System.out.println(rearrangeString("aaab"));
    }
}
