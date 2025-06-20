import java.util.*;

public class day21p2 {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = deck.length - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }
            deque.addFirst(deck[i]);
        }

        int[] result = new int[deck.length];
        int idx = 0;
        for (int num : deque) {
            result[idx++] = num;
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of cards:");
        int n = scanner.nextInt();

        int[] deck = new int[n];
        System.out.println("Enter the card values:");
        for (int i = 0; i < n; i++) {
            deck[i] = scanner.nextInt();
        }

        int[] result = deckRevealedIncreasing(deck);

        System.out.println("Initial deck order to reveal in increasing order:");
        for (int val : result) {
            System.out.print(val + " ");
        }
        scanner.close();
    }
}
