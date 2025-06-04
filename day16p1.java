import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class day16p1 {

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }

    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
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

        System.out.println("Enter sorted values for list1 (space-separated):");
        String[] input1 = sc.nextLine().trim().split("\\s+");
        int[] list1Vals = input1[0].equals("") ? new int[0] : Arrays.stream(input1).mapToInt(Integer::parseInt).toArray();

        System.out.println("Enter sorted values for list2 (space-separated):");
        String[] input2 = sc.nextLine().trim().split("\\s+");
        int[] list2Vals = input2[0].equals("") ? new int[0] : Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();

        ListNode list1 = buildList(list1Vals);
        ListNode list2 = buildList(list2Vals);

        ListNode merged = mergeLists(list1, list2);
        printList(merged);
    }
}
