public class Five {
    // 将一个字符串中的空格替换成 "%20"。
    //
    // 思路：如果一个一个换，移动元素将耗费大量时间。

    public String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;

        // 每发现一个空格，就在末尾随便添加两个符号，因为一个空格要换成三个符号
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                str.append("**");
        }

        // 双指针，从后往前遍历
        int p2 = str.length() - 1;

        while (p1 >= 0 && p1 < p2) {
            // 当 p1 遍历到非空格，直接移动到 p2
            // 当 p1 遍历到空格，从 p2 处开始添加三个符号
            char c = str.charAt(p1--);
            if (c != ' ') {
                str.setCharAt(p2--, ' ');
            } else {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            }
        }
        return str.toString();
    }
}
