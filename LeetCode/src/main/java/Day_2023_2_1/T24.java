package Day_2023_2_1;

/**
 * @author wak
 */
public class T24 {
    //递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = swapPairs(head.next.next);
        ListNode tmp;
        tmp = head.next;
        head.next = h;
        tmp.next = head;
        head = tmp;
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}