import java.util.*;

class Node {
    int val;
    Node prev, next;

    Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class day13p2 {

    public static Node insertEnd(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    public static Node sortDoublyLinkedList(Node head) {
        if (head == null || head.next == null) return head;

        Node current = head.next;
        while (current != null) {
            Node next = current.next;
            Node move = current.prev;

            while (move != null && move.val > current.val) {
                move = move.prev;
            }

            if (current.prev != null)
                current.prev.next = current.next;
            if (current.next != null)
                current.next.prev = current.prev;

            if (move == null) {
                current.next = head;
                head.prev = current;
                current.prev = null;
                head = current;
            } else {
                current.next = move.next;
                if (move.next != null)
                    move.next.prev = current;
                move.next = current;
                current.prev = move;
            }

            current = next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes : ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println();
            return;
        }

        Node head = null;
        System.out.print("Enter the values of nodes (space-separated integers) : ");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            head = insertEnd(head, val);
        }

        head = sortDoublyLinkedList(head);

        printList(head);
    }
}
