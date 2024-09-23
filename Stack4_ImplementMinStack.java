package Stacks;
import java.util.Stack;
class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class MinStack {
    Stack <Pair> st;
    public MinStack() {
        st = new Stack <> ();
    }
    public void push(int x) {
        int min;
        if (st.isEmpty()) {
            min = x;
        } else {
            min = Math.min(st.peek().y, x);
        }
        st.push(new Pair(x, min));
    }
    public void pop() {
        st.pop();
    }
    public int top() {
        return st.peek().x;
    }
    public int getMin() {
        return st.peek().y;
    }
}
public class Stack4_ImplementMinStack{
public static void main(String[] args) {
    MinStack stack = new MinStack();

    stack.push(10);
    stack.push(5);
    stack.push(8);
    stack.push(12);
    
    System.out.println("Minimum element: " + stack.getMin());

    stack.pop();

    System.out.println("Minimum element after popping: " + stack.getMin());
}
}