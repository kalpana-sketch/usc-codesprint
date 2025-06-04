import java.util.*;

public class day6p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("jewels : ");
        String jewels = sc.nextLine();
        System.out.print("stones : ");
        String stones = sc.nextLine();
        sc.close();

        char[] j = jewels.toCharArray();
        char[] s = stones.toCharArray();
        int count = 0;

        for(int i = 0; i < j.length; i++) {
            for(int k = 0; k < s.length; k++) {
                if(j[i] == s[k]) {
                    count++;
                }
            }
        }

        System.out.println("Number of jewels : " + count);
    }
    
}
