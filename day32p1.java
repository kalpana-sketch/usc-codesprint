import java.util.Scanner;

public class day32p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().replace("[", "").replace("]", "").split(",");
        int[] nums = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            nums[i] = Integer.parseInt(line[i].trim());
        }

        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        int missing = expectedSum - actualSum;
        System.out.println(missing);
        sc.close();
    }
}
