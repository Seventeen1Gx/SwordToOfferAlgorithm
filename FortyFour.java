public class FortyFour {
    // 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。

    // 按一位数、两位数、三位数、... 这样给字符串分段
    // 一位数为 0~9，长度为 1*10
    // 两位数为 10~99，长度为 2*90
    // 三位数为 100~999，长度为 3*90
    // ...
    // 先判断 index 落在哪一段里，再从该段前往后找到落在哪个数字的第几位上
    public int getDigitAtIndex(int index) {
        if (index < 0)
            return -1;

        // place 表示当前考虑几位数连成的那段字符串
        int place = 1;
        while (true) {
            // place 位的数字的个数
            int amount = getAmoutOfPlace(place);
            // 这些数字共多少个字符
            int totalAmount = amount * place;
            // 说明落在 place 位的数字组成的那一段上
            if (index < totalAmount)
                return getDigitAtIndex(index, place);

            // 没有就减去开始的字符数，从 place+1 位的数字连成的字符串里找
            index -= totalAmount;
            place++;
        }

    }

    // 获取 place 位的数字的个数
    private int getAmoutOfPlace(int place) {
        if (place == 1)
            return 10;
        return (int) Math.pow(10, place - 1) * 9;
    }


    // 获取 place 位的数字中的第一个数字
    private int getBeginNumberOfPlace(int place) {
        if (place == 1)
            return 0;
        return (int) Math.pow(10, place - 1);
    }

    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        // 定点到某一个数字
        String number = (beginNumber + shiftNumber) + "";
        // 顶点到该数字的第几位
        int count = index % place;
        return number.charAt(count) - '0';
    }
}
