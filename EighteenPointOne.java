public class EighteenPointOne {
    // 在 O(1) 时间内删除链表节点

    // 平均下来还是 O(1)
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return null;
        if (tobeDelete.next != null) {
            // 要删的结点不是尾结点
            // 将其身后结点的值赋值给要删的结点
            // 然后把身后的结点删除了

            tobeDelete.x = tobeDelete.next.x;
            tobeDelete.next = tobeDelete.next.next;
        } else {
            // 要删的结点是尾结点
            // 从头找到尾结点的前一个结点，然后将该结点的 next 设为 null

            // 特殊情况：只有一个结点
            if (head == tobeDelete) {
                head = null;
            } else {
                ListNode cur = head;
                while (cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }
}
