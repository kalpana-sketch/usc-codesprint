import java.util.*;

public class day5p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the hall : ");
        int n = sc.nextInt();
        sc.close();

        int[][] mat = new int[n][n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((i + j) % 2 == 0) {
                    mat[i][j] = 1;
                    count++;
                } else {
                    mat[i][j] = 0;
                }
            }
        }

        System.out.println("The seating arrangement : ");

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(mat[i][j]);
                if (j != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("Total students seated:" + count);
    }
}
