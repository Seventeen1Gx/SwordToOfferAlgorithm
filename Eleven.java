public class Eleven {
    // 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    // 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。

    // 二分法进行改进
    // 关键区分得到的两部分 [l, m] 和 [m, h]
    // 哪一部分是旋转数组（包含最小值）
    // 哪一部分是非递增数组
    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int l = 0, h = nums.length - 1;
        while (l < h) {
            // 防止 l + h 溢出
            int m = l + (h - l) / 2;
            // 说明 [m,h] 是非递减数组
            // 最小值在 [l, m] 中
            if (nums[m] <= nums[h])
                h = m;
            // 说明 [m, h] 是旋转数组
            else
                l = m + 1;
        }
        return nums[l];
    }


    public int minNumberInRotateArray_plus(int[] nums) {
        if (nums.length == 0)
            return 0;

        int l = 0, h = nums.length - 1;
        while (l < h) {
            // 防止 l + h 溢出
            int m = l + (h - l) / 2;

            // 特殊情况
            // 由于重复元素，当出现 nums[h]==nums[m]==nums[l] 时，退化为顺序查找
            if (nums[h] == nums[m] && nums[m] == nums[l])
                return minNumber(nums, l, h);

            // 说明 [m,h] 是非递减数组
            // 最小值在 [l, m] 中
            if (nums[m] <= nums[h])
                h = m;
                // 说明 [m, h] 是旋转数组
            else
                l = m + 1;
        }
        return nums[l];
    }

    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++) {
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        }
        return nums[l];
    }
}
