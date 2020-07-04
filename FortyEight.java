import java.util.Arrays;

public class FortyEight {
    // 最长不含重复字符的子字符串

    // 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。

    // 双指针滑动窗口
    public int longestSubStringWithoutDuplication(String str) {
        // 当前考虑子串的长度
        int curLen = 0;
        // 记录遍历过程中遇到的最大长度
        int maxLen = 0;

        // 记录当前考虑的子串中字母出现的位置
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);

        // 当前考虑的子串是 str[curI-curLen:curI)，每次考虑 str[curI] 是否要加到子串中
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {
                // 说明当前考虑的子串中没有
                curLen++;
            } else {
                // 说明当前考虑的子串中已经有了 str[curI]
                maxLen = Math.max(maxLen, curLen);
                // 滑动开始的游标到重复字符串的后一个位置
                // 即现在考虑的子串是 str[curI+1-curLen:curI+1)
                // 代入下面这个式子，有 str[preI+1，curI+1)
                curLen = curI - preI;
            }
            // 更新子串中 str[curI] 出现在的位置
            preIndexs[c] = curI;
        }
        // 防止最长无重复子串出现在末尾
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
