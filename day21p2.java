import java.util.*;

public class day21p2 {

    public static int[] deckRevealedIncreasing(int[] input) {
        int n = input.length;
        Arrays.sort(input);

        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indexQueue.add(i);
        }

        int[] result = new int[n];
        for (int card : input) {
            int index = indexQueue.poll();
            result[index] = card;

            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll());
            }
        }

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

        int[] initialOrder = deckRevealedIncreasing(deck);

        System.out.println("Initial deck order to reveal in increasing order:");
        for (int i = 0; i < initialOrder.length; i++) {
            System.out.print(initialOrder[i]);
            if (i < initialOrder.length - 1) System.out.print(", ");
        }
        System.out.println();

        scanner.close();
    }
}



