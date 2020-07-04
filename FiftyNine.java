import java.util.ArrayList;
import java.util.PriorityQueue;

public class FiftyNine {
    // 滑动窗口的最大值

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;

        // 大顶堆，队头是最大元素
        // 用来保存滑动窗口中的元素
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        // 先加入第一个窗口 [0:size)
        for (int i = 0; i < size; i++)
            heap.add(num[i]);

        // 加入第一个窗口中的最大值
        ret.add(heap.peek());

        // 滑动窗口的过程中，维护堆
        // i 是将要被移除的元素
        // j 是将要被加入的元素
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            // 滑动一次
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }

        return ret;
    }
    
}
