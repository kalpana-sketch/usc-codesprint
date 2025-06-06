import java.util.*;

public class day22p1 {

    public static int trapRainwater(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of buildings:");
        int n = sc.nextInt();

        int[] heights = new int[n];
        System.out.println("Enter the building heights:");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        int result = trapRainwater(heights);
        System.out.println("Total trapped water: " + result);

        sc.close();
    }
}
