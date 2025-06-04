import java.util.Scanner;

public class day20p1 {

    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (balance == 0) {
                    start = i;
                }
                balance++;
            } else {
                balance--;
                if (balance == 0) {
                    result.append(s, start + 1, i);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String decoded = removeOuterParentheses(s);
        System.out.println(decoded);
    }
}
