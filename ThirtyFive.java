public class ThirtyFive {
    // 复杂链表的复制
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null)
            return null;

        // 遍历结点，在每个结点之后插入一个新结点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);

            clone.next = cur.next;
            cur.next = clone;

            cur = clone.next;
        }

        // 在新结点上复制一遍 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }

        // 拆分
        // cur 会遍历每个结点，包括新结点（上面两次遍历都只是遍历旧结点）
        // 对每个结点都进行一样的操作
        cur = pHead;

        // 把头结点记住
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            // 先记住 cur 之后的那个结点
            RandomListNode next = cur.next;
            // cur 之后接下一个结点的下一个结点
            cur.next = next.next;

            // i++
            cur = next;
        }
        return pCloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(int label) {
        this.label = label;
    }
}
