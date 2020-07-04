import java.util.ArrayList;
import java.util.Stack;

public class Six {
    // 从尾到头反过来打印出每个结点的值。

    // 递归法：打印当前结点值之前，先打印身后的
    // 相信返回值！
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();

        if (listNode != null) {
            ret.addAll(printListFromTailToHead_1(listNode.next));
            ret.add(listNode.x);
        }
        return ret;
    }

    // 使用头插法建立逆序链表，然后再按顺序打印
    public ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
        // 新链表的虚头结点
        ListNode dummyHead = new ListNode(-1);

        ListNode p = listNode;
        while (p != null) {
            // 记住下一个结点，以免丢失
            ListNode next = p.next;

            p.next = dummyHead.next;
            dummyHead.next = p;

            p = next;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        p = dummyHead.next;
        while (p != null) {
            ret.add(p.x);
            p = p.next;
        }
        return ret;
    }

    // 使用栈
    public ArrayList<Integer> printListFromTailToHead_3(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.x);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}
