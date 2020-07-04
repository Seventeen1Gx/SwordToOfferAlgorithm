public class FiftyThree {
    // 数字在排序数组中出现的次数

    public int getNumberOfK(int[] nums, int K) {
        int first = binarySearch(nums, K);
        int last = binarySearch(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }


    // 二分查找
    // 如果 target 出现在数组中，则得到其第一次出现所在下标
    // 否则得到第一个大于其的元素的下标（即插入位置，可能是 nums.length）
    private int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }
}
