/**
 1) a) Write a program that takes as input a fully parenthesized infix arithmetic expression and
       converts it to a binary expression tree.
 */
package Q1;
import java.util.Scanner;
public class infixToBinaryTree {
    // Custom stack for TreeNodes
    private static class TreeNodeStack {
        private TreeNode[] stackArray;
        private int top;

        public TreeNodeStack(int capacity) {
            stackArray = new TreeNode[capacity];
            top = -1;
        }

        public void push(TreeNode node) {
            stackArray[++top] = node;
        }

        public TreeNode pop() {
            return stackArray[top--];
        }

        public TreeNode peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    // Custom stack for characters
    private static class CharStack {
        private char[] stackArray;
        private int top;

        public CharStack(int size) {
            stackArray = new char[size];
            top = -1;
        }

        public void push(char c) {
            stackArray[++top] = c;
        }

        public char pop() {
            return stackArray[top--];
        }

        public char peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    // Convert expression to binary expression tree with step by step output
    public static TreeNode convertToBinaryTree(String infixExpression) {
        CharStack operatorStack = new CharStack(infixExpression.length());
        TreeNodeStack operandStack = new TreeNodeStack(infixExpression.length());

        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                operandStack.push(new TreeNode(c));
                printStep(operandStack, operatorStack);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    buildSubtree(operatorStack.pop(), operandStack);
                    printStep(operandStack, operatorStack);
                }
                operatorStack.pop(); // Pop '('
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
                    buildSubtree(operatorStack.pop(), operandStack);
                    printStep(operandStack, operatorStack);
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            buildSubtree(operatorStack.pop(), operandStack);
            printStep(operandStack, operatorStack);
        }

        return operandStack.pop(); // Return the root of the binary expression tree
    }

    // Build subtree and push onto operand stack
    private static void buildSubtree(char operator, TreeNodeStack operandStack) {
        TreeNode right = operandStack.pop();
        TreeNode left = operandStack.pop();
        TreeNode operatorNode = new TreeNode(operator);

        operatorNode.left = left;
        operatorNode.right = right;

        operandStack.push(operatorNode);
    }

    // Check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Get precedence of an operator
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

    // Print the step by step representation
    private static void printStep(TreeNodeStack operandStack, CharStack operatorStack) {
        System.out.print("Operand Stack: ");
        printStack(operandStack);
        System.out.print("Operator Stack: ");
        printStack(operatorStack);
        System.out.println();
    }

    // Print the stack elements
    private static void printStack(TreeNodeStack stack) {
        for (int i = 0; i <= stack.top; i++) {
            System.out.print(stack.stackArray[i].value + " ");
        }
        System.out.println();
    }

    private static void printStack(CharStack stack) {
        for (int i = 0; i <= stack.top; i++) {
            System.out.print(stack.stackArray[i] + " ");
        }
        System.out.println();
    }

    // Print the binary expression tree using inorder traversal
    public static void printTreeInOrder(TreeNode root) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                System.out.print("(");
            }
            printTreeInOrder(root.left);
            System.out.print(root.value + " ");
            printTreeInOrder(root.right);
            if (root.left != null || root.right != null) {
                System.out.print(")");
            }
        }
    }

    public static void main(String[] args) {
        Scanner kdb = new Scanner(System.in);

        System.out.print("Enter the fully parenthesized expression: ");
        String infixExpression = kdb.nextLine();

        try {
            // Convert the infix expression to a binary expression tree
            TreeNode root = convertToBinaryTree(infixExpression);

            // Print the entire binary expression tree
            System.out.print("Binary Expression Tree: ");
            printTreeInOrder(root);
            System.out.println(); // Move to the next line

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            kdb.close();
        }
    }
}

/*
OUTPUT 1:
Enter the fully parenthesized infix expression: (a+b)*(a-b)
Operand Stack: a
Operator Stack: (

Operand Stack: a b
Operator Stack: ( +

Operand Stack: +
Operator Stack: (

Operand Stack: + a
Operator Stack: * (

Operand Stack: + a b
Operator Stack: * ( -

Operand Stack: + -
Operator Stack: * (

Operand Stack: *
Operator Stack:

Binary Expression Tree: ((a + b )* (a - b ))



OUTPUT 2:
Enter the fully parenthesized infix expression: a-b
Operand Stack: a
Operator Stack:

Operand Stack: a b
Operator Stack: -

Operand Stack: -
Operator Stack:

Binary Expression Tree: (a - b )



OUTPUT 3:
Enter the fully parenthesized infix expression: (a+b)*(a+c)*(b+c)
Operand Stack: a
Operator Stack: (

Operand Stack: a b
Operator Stack: ( +

Operand Stack: +
Operator Stack: (

Operand Stack: + a
Operator Stack: * (

Operand Stack: + a c
Operator Stack: * ( +

Operand Stack: + +
Operator Stack: * (

Operand Stack: *
Operator Stack:

Operand Stack: * b
Operator Stack: * (

Operand Stack: * b c
Operator Stack: * ( +

Operand Stack: * +
Operator Stack: * (

Operand Stack: *
Operator Stack:

Binary Expression Tree: (((a + b )* (a + c ))* (b + c ))
 */