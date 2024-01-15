/**
 Postfix notation is an unambiguous way of writing an arithmetic expression without parentheses. It is defined so
 that if "(exp1) op (exp2)" is a normal fully parenthesized expression whose operation is op, the postfix version
 of this is "pexp1 pexp2, op", where pexp1, is the postfix version of exp1, and pexp2, is the postfix version of exp2.
 The postfix version of a single number or variable is just that number or variable. So, for example, the postfix
 version of "((5 + 2) * (8 - 3)) /4" is "5 2 + 8 3 - * 4 /". Describe a nonrecursive way of evaluating an expression
 in postfix notation.
 */

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {

    public static int evaluatePostfix(String postfixExpression) {
        Stack<Integer> operandStack = new Stack<>();
        String[] tokens = postfixExpression.split("\\s+"); // Split the postfix expression into tokens

        for (String token : tokens) {
            if (isOperand(token)) {
                operandStack.push(Integer.parseInt(token)); // If the token is an operand, push it onto the stack
            } else if (isOperator(token)) {
                // If the token is an operator, pop operands, perform the operation, and push the result back onto the stack
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();

                int result = performOperation(operand1, operand2, token);
                operandStack.push(result);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token); // Invalid token
            }
        }

        // The result should be the only element left on the stack
        if (operandStack.size() == 1) {
            return operandStack.pop();
        } else {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
    }

    private static boolean isOperand(String token) {
        // Check if the token is an integer
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"); // Check if the token is one of the supported operators
    }

    private static int performOperation(int operand1, int operand2, String operator) {
        // Perform the specified operation
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    // Method to convert an infix expression with parentheses to postfix notation
    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        // Iterate through each character in the infix expression
        for (char c : infixExpression.toCharArray()) {
            // If the character is a digit, append it to the postfix expression
            if (Character.isDigit(c)) {
                postfix.append(c).append(" ");
            }
            // If the character is '(', push it onto the operator stack
            else if (c == '(') {
                operatorStack.push(c);
            }
            // If the character is ')', pop operators from the stack until '(' is encountered
            else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                // Pop '(' from the stack
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            }
            // If the character is an operator, handle operator precedence
            else if (isOperator(String.valueOf(c))) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(c); // Push the current operator onto the stack
            }
        }

        // Pop any remaining operators from the stack and append to the postfix expression
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(" ");
        }

        return postfix.toString().trim(); // Return the final postfix expression as a string
    }

    // Method to determine the precedence of an operator
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; // Default for '('
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an infix expression
        System.out.print("Enter the infix expression: ");
        String infixExpression = scanner.nextLine();

        try {
            // Convert the infix expression to postfix notation
            String postfixExpression = infixToPostfix(infixExpression);
            System.out.println("Postfix Expression: " + postfixExpression);

            // Evaluate the postfix expression and print the result
            int result = evaluatePostfix(postfixExpression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // Handle and print any errors that may occur
        } finally {
            scanner.close(); // Close the scanner to prevent resource leaks
        }
    }
}
