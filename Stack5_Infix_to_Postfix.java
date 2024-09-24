package Stacks;
import java.util.Stack;
public class Stack5_Infix_to_Postfix{

    // Method to get precedence of an operator
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;  // Lowest precedence
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;  // Highest precedence
            default:
                return -1;
        }
    }
    // Method to convert infix expression to postfix expression
    public static String infixToPostfix(String expression) {
        // Stack to store operators and parentheses
        Stack<Character> stack = new Stack<>();

        // Resultant postfix expression
        StringBuilder result = new StringBuilder();

        // Iterate over each character in the infix expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is an operand (i.e., a letter or digit), add it to the result
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the character is '(', push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is ')', pop and append from the stack until '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();  // Remove '(' from the stack
            }
            // If the character is an operator
            else {
                // While the precedence of the operator at the top of the stack is higher or equal
                // to the precedence of the current operator, pop from the stack to the result
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);  // Push the current operator to the stack
            }
        }

        // Pop all the remaining operators from the stack to the result
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";  // Unbalanced parentheses
            }
            result.append(stack.pop());
        }

        // Return the resultant postfix expression
        return result.toString();
    }

    // Main method to test the infix to postfix conversion
    public static void main(String[] args) {
        String infixExpression = "A+(B*C-(D/E^F)*G)*H";  // Example infix expression
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
