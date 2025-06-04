import java.util.*;

public class day9p2 {
    static final int BASE = 256;
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("text : ");
        String text = sc.nextLine();
        System.out.print("pattern : ");
        String pattern = sc.nextLine();
        sc.close();

        List<Integer> result = findPatternMatches(text, pattern);
        System.out.println(result);
    }

    public static List<Integer> findPatternMatches(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        if(m > n) return indices;

        long patternHash = 0, textHash = 0, highestPower = 1;

        for(int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * BASE) % MOD;
        }

        for(int i = 0; i < m; i++) {
            patternHash = (patternHash * BASE + pattern.charAt(i)) % MOD;
            textHash = (textHash * BASE + text.charAt(i)) % MOD;
        }

        for(int i = 0; i <= n - m; i++) {
            if(patternHash == textHash) {
                if(text.substring(i, i + m).equals(pattern)) {
                    indices.add(i);
                }
            }

            if(i < n - m) {
                textHash = (textHash - text.charAt(i) * highestPower % MOD + MOD) % MOD;
                textHash = (textHash * BASE + text.charAt(i + m)) % MOD;
            }
        }
        return indices;
    }
}
