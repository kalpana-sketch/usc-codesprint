import java.util.*;

public class day10p2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode removeConsecutiveDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;  // Skip duplicate
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode buildList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the linked list: ");
        int n = sc.nextInt();

        int[] input = new int[n];
        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();

        ListNode head = buildList(input);
        System.out.print("Original: ");
        printList(head);

        ListNode result = removeConsecutiveDuplicates(head);
        System.out.print("Deduplicated: ");
        printList(result);
    }
}

