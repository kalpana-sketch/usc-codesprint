import java.util.*;

public class day21p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("no. of persons = ");
        int n = sc.nextInt();
        int[] tickets = new int[n];
        System.out.print("tickets = ");

        for (int i = 0; i < n; i++) {
            tickets[i] = sc.nextInt();
        }

        System.out.print("k = ");
        int k = sc.nextInt();

        int time = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], tickets[k]);
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        System.out.println(time);
    }
}
