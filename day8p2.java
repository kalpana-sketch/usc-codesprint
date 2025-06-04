import java.util.*;

public class day8p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the speech : ");
        String speechLine = sc.nextLine();
        sc.close();

        String[] words = speechLine.trim().split("\\s+");

        StringBuilder result = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if(i != 0) {
                result.append(" ");
            }
        }
        
        System.out.println(result.toString());
    }    
}
