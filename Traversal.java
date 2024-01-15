/**
 b) Write tree traversal algorithms to output the expression in prefix, infix and postfix format.
 */
package Q1;
class Traversal {

    // Print the binary expression tree using inorder traversal
    public static void printTreeInfix(TreeNode root) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                System.out.print("(");
            }
            printTreeInfix(root.left);
            System.out.print(root.value + " ");
            printTreeInfix(root.right);
            if (root.left != null || root.right != null) {
                System.out.print(")");
            }
        }
    }

    // Print the binary expression tree using preorder traversal
    public static void printTreePrefix(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            printTreePrefix(root.left);
            printTreePrefix(root.right);
        }
    }

    // Print the binary expression tree using postorder traversal
    public static void printTreePostfix(TreeNode root) {
        if (root != null) {
            printTreePostfix(root.left);
            printTreePostfix(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static void main(String[] args) {
        //Test 1
        System.out.println("TEST 1");
        TreeNode root1 = infixToBinaryTree.convertToBinaryTree("a+b");

        // Print the expression tree in infix, prefix, and postfix formats
        System.out.print("Prefix Expression: ");
        printTreePrefix(root1);
        System.out.println(); // Move to the next line

        System.out.print("Infix Expression: ");
        printTreeInfix(root1);
        System.out.println();

        System.out.print("Postfix Expression: ");
        printTreePostfix(root1);
        System.out.println("\n\n"); // Move to the next to next to next line

        //Test2
        System.out.println("TEST 2");
        TreeNode root2 = infixToBinaryTree.convertToBinaryTree("(a+b)*(a-b)");

        System.out.print("Prefix Expression: ");
        printTreePrefix(root2);
        System.out.println();

        System.out.print("Infix Expression: ");
        printTreeInfix(root2);
        System.out.println();

        System.out.print("Postfix Expression: ");
        printTreePostfix(root2);
        System.out.println("\n\n");

        //Test3
        System.out.println("TEST 3");
        TreeNode root3 = infixToBinaryTree.convertToBinaryTree("(a+b)*(a+c)/(b+c)");

        System.out.print("Prefix Expression: ");
        printTreePrefix(root3);
        System.out.println();

        System.out.print("Infix Expression: ");
        printTreeInfix(root3);
        System.out.println();

        System.out.print("Postfix Expression: ");
        printTreePostfix(root3);
    }
}
/*
OUTPUT:
TEST 1
Operand Stack: a
Operator Stack:

Operand Stack: a b
Operator Stack: +

Operand Stack: +
Operator Stack:

Prefix Expression: + a b
Infix Expression: (a + b )
Postfix Expression: a b +


TEST 2
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

Prefix Expression: * + a b - a b
Infix Expression: ((a + b )* (a - b ))
Postfix Expression: a b + a b - *


TEST 3
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
Operator Stack: / (

Operand Stack: * b c
Operator Stack: / ( +

Operand Stack: * +
Operator Stack: / (

Operand Stack: /
Operator Stack:

Prefix Expression: / * + a b + a c + b c
Infix Expression: (((a + b )* (a + c ))/ (b + c ))
Postfix Expression: a b + a c + * b c + /


 */