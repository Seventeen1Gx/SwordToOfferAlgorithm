import java.util.PriorityQueue;

public class FortyOnePointOne {
    // 数据流中的中位数

    // 大顶堆，存储左半边元素
    // 这里的比较器解释：当实际 o1 > o2 时，返回负数，即比较器认为 o1 < o2
    // 默认是小顶堆，这里相当于逆序！
    private PriorityQueue<Integer> left = new PriorityQueue<>(((o1, o2) -> o2 - o1));

    // 小顶堆，存储右半边元素，且右半边元素都大于左半边
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    // 当前数据流读入的元素个数
    private int N = 0;

    // 插入要保证两堆处于平衡状态
    public void insert(Integer val) {
        if (N % 2 == 0) {
            // N 为偶数的情况下，插入右半边
            // 为了保证右半边元素大于左半边
            // 先插入左半边，再取出最大元素插入到右半边
            left.add(val);
            right.add(left.poll());
        } else {
            // N 为奇数的情况，即右半边比左半边多一个元素
            // 先插入右半边，然后再取最小的插入左半边
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public double getMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();
    }
}
