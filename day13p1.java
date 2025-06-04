import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class day13p1 {

    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        int totalLength = 0;
        ListNode temp = head;
        while (temp != null) {
            totalLength++;
            temp = temp.next;
        }

        int baseSize = totalLength / k;
        int extra = totalLength % k;

        ListNode current = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            int partSize = baseSize + (i < extra ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                if (current != null) current = current.next;
            }

            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }

            result[i] = partHead;
        }

        return result;
    }

    public static void printParts(ListNode[] parts) {
        for (int i = 0; i < parts.length; i++) {
            ListNode node = parts[i];
            List<Integer> values = new ArrayList<>();
            while (node != null) {
                values.add(node.val);
                node = node.next;
            }
            if (values.isEmpty()) System.out.print("[]");
            else System.out.print(values);
            if (i < parts.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter task values (space-separated):");
        String[] values = sc.nextLine().trim().split("\\s+");
        int[] tasks = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            tasks[i] = Integer.parseInt(values[i]);
        }

        System.out.println("Enter number of parts (k):");
        int k = sc.nextInt();

        ListNode head = buildList(tasks);
        ListNode[] parts = splitListToParts(head, k);

        printParts(parts);
        sc.close();
    }
}
