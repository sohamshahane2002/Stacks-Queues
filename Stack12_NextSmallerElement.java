package Stacks;
import java.util.Stack;
public class Stack12_NextSmallerElement {
    public static int[] findNextSmaller(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack while they are greater or equal to arr[i]
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            // If stack is empty, no smaller element exists
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();  // The next smaller element
            }
            stack.push(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = findNextSmaller(arr);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}