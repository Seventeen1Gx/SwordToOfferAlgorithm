public class Nineteen {
    // 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。
    // 模式中的字符 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
    //
    // 在本题中，匹配是指字符串的所有字符匹配整个模式。
    // 例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。

    // 动态规划
    public boolean match(char[] str, char[] pattern) {
        int m = str.length, n = pattern.length;

        // dp[i][j] 表示 str[0,i) 和 pattern[0,j) 的匹配结果
        boolean[][] dp = new boolean[m + 1][n + 1];

        // "" 和 "" 是匹配的
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            // '*' 和它之前的哪个字符是可以忽略的，因为可以匹配 0 个
            // 所以 "" 和 pattern[0,i) 的匹配情况和 pattern[0, i-2) 的匹配情况相同
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // 求 dp[i][j]
                // 即 str[0,i) 和 pattern[0,j) 的匹配情况

                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    // 两个字符串的最后一个字符是相互匹配的
                    // 即 str[0,i) 和 pattern[0,j) 的匹配情况
                    // 相当于，str[0,i-1) 和 pattern[0,j-1) 的匹配情况
                    dp[i][j] = dp[i - 1][j - 1];

                } else if (pattern[j - 1] == '*') {
                    // 两个字符串的最后一个字符是不匹配的
                    // 但 pattern 最后一个字符是 '*'
                    // 则分两种情况
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        // pattern[j-2] pattern[j-1] 和 str[i-1] 匹配

                        // 分下列三种情况来匹配

                        // a* 当成 a，即忽略这个 '*'
                        dp[i][j] |= dp[i][j - 1];
                        // a* 当成多个 a
                        dp[i][j] |= dp[i - 1][j];
                        // a* 当成空串，一连忽略这两个字符
                        dp[i][j] |= dp[i][j - 2];
                    } else
                        // pattern[j-2] pattern[j-1] 和 str[i-1] 不匹配
                        // a* 当成空串，一连忽略这两个字符
                        dp[i][j] = dp[i][j - 2];
                }
                // 否则 str[0,i) 和 pattern[0,j) 不匹配
                // dp[i][j] 默认值就是 false，所以这里没动作
            }
        }
        return dp[m][n];
    }
}
