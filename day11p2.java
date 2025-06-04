import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class day11p2 {

    public static boolean detectAndRemoveLoop(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                removeLoop(head, slow);
                return true;
            }
        }

        return true;
    }

    private static void removeLoop(ListNode head, ListNode meetingPoint) {
        ListNode ptr1 = head;
        ListNode ptr2 = meetingPoint;

        if (ptr1 == ptr2) {
            while (ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
            ptr2.next = null;
            return;
        }

        while (ptr1.next != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr2.next = null;
    }

    public static ListNode buildList(int[] values, int pos) {
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        ListNode loopStart = (pos == 1) ? head : null;

        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
            if (i == pos - 1) {
                loopStart = curr;
            }
        }

        if (pos > 0) {
            curr.next = loopStart;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < 50) {
            System.out.print(curr.val + " ");
            curr = curr.next;
            count++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("List is empty.");
            return;
        }

        int[] values = new int[n];
        System.out.print("Enter " + n + " node values: ");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        System.out.print("Enter position to form loop (0 for no loop): ");
        int pos = sc.nextInt();

        sc.close();

        ListNode head = buildList(values, pos);
        boolean result = detectAndRemoveLoop(head);
        System.out.println("Loop removed successfully: " + result);
        System.out.print("Final Linked List: ");
        printList(head);
    }
}
