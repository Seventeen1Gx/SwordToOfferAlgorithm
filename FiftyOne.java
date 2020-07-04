public class FiftyOne {
    // 数组中的逆序对

    // 思路：利用归并排序

    private long cnt = 0;
    // 用来归并的辅助数组
    private int[] tmp;

    public int inversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        // 取余是题目要求的
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1)
            return;

        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }

    // 归并的过程中，进行逆序对的统计
    private void merge(int[] nums, int l, int m, int h) {
        // [l, m] 和 [m+1, h] 两部分进行归并
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            // 前两种情况是处理多出来的元素
            if (i > m)
                tmp[k] = nums[j++];
            else if (j > h)
                tmp[k] = nums[i++];
            // 下面是先放二者更小的
            else if (nums[i] <= nums[j])
                tmp[k] = nums[i++];
            else {
                // nums[i] > nums[j]
                // 构成逆序对
                // 而两个部分都是递增的
                // nums[i:m] 都大于 nums[j]
                // 则一次统计多个逆序对
                tmp[k] = nums[j++];
                this.cnt += m - i + 1;
            }
            k++;
        }
        // 拷贝回原数组
        for (k = l; k <= h; k++) {
            nums[k] = tmp[k];
        }
    }
}
