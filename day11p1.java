import java.util.*;

public class day11p1 {
    public static List<Integer> reorder(List<Integer> appointments) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = appointments.size() - 1;

        while (start <= end) {
            if (start == end) {
                result.add(appointments.get(start));
            } else {
                result.add(appointments.get(start));
                result.add(appointments.get(end));
            }
            start++;
            end--;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of appointments:");
        int n = sc.nextInt();
        List<Integer> appointments = new ArrayList<>();

        System.out.println("Enter " + n + " appointment IDs:");
        for (int i = 0; i < n; i++) {
            appointments.add(sc.nextInt());
        }
        sc.close();

        List<Integer> zigZagOrder = reorder(appointments);
        System.out.println("Zig-zag reordered appointments:");
        for (int id : zigZagOrder) {
            System.out.print(id + " ");
        }
    }
}
