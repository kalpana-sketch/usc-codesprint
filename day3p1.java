import java.util.*;

public class day3p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of warehouses : ");
        int r = sc.nextInt();
        System.out.print("Enter number of product types : ");
        int c = sc.nextInt();
        int[][] stock = new int[r][c];
        System.out.print("Enter number of units : ");
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                stock[i][j] = sc.nextInt();
            }
        }
        int o = 0;
        for(int i = 0; i < r; i++){
            int count = 0;
            for(int j = 0; j < c; j++){
                if(stock[i][j] >= 100){
                    count++;
                }
            }
            if(count >= 3){
                o++;
            }
        }
        System.out.println(o);
        sc.close();
    }
}
