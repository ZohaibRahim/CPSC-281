# CPSC-281
Data Structures

**Postfix Expression Evaluation & Infix-to-Postfix Conversion**

**Description:**
The Java program, `PostfixEvaluation`, provides a non-recursive approach for evaluating expressions in postfix notation. Postfix notation is a concise way of writing arithmetic expressions without parentheses, making it suitable for unambiguous representation and straightforward evaluation. The program includes functionalities to convert an infix expression with parentheses to postfix notation and then evaluate the resulting postfix expression.

**Key Features:**

1. **Postfix Evaluation:**
   - The program employs a `Stack` data structure to evaluate postfix expressions non-recursively.
   - It supports the standard arithmetic operators: `+, -, *, /`.
   - The evaluation is performed efficiently, ensuring the correct result of the expression.

2. **Infix to Postfix Conversion:**
   - The program includes a method (`infixToPostfix`) to convert infix expressions with parentheses to postfix notation.
   - It handles operator precedence and ensures the correct order of operations.

3. **Error Handling:**
   - The program provides robust error handling for invalid tokens, division by zero, unsupported operators, and other potential issues.
   - Exception messages are informative, aiding in debugging.

4. **User Interaction:**
   - The program prompts the user to input an infix expression.
   - It then displays the corresponding postfix expression and the result after evaluation.

**GitHub Repository:**
[Java Postfix Expression Evaluation & Infix to Postfix Conversion](https://github.com/ZohaibRahim/CPSC-281/tree/Postfix-Expression-Evaluation-%26-Infix-to-Postfix-Conversion)

**Usage:**
1. Clone the repository to your local machine.
2. Compile and run the `PostfixEvaluation.java` file.
3. Follow the prompt to enter an infix expression for evaluation.
4. View the generated postfix expression and the result of the evaluation.

Explore the provided Java program to gain insights into postfix expression evaluation and infix-to-postfix conversion. The repository includes the source code, detailed comments, and error-handling mechanisms for reference and understanding.
