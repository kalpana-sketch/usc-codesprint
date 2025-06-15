import java.util.*;

public class day31p2 {

    static class BIT {
        int[] tree;
        int size;

        public BIT(int size) {
            this.size = size + 2;
            this.tree = new int[this.size];
        }

        void update(int i, int val) {
            while (i < size) {
                tree[i] += val;
                i += (i & -i);
            }
        }

        int query(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i -= (i & -i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        TreeSet<String> sortedWords = new TreeSet<>();
        Collections.addAll(sortedWords, words);

        HashMap<String, Integer> wordToIndex = new HashMap<>();
        int idx = 1;
        for (String word : sortedWords) {
            wordToIndex.put(word, idx++);
        }

        BIT bit = new BIT(wordToIndex.size());

        StringBuilder output = new StringBuilder();

        for (String word : words) {
            int wordIndex = wordToIndex.get(word);
            int niceness = bit.query(wordIndex - 1);
            output.append(niceness).append("\n");
            bit.update(wordIndex, 1);
        }

        System.out.print(output);
        sc.close();
    }
}
