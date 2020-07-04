public class Seventeen {
    // 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。

    // 1. 由于 n 可能会比较大，所以用 char 数组保存
    // 2. 这里是从后往前回溯，摆好所有才会输出

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    // 目前要处理 number 的第 digit 位
    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            // 说明已经处理到第 n+1 位
            // 将之前处理好的 n 位打印即可

            // 只有这里才会打印
            printNumber(number);
            return;
        }

        // 对第 digit 位试验 10 种可能，每位从小往大放
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            // 摆好第 digit 位，再去摆第 digit + 1 位
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    // 打印 number 数组表示的数
    private void printNumber(char[] number) {
        int index = 0;
        // 排除开头的 0
        while (index < number.length && number[index] == '0') {
            index++;
        }
        // 开始打印
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
