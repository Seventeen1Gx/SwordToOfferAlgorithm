import java.util.ArrayList;
import java.util.Arrays;

public class FiftySevenPointOne {
    // 和为 S 的两个数字

    // 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。
    // 如果有多对数字的和等于 S，输出两个数的乘积最小的。


    // 越接近的两个数乘积越大
    // 即两数之和问题，采用双指针或者哈希法
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum)
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            if (cur < sum)
                i++;
            else
                j--;
        }
        return new ArrayList<>();
    }
}
