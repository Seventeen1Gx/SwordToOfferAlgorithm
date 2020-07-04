public class FiftySix {
    // 数组中只出现过一次的数字

    // 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。

    // 利用异或运算
    // 由于 a^a = 0，所以所有元素异或在一起的结果，就是 num1^num2
    public void findNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;

        // diff &= -diff 得到出 diff 最右侧不为 0 的位
        // 也就是 num1 和 num2 在位级表示上最右侧不同的那一位
        // 即 (num1^num2) & (-(num1^num2))
        diff &= -diff;

        // 最后的结果就是找到 num1，而 num2 是数组中剩下数的异或结果
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }
}
