import java.util.*;

public class day20p2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] nextGreater = new int[n];
        int[] nextSmaller = new int[n];
        Arrays.fill(nextGreater, -1);
        Arrays.fill(nextSmaller, -1);

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                nextGreater[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            int ngIndex = nextGreater[i];
            if(ngIndex != -1 && nextSmaller[ngIndex] != -1) {
                result[i] = arr[nextSmaller[ngIndex]];
            } else {
                result[i] = -1;
            }
        }

        for(int r : result) {
            System.out.print(r + " ");
        }
    }
}
