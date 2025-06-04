import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class day14p2 {

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode doubleNumber(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (head != null || carry > 0) {
            int sum = carry + (head != null ? head.val * 2 : 0);
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (head != null) head = head.next;
        }

        return reverse(dummy.next);
    }

    public static ListNode buildList(int[] digits) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int d : digits) {
            current.next = new ListNode(d);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().trim().split(" ");
        int[] digits = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

        ListNode head = buildList(digits);
        ListNode doubled = doubleNumber(head);
        printList(doubled);
    }
}
