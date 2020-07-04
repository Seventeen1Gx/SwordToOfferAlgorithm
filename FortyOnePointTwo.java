import java.util.LinkedList;
import java.util.Queue;

public class FortyOnePointTwo {
    // 字符流中第一个不重复的字符

    // 统计每个字符出现的次数（只增不减）
    private int[] cnts = new int[256];
    // 普通队列
    private Queue<Character> queue = new LinkedList<>();

    // 维护一个队列，队列队头始终是第一个不重复的字符
    public void insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        // 栈顶如果是重复字符，就抛出
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
    }

    public char firstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
