import java.util.*;

public class day31p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> uniqueSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            uniqueSet.add(sc.nextInt());
        }

        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        Collections.sort(uniqueList);

        int count = 0;
        int size = uniqueList.size();

        for (int i = 1; i < size; i++) {
            count += i;
        }

        System.out.println(count);
    }
}
