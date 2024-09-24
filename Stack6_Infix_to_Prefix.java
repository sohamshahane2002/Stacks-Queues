package Stacks;
import java.util.Stack;
public class Stack6_Infix_to_Prefix {
      // Method to get precedence of an operator
        private static int precedence(char ch) {
            switch (ch) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;  // Higher precedence for exponentiation
                default:
                    return -1;
            }
        }
        // Method to check if a character is an operator
        private static boolean isOperator(char ch) {
            return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
        }
        // Method to reverse the input expression
        private static String reverseExpression(String expr) {
            StringBuilder reversedExpr = new StringBuilder(expr.length());
            for (int i = expr.length() - 1; i >= 0; i--) {
                char ch = expr.charAt(i);
                if (ch == '(') {
                    reversedExpr.append(')');
                } else if (ch == ')') {
                    reversedExpr.append('(');
                } else {
                    reversedExpr.append(ch);
                }
            }
            return reversedExpr.toString();
        }
        // Method to convert infix expression to postfix expression (same as infix to postfix)
        public static String infixToPostfix(String expression) {
            Stack<Character> stack = new Stack<>();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (Character.isLetterOrDigit(c)) {// If the character is an operand, add it to the result
                    result.append(c);
                }
                // If the character is '(', push it to the stack
                else if (c == '(') {
                    stack.push(c);
                }
                // If the character is ')', pop from the stack until '(' is encountered
                else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop());
                    }
                    stack.pop();  // Remove '(' from the stack
                }
                // If the character is an operator
                else if (isOperator(c)) {
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                        result.append(stack.pop());
                    }
                    stack.push(c);  // Push current operator to stack
                }}
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            return result.toString();
        }
        // Method to convert infix to prefix expression
        public static String infixToPrefix(String expression) {   
            String reversedInfix = reverseExpression(expression);  // Step 1: Reverse the infix expression
            String postfix = infixToPostfix(reversedInfix);        // Step 2: Convert the reversed infix to postfix
            String prefix = new StringBuilder(postfix).reverse().toString();  // Step 3: Reverse the postfix to get the prefix expression
            return prefix;
        }
        public static void main(String[] args) {
            String infixExpression = "(A-B/C)*(A/K-L)";  //infix expression
            String prefixExpression = infixToPrefix(infixExpression);
            System.out.println("Prefix Expression: " + prefixExpression);
        }
    
        
}
