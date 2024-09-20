package Stacks_and_Queues.Stacks;

class Stack{
    int size = 10000;
    int arr[] = new int[size];
    int top = -1;
    
    public void push(int x){
        top++;
        arr[top] = x;
    }
    int top(){
        return arr[top];
    }
    int pop(){
        int x = arr[top];
        top--;
        return x;
    }
    int size(){
        return top  + 1;
    }
}
public class StackArray {
    public static void main(String[] args) {

        Stack s = new Stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
    }
}
