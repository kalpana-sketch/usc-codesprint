import java.util.*;

public class day4p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the square matrix(a single odd integer) : ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    System.out.print(i + 1 + " ");
                } else if(i + j == n - 1) {
                    System.out.print(n - i + " ");
                } else {
                    System.out.print( "- ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
