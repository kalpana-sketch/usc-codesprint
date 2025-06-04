import java.util.*;

public class day9p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("logStream : ");
        String logStream = sc.nextLine();
        System.out.print("pattern : ");
        String pattern = sc.nextLine();
        sc.close();

        List<Integer> result = findAnagramIndices(logStream, pattern);
        System.out.println(result);
    }

    public static List<Integer> findAnagramIndices(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        if(p.length() > s.length()) return indices;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for(int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(pCount, sCount)) {
            indices.add(0);
        }

        for(int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;

            if(Arrays.equals(pCount, sCount)) {
                indices.add(i - p.length() + 1);
            }
        }
        return indices;
    }
}
