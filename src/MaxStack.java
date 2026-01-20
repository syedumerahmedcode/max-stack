import java.util.Stack;

public class MaxStack {

    /**
     * Using two stacks: One for regular values and the second which keeps track of
     * the maximum value.
     */
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : Math.max(maxStack.peek(), x);
        stack.push(x);
        maxStack.push(max);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        // find current max value in the maxStacka
        int max = peekMax();
        // initialize a new temporaray stack
        Stack<Integer> buffer = new Stack<>();
        // continue populating buffer stack until top is not equal to max
        while (top() != max) {
            buffer.push(pop());
        }
        // pop the maximum element
        pop();
        // fill up the regular stack again that we just stored in our buffer stack
        // temporarily
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
    }
}
