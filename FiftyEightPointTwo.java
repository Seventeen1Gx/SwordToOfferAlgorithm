public class FiftyEightPointTwo {
    // 左旋转字符串

    // Input:
    // S="abcXYZdef"
    // K=3
    //
    // Output:
    // "XYZdefabc"

    // 双逆法
    public String leftRotateString(String str, int n) {
        if (n >= str.length())
            return str;

        char[] chars = str.toCharArray();

        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
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
