package expressiontree;

import java.util.Stack;

class Node {

    String value;
    Node left;
    Node right;

    public Node(String item) {
        value = item;
        left = null;
        right = null;
    }
}

public class ExpressionTree {

    public static Node buildTree(String postfix) {
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char symbol = postfix.charAt(i);

            if (Character.isDigit(symbol)) {
                stack.push(new Node(String.valueOf(symbol)));
            } else {
                Node right = stack.pop();
                Node left = stack.pop();

                Node operator = new Node(String.valueOf(symbol));
                operator.left = left;
                operator.right = right;

                stack.push(operator);
            }
        }

        return stack.pop();
    }

    public static int evaluate(Node root) {
        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.value);
        }

        int leftValue = evaluate(root.left);
        int rightValue = evaluate(root.right);

        switch (root.value) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                return leftValue / rightValue;
            default:
                throw new IllegalArgumentException("Unknown operator: " + root.value);
        }
    }

    public static void printInfix(Node root) {
        if (root.left == null && root.right == null) {
            System.out.print(root.value);
            return;
        }

        System.out.print("(");
        printInfix(root.left);
        System.out.print(" " + root.value + " ");
        printInfix(root.right);
        System.out.print(")");
    }

    public static void main(String[] args) {
        String postfix = "53+82-*";

        Node root = buildTree(postfix);

        System.out.print("Infix: ");
        printInfix(root);

        System.out.println("\nResult: " + evaluate(root));
    }
}
