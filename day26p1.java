import java.util.*;

public class day26p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        Arrays.sort(arr);

        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                int diff = Math.abs(target - sum);

                if (diff < minDiff || (diff == minDiff && sum > closestSum)) {
                    closestSum = sum;
                    minDiff = diff;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(closestSum);
    }
}
