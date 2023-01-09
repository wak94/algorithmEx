package Day_12_13;


import org.junit.jupiter.api.Test;

/**
 * @author wak
 */
public class T19 {

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        ListNode cur = removeNthFromEnd(n1, 1);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        //第count个节点即为需要删除的节点的前一个节点
        int count = count(head) - n;
        ListNode cur = head;
        if (count == 0) {
            head = head.next;
        }
        if (count > 0) {
            for (int i = 0; i < count - 1; i++) {
                cur = cur.next;
            }
        }
        if (cur != null && cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }

    public int count(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        return n;
    }
}
