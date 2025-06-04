import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class day12p2 {

    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode zeroHead = new ListNode(0), oneHead = new ListNode(0), twoHead = new ListNode(0);
        ListNode zero = zeroHead, one = oneHead, two = twoHead;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.val == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

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

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter space-separated color codes (0=Red, 1=Blue, 2=Green):");
        String[] tokens = scanner.nextLine().trim().split("\\s+");
        int[] input = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            input[i] = Integer.parseInt(tokens[i]);
        }

        ListNode head = buildList(input);

        System.out.print("Original list: ");
        printList(head);

        ListNode sorted = sort(head);

        System.out.print("Sorted list:   ");
        printList(sorted);
        scanner.close();
    }
}
