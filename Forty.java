import java.util.ArrayList;
import java.util.PriorityQueue;

public class Forty {
    // 最小的 K 个数


    // 方法一：利用快排
    public ArrayList<Integer> getLeastNumbers_1(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        // 不合理的情况
        if (k > nums.length || k <= 0)
            return ret;

        // 运行完后，nums 中前 k 个元素就是我们要求的
        findKthSmallest(nums, k);

        for (int i = 0; i < k; i++) {
            ret.add(nums[i]);
        }
        return ret;

    }

    private void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k)
                break;
            if (j > k)
                // 最小的 k 个数在左侧
                h = j - 1;
            else
                // 最小的 k 个数在右侧
                l = j + 1;
        }
    }

    // 将 nums[l:h] 作一次分割
    private int partition(int[] nums, int l, int h) {
        // 枢纽
        int p = nums[l];
        // 为了对称，这里 j 从 h+1 开始
        int i = l, j = h + 1;
        while (true) {
            // 从前往后找到第一个大于等于 p 的元素，它应该被放到后面
            while (i != h && nums[++i] < p);
            // 从后往前找到第一个小于等于 p 的元素，它应该被放到前面
            while (j != l && nums[--j] > p);
            // 两针相撞时退出循环
            if (i >= j)
                break;
            // 交换 i、j 处元素
            Utils.swap(nums, i, j);
        }
        // 将枢纽放到最后的位置上
        Utils.swap(nums, l, j);
        return j;
    }


    // 方法二：利用堆排
    public ArrayList<Integer> getLeastNumbers_2(int[] nums, int k) {
        if (k  > nums.length || k <= 0)
            return new ArrayList<>();

        // 优先级队列
        // 按元素的自然顺序或者传入的比较器进行比较，将认为小的放在队头，这里可以知道，默认是最小堆
        // 这里的 lamda 表达式中，如果实际 o1<o2，被认为 o1>o2，即实际更大的放在队列头，即最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                // 最大堆，出队的是更大的元素
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
