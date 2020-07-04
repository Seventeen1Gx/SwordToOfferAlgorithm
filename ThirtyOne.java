import java.util.Stack;

public class ThirtyOne {
    // 栈的压入、弹出序列

    // 使用一个栈来模拟压入弹出操作
    public boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        // 元素个数
        int n = pushSequence.length;

        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            // 每个元素肯定都要入栈一次的
            stack.push(pushSequence[pushIndex]);
            // 出栈要根据出栈队列来决定
            // 如果栈顶元素刚好是出栈序列需要的，就出栈，然后处理出栈序列的下一个元素
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        // 全部出栈说明是对应的出栈序列
        return stack.isEmpty();
    }
}
