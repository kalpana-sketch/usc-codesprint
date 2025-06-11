import java.util.*;

public class day27p1 {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;

        Arrays.sort(indices, (a, b) -> score[b] - score[a]);

        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            if (i == 0) result[idx] = "Gold Medal";
            else if (i == 1) result[idx] = "Silver Medal";
            else if (i == 2) result[idx] = "Bronze Medal";
            else result[idx] = String.valueOf(i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] score1 = {50, 80, 30, 100};
        System.out.println(Arrays.toString(findRelativeRanks(score1)));

        int[] score2 = {23, 45, 67, 12, 89};
        System.out.println(Arrays.toString(findRelativeRanks(score2)));
    }
}
