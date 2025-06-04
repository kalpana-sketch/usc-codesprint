import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class day14p1 {

    public static ListNode buildList(int[] badges) {
        if (badges.length == 0) return null;
        ListNode head = new ListNode(badges[0]);
        ListNode current = head;
        for (int i = 1; i < badges.length; i++) {
            current.next = new ListNode(badges[i]);
            current = current.next;
        }
        return head;
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static List<Integer> getFromMiddleToEnd(ListNode middle) {
        List<Integer> result = new ArrayList<>();
        while (middle != null) {
            result.add(middle.val);
            middle = middle.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().trim().split(" ");
        int[] badges = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();

        ListNode head = buildList(badges);
        ListNode middle = findMiddle(head);

        List<Integer> result = getFromMiddleToEnd(middle);
        System.out.println(result);
    }
}
