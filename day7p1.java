import java.util.*;

public class day7p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary string of logs : ");
        String log = sc.nextLine().trim();
        sc.close();

        int s = 0;
        boolean is = false;

        for(int i = 0; i < log.length(); i++) {
            char c = log.charAt(i);
            if(c == '1') {
                if(!is) {
                    s++;
                    is = true;
                }
            } else {
                is = false;
            }
        }

        System.out.println(s);
    }    
}
