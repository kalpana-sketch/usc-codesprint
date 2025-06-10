import java.util.*;

public class day26p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        List<Integer> list = new ArrayList<>();
        for (int num : arr)
            list.add(num);


        list.sort((a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA != freqB)
                return Integer.compare(freqB, freqA);
            else
                return Integer.compare(a, b);
        });

        for (int num : list)
            System.out.print(num + " ");
    }
}
