package Stacks;
import java.util.Stack;
public class Stack7_Postfix_to_Infix {
    
    public static boolean isOperator(char c){
        if(c=='+' || c=='-' || c=='*' || c=='%' || c=='^'){
            return true;
        }
        return false;
    }
    static String postfixToInfix(String postfix){
        Stack <String>st = new Stack();
        int n = postfix.length();
        int i = 0;
        
        while(i<n){
            char currentChar = postfix.charAt(i);
            if(isOperator(currentChar)){
                
                String opr1 = st.pop();
                String opr2 = st.pop();
                String infixExpression = "(" + opr2 + " " + currentChar + " " + opr1 + ")";
                st.push(infixExpression);
            }
            else{
                st.push(currentChar+"");
            }
            i++;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String postfixExpr = "AB+C*";
        System.out.println("Postfix Expression: " + postfixExpr);

        // Convert to infix
        String infixExpr = postfixToInfix(postfixExpr);
        System.out.println("Infix Expression: " + infixExpr);
    }
}