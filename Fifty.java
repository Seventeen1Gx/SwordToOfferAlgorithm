public class Fifty {
    // 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。

    // 最直观的解法是使用 HashMap 对出现次数进行统计，但是考虑到要统计的字符范围有限，因此可以使用整型数组代替 HashMap，从而将空间复杂度由 O(N) 降低为 O(1)。
    public int findNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        // 遍历一遍，统计每个字符出现的次数
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        // 再根据统计信息求得第一个只出现一次的字符
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }
}
