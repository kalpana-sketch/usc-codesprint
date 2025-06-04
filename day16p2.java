import java.util.*;

class ListNode {
    String val;
    ListNode next;

    ListNode(String val) {
        this.val = val;
        this.next = null;
    }
}

public class day16p2 {
    public static ListNode listToLinkedList(String[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static List<String> linkedListToList(ListNode head) {
        List<String> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode("");
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shopping list items (space-separated): ");
        String[] items = scanner.nextLine().split(" ");

        System.out.print("Enter the left position to reverse from (1-based): ");
        int left = scanner.nextInt();

        System.out.print("Enter the right position to reverse to (1-based): ");
        int right = scanner.nextInt();

        ListNode head = listToLinkedList(items);
        ListNode newHead = reverseBetween(head, left, right);

        List<String> result = linkedListToList(newHead);
        System.out.println("Updated shopping list: " + result);
    }
}
