import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class day15p1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }

    public static ListNode buildList(int[] digits) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int digit : digits) {
            current.next = new ListNode(digit);
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

        System.out.println("Enter digits for first number (reversed), space-separated:");
        String[] l1Str = sc.nextLine().trim().split("\\s+");
        int[] l1Arr = Arrays.stream(l1Str).mapToInt(Integer::parseInt).toArray();
        ListNode l1 = buildList(l1Arr);

        System.out.println("Enter digits for second number (reversed), space-separated:");
        String[] l2Str = sc.nextLine().trim().split("\\s+");
        int[] l2Arr = Arrays.stream(l2Str).mapToInt(Integer::parseInt).toArray();
        ListNode l2 = buildList(l2Arr);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("Result (reversed sum):");
        printList(result);
    }
}
