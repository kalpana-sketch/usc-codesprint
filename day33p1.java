import java.util.*;

public class day33p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Set<Integer> uniqueThemes = new HashSet<>();

        for (int i = 0; i < N; i++) {
            uniqueThemes.add(sc.nextInt());
        }

        if (uniqueThemes.size() >= K) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
