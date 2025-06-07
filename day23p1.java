import java.util.*;

public class day23p1 {

    public static int maxScore(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);

        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            dp[i] = nums[i] + dp[deque.peekFirst()];

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }

            deque.add(i);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rooms:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter room values (positive for treasure, negative for traps):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter maximum jump distance (k):");
        int k = sc.nextInt();

        int result = maxScore(nums, k);
        System.out.println("Maximum achievable score: " + result);

        sc.close();
    }
}
