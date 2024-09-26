package Stacks;
import java.util.Stack;
public class Stack9_Postfix_To_Prefix {
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
    }
    static String postfixToprefix(String postfix) {
        Stack<String> st = new Stack<>();
        int n = postfix.length();
        int i = 0;
        while (i < n) {
            char currentChar = postfix.charAt(i);
            if (isOperator(currentChar)) {
                String opr1 = st.pop();
                String opr2 = st.pop();
                String Expression = currentChar + opr2 + opr1;
                st.push(Expression);
            } else {
                st.push(currentChar + "");
            }
            i++;
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String postfixExpr = "AB-DE+F*/";
        System.out.println("Postfix Expression: " + postfixExpr);
        String prefixExpr = postfixToprefix(postfixExpr);
        System.out.println("Prefix Expression: " + prefixExpr);
    }
}
