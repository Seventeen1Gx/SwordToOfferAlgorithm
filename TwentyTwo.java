public class TwentyTwo {
    // 链表中倒数第 K 个结点

    // 双指针
    // 可以假设 k = 1 或者 k = 2 这样的小数字去验证
    public ListNode FindKthToTail(ListNode head, int k) {
        // 先让指针 p1 走 k 步
        ListNode p1 = head;
        while (p1 != null && k-- > 0)
            p1 = p1.next;

        // 链表长度不足 k
        if (k > 0)
            return null;

        // 指针 p2 从头开始移动
        // p1 也同步移动
        // 当 p1 到达链表尾部[的后一个结点，也就是 null]时
        // p2 就是要求的结点
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
