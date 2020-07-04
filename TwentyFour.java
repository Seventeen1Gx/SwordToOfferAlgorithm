public class TwentyFour {
    // 反转链表

    // 递归
    public ListNode reverseList_1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 先记住会成为尾结点的那个结点
        ListNode next = head.next;
        // 把头结点拿下来
        head.next = null;
        ListNode newHead = reverseList_1(next);
        // 原 head 结点接到新链表的尾结点之后
        next.next = head;
        return newHead;
    }

    // 头插法重新组一个新链表
    public ListNode reverseList_2(ListNode head) {
        ListNode newList = new ListNode(-1);

        while (head != null) {
            // 先记住下一个结点的位置
            ListNode next = head.next;

            // 头插法
            head.next = newList.next;
            newList.next = head;

            // 相当于 i++
            head = next;
        }

        return newList.next;
    }

    // 三指针转换指针方向
    public ListNode reverseList_3(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p1 = null, p2 = head;
        while (p2 != null) {
            // 为了防止丢失 p2 之后的结点
            // 先保存
            ListNode p3 = p2.next;

            p2.next = p1;

            // i++

            p1 = p2;
            p2 = p3;
        }
        return p1;
    }

}
