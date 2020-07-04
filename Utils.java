public class Utils {
    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

class ListNode {
    int x;
    ListNode next;

    ListNode(int x) {
        this.x = x;
    }
}

class TreeNode {
    int x;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.x = x;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null; // 指向父结点的指针

    TreeLinkNode(int val) {
        this.val = val;
    }
}
