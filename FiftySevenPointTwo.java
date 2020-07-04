import java.util.ArrayList;

public class FiftySevenPointTwo {
    // 和为 S 的连续正数序列

    // 双指针滑动窗口
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        int start = 1, end = 2;
        int curSum = 3;
        // 当 end 都等于 sum 了，[start:end] 之和肯定超过了
        while (end < sum) {
            if (curSum > sum) {
                // 说明从 [start:end] 之和过大
                // 头指针后移一格
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                // 当前和过小
                // 尾指针后移一格
                end++;
                curSum += end;
            } else {
                // 找到一个答案
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);

                // 切换下一个窗口
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}
