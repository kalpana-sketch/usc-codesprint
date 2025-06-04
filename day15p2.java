import java.util.*;

class DoublyNode {
    int val;
    DoublyNode prev, next;

    DoublyNode(int val) {
        this.val = val;
    }
}

public class day15p2 {

    public static DoublyNode removeCursedBeads(DoublyNode head, int target) {
        DoublyNode current = head;

        while (current != null) {
            if (current.val == target) {
                if (current.prev != null)
                    current.prev.next = current.next;
                else
                    head = current.next;

                if (current.next != null)
                    current.next.prev = current.prev;
            }
            current = current.next;
        }
        return head;
    }

    public static DoublyNode buildList(int[] arr) {
        if (arr.length == 0) return null;

        DoublyNode head = new DoublyNode(arr[0]);
        DoublyNode current = head;
        for (int i = 1; i < arr.length; i++) {
            DoublyNode node = new DoublyNode(arr[i]);
            current.next = node;
            node.prev = current;
            current = node;
        }
        return head;
    }

    public static void printList(DoublyNode head) {
        if (head == null) {
            System.out.println("head -> (empty list)");
            return;
        }

        System.out.print("head -> ");
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null)
                System.out.print(" <-> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter space-separated bead values:");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] values = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

        System.out.println("Enter the cursed number (target to remove):");
        int target = sc.nextInt();

        DoublyNode head = buildList(values);
        head = removeCursedBeads(head, target);
        printList(head);
    }
}
