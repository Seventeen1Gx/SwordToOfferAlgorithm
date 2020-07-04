public class EighteenPointTwo {
    // 删除链表中重复的结点，重复的都要全删除
    // 链表中结点值从前往后是非递减的

    // 递归处理
    public ListNode deleteDuplication(ListNode pHead) {
        // 特殊情况
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode next = pHead.next;
        if (pHead.x == next.x) {
            // 发现重复
            // 要一直往后找到第一个不重复的（可能会一直找到尾）
            while (next != null && pHead.x == next.x)
                next = next.next;
            // 舍弃开头的那些重复的
            return deleteDuplication(next);
        } else {
            // 开头没重复，递归处理之后的
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
