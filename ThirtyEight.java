import java.util.ArrayList;
import java.util.Arrays;

public class ThirtyEight {
    // 输入一个字符串，按字典序打印出该字符串中字符的所有排列。

    // 采用回溯

    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> permutation(String str) {
        if (str.length() == 0)
            return ret;

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuffer());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuffer s) {
        // 如果已经组合好一个排列，则添加
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }

        // 还没组合好
        // 现在要在 chars 中拿一个没用过的字符接在 s 末尾
        // 为了字母序，这里按顺序试错，因为 chars 中已经排好序了
        for (int i = 0; i < chars.length; i++) {
            // 判断这个字符是否用过
            if (hasUsed[i])
                continue;

            // 剪枝，避免重复
            // 这个位置 chars[i] 已经放过了
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1])
                continue;

            // 使用 chars[i]
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            // 回溯
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

}
