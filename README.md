# Java Expression Tree

A small Java assignment that builds a binary expression tree from postfix notation, prints the expression in infix form, and evaluates it.

## Assignment objectives

- Construct an expression tree from a postfix expression.
- Display the expression with parentheses in infix form.
- Evaluate the expression tree and show the result.

## Concepts used

- **Binary tree:** operands are leaf nodes; operators are parent nodes with left and right children.
- **Stack:** used while constructing the tree from left to right.
- **Postfix notation:** operands appear before the operator that combines them.
- **Tree traversals:** recursive left–root–right traversal prints infix notation; recursive evaluation processes the left and right subtrees before applying the operator.

## Main methods

- `buildTree(String postfix)` scans the input one character at a time. It pushes digit nodes onto a stack; for an operator, it pops the right and then left nodes, joins them beneath an operator node, and pushes that node back. It returns the final tree root.
- `evaluate(Node root)` recursively evaluates the tree. The implemented operators are `+`, `-`, `*`, and `/`; division uses Java integer division.
- `printInfix(Node root)` recursively prints each operator expression in parentheses, with spaces around the operator.

## Run in NetBeans

1. Open the project in NetBeans, or create a Java project and add `expressiontree/ExpressionTree.java` as a source file.
2. Keep the source in the `expressiontree` package.
3. Run `ExpressionTree` (the class includes a `main` method). The sample postfix expression is set in `main`.

## Sample

Postfix input: `53+82-*`

Expected output:

```text
Infix: ((5 + 3) * (8 - 2))
Result: 48
```

## Requirements and project structure

- Java Development Kit (JDK); no external libraries are used. The program imports `java.util.Stack` from the Java standard library.
- The repository contains `README.md` and `expressiontree/ExpressionTree.java`. The Java file defines the `expressiontree` package, the `Node` class, and the `ExpressionTree` class with its `main` method.
