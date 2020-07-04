import java.util.Stack;

public class Nine {
    // 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        // 入队列正常入
        in.push(node);
    }

    public int pop() throws Exception {
        // 当 out 栈为空时，将 in 栈全部导入 out 栈
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());

        // 从 out 栈出元素
        if (out.isEmpty())
            throw new Exception("queue is empty");

        return out.pop();

    }
}
