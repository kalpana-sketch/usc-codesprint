import java.util.*;

public class day34p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] houseInput = sc.nextLine().split(" ");
        int[] houses = Arrays.stream(houseInput).mapToInt(Integer::parseInt).toArray();

        String[] heaterInput = sc.nextLine().split(" ");
        int[] heaters = Arrays.stream(heaterInput).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int maxRadius = 0;

        for (int house : houses) {
            int closestDist = findClosestHeater(house, heaters);
            maxRadius = Math.max(maxRadius, closestDist);
        }

        System.out.println(maxRadius);
    }

    private static int findClosestHeater(int house, int[] heaters) {
        int left = 0, right = heaters.length - 1;
        int minDist = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int dist = Math.abs(heaters[mid] - house);
            minDist = Math.min(minDist, dist);

            if (heaters[mid] < house) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return minDist;
    }
}
