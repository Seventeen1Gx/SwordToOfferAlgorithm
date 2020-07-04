public class TwentyThree {
    // 链表中环的入口结点

    // 可以用快慢双指针来判断一个链表中有无环
    // 但这题是要找到环的入口
    public ListNode entryNodeOfLoop(ListNode pHead) {
        // 头结点为 null 或者只有一个头结点的情况
        // 这时不可能有环的
        if (pHead == null || pHead.next == null)
            return null;

        ListNode slow = pHead, fast = pHead;
        // 之所以用 do，是因为开始时，两针是同一位置开始的
        // 而结束循环的条件也是两针再次相遇
        // 所以我们先让指针走起来
        do {
            // 快针每次走两步
            fast = fast.next.next;
            // 慢针每次走一步
            slow = slow.next;
        } while (fast != slow);

        // 上面出循环时，两针相遇

        // 快针从头开始，和慢针同步运动
        // 再次相遇，就是环的入口位置
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
