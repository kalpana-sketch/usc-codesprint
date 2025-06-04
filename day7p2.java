import java.util.*;

public class day7p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days : ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        System.out.print("Enter prices : ");
        for(int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        sc.close();

        int min = prices[0];
        int max = 0;

        for(int i = 1; i < n; i++) {
            int profit = prices[i] - min;
            if(profit > max) {
                max = profit;
            }
            if(prices[i] < min) {
                min = prices[i];
            }
        }

        if(max >= 2) {
            System.out.println(max);
        } else {
            System.out.println(0);
        }
    }    
}
