import java.util.Arrays;

public class day28p2 {

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, maxScore = 0;
        int i = 0, j = tokens.length - 1;

        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0 && i < j) {
                power += tokens[j--];
                score--;
            } else {
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{20, 50, 70, 120}, 90));
        System.out.println(bagOfTokensScore(new int[]{10, 30, 60, 90}, 100));
    }
}
