public class ThirtyNine {
    // 数组中出现一半次数的元素

    // 两两消除法
    public int moreThanHalfNum(int[] nums) {
        // 候选元素
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            // 出现一个候选元素 cnt 就加一，否则减一
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            // 如果 cnt 减到 0，即遍历到目前所有元素都两两消除，可以不考虑
            // 更新候选元素
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }

        // 重新统计一遍，看候选元素是否为正确答案
        int cnt = 0;
        for (int val : nums) {
            if (val == majority)
                cnt++;
        }

        return cnt > nums.length / 2 ? majority : 0;
    }
}
