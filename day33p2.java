import java.util.Scanner;

public class day33p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        int ones = 0;
        int operations = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                if (ones > 0) {
                    operations++;
                    ones--;
                }
            }
        }

        System.out.println(operations);
    }
}
