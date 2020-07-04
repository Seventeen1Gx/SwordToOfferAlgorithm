public class FiftyEightPointOne {
    // 翻转单词顺序列

    // Input:
    // "I am a student."
    //
    // Output:
    // "student. a am I"

    // 先旋转每个单词，再旋转整个序列
    public String reverseSentence(String str) {
        int n = str.length();
        // 字符串转字符数组，便于操作
        char[] chars = str.toCharArray();

        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                // j 到达一个单词的后一个字符
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
