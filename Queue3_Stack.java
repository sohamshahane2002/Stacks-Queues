package Queues;
import java.util.*;
class Queue3{

    Stack < Integer > input = new Stack <>();
    Stack < Integer > output = new Stack <>();
    // Push element x to the back of queue
    public void push(int x) {
        while (input.empty() == false) {
            output.push(input.peek());
            input.pop();
        }
        // Insert the desired element in the stack input
        System.out.println("The element pushed is " + x);
        input.push(x);
        // Pop out elements from the stack output and push them into the stack input
        while (output.empty() == false) {
            input.push(output.peek());
            output.pop();
        }
    }
    // Removes the element from in front of queue and returns that element. 
    public int pop() {
        // shift input to output 
        if (input.empty()) {
            System.out.println("Stack is empty");
        }
        int val = input.peek();
        input.pop();
        return val;
    }
    // Get the front element. 
    public int peek() {
        // shift input to output 
        if (input.empty()) {
            System.out.println("Stack is empty");
        }
        return input.peek();
    }
    int size() {
        return input.size();
    }
}
class Queue3_Stack  {
    public static void main(String args[]) {
        Queue3 q = new Queue3();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());

    }
}
