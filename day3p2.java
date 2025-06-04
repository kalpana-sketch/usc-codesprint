import java.util.*;

public class day3p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days : ");
        int n = sc.nextInt();
        int[] temps = new int[n];
        System.out.print("Enter temperature readings : ");
        for(int i = 0; i < n; i++) {
            temps[i] = sc.nextInt();
        }
        int currLen = 0;
        int maxLen = 0;
        for(int i = 1; i < n; i++) {
            if(temps[i] > temps[i - 1]){
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 1;
            }
        }
        System.out.println(maxLen);
        sc.close();
    }
    
}
