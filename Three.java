public class Three {
    // 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
    // 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
    // 请找出数组中任意一个重复的数字。

    // 思路：关键是数字的范围是 0 到 n-1
    // 每个数字 i 放到 num[i] 处，如果 num[i] 处已经有了 i，就找到了重复
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;

        for (int i = 0; i < length; i++) {
            // 每次检查 num[i] 处的这个位置上的数字
            // 当发现这个位置上的数字刚好是 i 的时候，i++，去看下一个位置
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    // 找到重复
                    // 通过数组把这个元素传出去
                    duplication[0] = nums[i];
                    return true;
                }
                // 把 num[i] 放到 num[num[i]] 上
                Utils.swap(nums, i, nums[i]);
                // 然后重新检查 num[i] 这个位置
            }
        }
        return false;
    }
}
