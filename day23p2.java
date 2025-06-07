import java.util.*;

public class day23p2 {
    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Fill queues with indices of 'R' and 'D' senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        // Simulate rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            // The senator with the lower index acts first and bans the other
            if (rIndex < dIndex) {
                // Radiant bans Dire; Radiant gets back in the queue for the next round
                radiant.add(rIndex + n);
            } else {
                // Dire bans Radiant; Dire gets back in the queue for the next round
                dire.add(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter senate string (R for Radiant, D for Dire):");
        String senate = sc.next();
        System.out.println("Winner: " + predictPartyVictory(senate));
        sc.close();
    }
}
