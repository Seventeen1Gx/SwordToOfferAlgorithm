public class Fifteen {
    // 输入一个整数，输出该数二进制表示中 1 的个数。

    // 思路：n&(n-1) 该位级运算去除 n 的位级表示中最低位的 1

    public int numberOf1(int n) {
        int cnt = 0;
        // 每次去除一个位级表示中的 1，直到消成 0
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    // Java 自带方法
    public int numberOf1_plus(int n) {
        return Integer.bitCount(n);
    }
}
