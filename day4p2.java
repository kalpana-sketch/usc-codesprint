import java.util.*;

public class day4p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of days Abhik trained : ");
        int n = sc.nextInt();
        sc.close();

        if(n > 10) {
            System.out.println("Abhik's marathon journey intensifies! Let's see his detailed zig-zag pattern : ");
        }

        int total = 0;
        int max = (4 * n) - 3;

        for(int day = 1; day <= n; day++) {
            StringBuilder row = new StringBuilder();

            if(day % 2 != 0) {
                for(int i = 1; i <= day; i++) {
                    row.append(i);
                    if(i != day) row.append("   ");
                } 
            } else {
                for(int i = day; i >= 1; i--) {
                    row.append(i);
                    if(i != 1) row.append("   ");
                }
            }

            int curr = row.length();
            int padding = (max - curr) / 2;
            System.out.printf("%" + (padding + curr) + "s\n", row.toString());

            total += day;
        }
        System.out.println("Total numbers printed : " + total);
    }
}
