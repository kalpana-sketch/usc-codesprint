import java.util.*;

public class day34p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int size = primes.size();
        boolean[] isIndexPrime = new boolean[size + 2];
        Arrays.fill(isIndexPrime, true);
        isIndexPrime[0] = isIndexPrime[1] = false;

        for (int i = 2; i * i <= size + 1; i++) {
            if (isIndexPrime[i]) {
                for (int j = i * i; j <= size + 1; j += i)
                    isIndexPrime[j] = false;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (isIndexPrime[i + 1]) {
                result.add(primes.get(i));
            }
        }

        for (int sp : result) {
            System.out.print(sp + " ");
        }
    }
}
