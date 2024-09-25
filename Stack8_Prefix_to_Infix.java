package Stacks;
import java.util.Stack;
public class Stack8_Prefix_to_Infix {
    public static boolean isOpertaor(char c){
        if(c=='+' || c=='-' || c=='*' || c=='%' || c=='^'){
            return true;
        }
        return false;
    }
public static String prefixtoInfix(String prefix){
    Stack <String>st = new Stack();
        int n = prefix.length();
        int i = n-1;
        while(i>=0){
            char currentChar = prefix.charAt(i);
            if(isOpertaor(currentChar)){
                
                String opr1 = st.pop();
                String opr2 = st.pop();
                String infixExpression = "(" + opr1 + " " + currentChar + " " + opr2 + ")";
                st.push(infixExpression);
            }
            else{
                st.push(currentChar+"");
            }
            i--;
        }
        return st.peek();
}
public static void main(String[] args) {
    String prefixExpr = "*+AB-CD";
    System.out.println("Prefix Expression: " + prefixExpr);

    // Convert to infix
    String infixExpr = prefixtoInfix(prefixExpr);
    System.out.println("Infix Expression: " + infixExpr);
}
}
