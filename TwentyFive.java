public class TwentyFive {
    // 合并两个排序的链表

    // 递归
    public ListNode merge_1(ListNode list1, ListNode list2) {

        // 出口
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        // 小的在前
        if (list1.x <= list2.x) {
            list1.next = merge_1(list1.next, list2);
            return list1;
        } else {
            list2.next = merge_1(list1, list2.next);
            return list2;
        }
    }

    // 归并
    public ListNode merge_2(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(-1);
        ListNode cur = newList;
        while (list1 != null && list2 != null) {
            if (list1.x <= list2.x) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 可能还有一个 list 不为空
        // 整个列表一起接回去
        if (list1 != null)
            cur.next = list1;
        if (list2 != null)
            cur.next = list2;
        return newList.next;
    }
}
