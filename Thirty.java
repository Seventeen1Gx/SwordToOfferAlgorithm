import java.util.Stack;

public class Thirty {
    // 包含 min 函数的栈

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        // 同步入栈，如果该值比栈顶值更小就入栈这个值
        // 否则入栈栈顶的那个值
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        // 同步出栈
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
