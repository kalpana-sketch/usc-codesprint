import java.util.*;

public class day22p2 {

    public static int countStudentsUnableToEat(int[] students, int[] sandwiches) {

        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }

        int index = 0;
        int noMatchCount = 0;

        while (!queue.isEmpty()) {
            if (queue.peek() == sandwiches[index]) {
                queue.poll();
                index++;
                noMatchCount = 0;
            } else {
                queue.offer(queue.poll());
                noMatchCount++;
            }

            if (noMatchCount == queue.size()) {
                break;
            }
        }

        return queue.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int n = sc.nextInt();

        int[] students = new int[n];
        int[] sandwiches = new int[n];

        System.out.println("Enter student preferences (0 or 1):");
        for (int i = 0; i < n; i++) {
            students[i] = sc.nextInt();
        }

        System.out.println("Enter sandwich stack (top to bottom):");
        for (int i = 0; i < n; i++) {
            sandwiches[i] = sc.nextInt();
        }

        int result = countStudentsUnableToEat(students, sandwiches);
        System.out.println("Number of students unable to eat: " + result);

        sc.close();
    }
}
