import java.util.*;

public class day8p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the minimum total calories to be burned : ");
        int target = sc.nextInt();
        System.out.print("Enter number of workout sessions : ");
        int n = sc.nextInt();
        int[] sessions = new int[n];
        System.out.print("Enter calories burned in each session : ");
        for(int i = 0; i < n; i++) {
            sessions[i] = sc.nextInt();
        }
        sc.close();

        int minLength = Integer.MAX_VALUE;
        int start = 0, sum = 0;

        for (int end = 0; end < n; end++) {
            sum += sessions[end];

            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= sessions[start];
                start++;
            }
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }    
}
