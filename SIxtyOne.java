import java.util.Arrays;

public class SIxtyOne {
    // 扑克牌顺子

    // 大小王为癞子，判断给的 5 张牌能不能组成顺子

    public boolean isContinuous(int[] nums) {
        if (nums.length < 5)
            return false;

        // 排序
        Arrays.sort(nums);

        // 统计癞子数量
        int cnt = 0;
        for (int num : nums)
            if (cnt == 0)
                cnt++;

        // 使用癞子进行补全
        // 注意这里 i 从 cnt 开始，因为 cnt 之前的都是癞子，癞子为 0
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return false;

            // 差几个就补几个
            cnt -= nums[i+1] - nums[i] - 1;
        }

        return cnt >= 0;
    }

}
