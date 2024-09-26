package Stacks;
import java.util.Stack;
public class Stack10_Prefix_To_Postfix {
    public static boolean isOperator(char c){
        if( c=='+' || c=='-' || c=='*' || c=='/' || c=='^'){
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
        if(isOperator(currentChar)){
            
            String opr1 = st.pop();
            String opr2 = st.pop();
            String infixExpression =   opr1 + " " + opr2 +" "+ currentChar;
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
    String prefixExpr = "/-AB*+DEF";
    System.out.println("Prefix Expression: " + prefixExpr);

    // Convert to infix
    String infixExpr = prefixtoInfix(prefixExpr);
    System.out.println("Infix Expression: " + infixExpr);
}
}
