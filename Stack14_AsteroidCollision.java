package Stacks;
import java.util.Arrays;
import java.util.Stack;
class Stack14_AsteroidCollision {
    public static int[] asteroidCollision(int n, int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ele : asteroids){
            if(ele > 0){
                st.push(ele);
            }
            else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ele)){   
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(ele)){
                    
                    st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0)        
                    st.push(ele);
                }
            }
        int[] arr = new int[st.size()];
        for(int i = st.size()-1 ; i>=0 ; i-- ){   
            arr[i] = st.pop();
        }      
        return arr;
    }
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};  // You can change this input to test other cases
        int n = asteroids.length;
        // Call the asteroidCollision function
        int[] result = asteroidCollision(n, asteroids);
        // Print the output
        System.out.println("Final state of asteroids: " + Arrays.toString(result));
    }

}
