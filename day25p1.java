import java.util.*;

public class day25p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stones = new int[n];

        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        boolean found = hasThreeSum(stones, target);
        System.out.println(found);
    }

    public static boolean hasThreeSum(int[] arr, int target) {
        Arrays.sort(arr);

        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) return true;
                else if (sum < target) left++;
                else right--;
            }
        }

        return false;
    }
}
