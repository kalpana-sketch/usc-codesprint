import java.util.*;

public class day1p2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of shots : ");
        int n = in.nextInt();
        int[] Scores = new int[n];
        System.out.print("Enter Scores : ");
        for(int i = 0; i < n; i++) {
            Scores[i] = in.nextInt();
        }
        int good = 0;
        int missed = 0;
        for(int i = 0; i < n; i++) {
            if(Scores[i] >= 7) {
                good++;
            }
            else {
                missed++;
            }
        }
        System.out.println(good + " " + missed);
        in.close();
    }
}
