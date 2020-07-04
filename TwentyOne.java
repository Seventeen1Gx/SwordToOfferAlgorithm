public class TwentyOne {
    // 调整数组顺序使奇数位于偶数前面
    // 需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。

    // 思路：如果不保证相对位置，可以使用首尾指针碰撞的方法

    // 方法1：使用新数组
    public void reOrderArray_1(int[] nums) {
        // 先统计奇数的个数
        int oddCnt = 0;
        for (int x : nums)
            if (!isEven(x))
                oddCnt++;

        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (isEven(num))
                nums[j++] = num;
            else
                nums[i++] = num;
        }
    }

    // 方法2：冒泡思想，因为冒泡是稳定的
    public void reOrderArray_2(int[] nums) {
        int N = nums.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // 从左向右遍历过程中，如果发现相邻两个元素不满足奇数在左，偶数在右的情况，就交换
                // 一次遍历下来，会将遍历范围内最右边的偶数移动到遍历范围的最后
                if (isEven(nums[j]) && !isEven(nums[j + 1])) {
                    Utils.swap(nums, j, j + 1);
                }
            }
        }
    }


    private boolean isEven(int x) {
        return x % 2 == 0;
    }
}
