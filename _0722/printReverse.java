package _0722;

public class printReverse {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void printReverse(ListNode head) {
        if (head == null) return;
        printReverse(head.next);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        // 建立一個範例鏈結串列：1 → 2 → 3 → null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.print("反向列印結果：");
        printReverse(head); // 輸出：3 2 1
    }
}
