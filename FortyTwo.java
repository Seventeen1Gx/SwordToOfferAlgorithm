public class FortyTwo {
    // 连续子数组的最大和

    // 一次遍历
    public int findGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int greatestSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int val : nums) {
            // sum 一旦小于等于 0，就从当前元素重新开始计算
            sum = sum <= 0 ? val : sum + val;
            // 记住这个过程中 sum 达到的最大值
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }
}
