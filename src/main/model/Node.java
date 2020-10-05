package main.model;

import java.util.Stack;

import static main.utility.GeneralUtility.isOperator;

public class Node {

    private Object key;

    private Node left;

    private Node right;

    private static boolean isRightChild = false;

    public Node(Stack<String> input) {
        this.key = input.pop();
        if(input.isEmpty())
            return;
        String tempRightNode = input.peek();
        if(isRightChild) {
            isRightChild = false;
            this.right = new Node(input.pop());
            this.left = new Node(input.pop());
            return;
        }
        else if(isOperator(tempRightNode)) {
            isRightChild = true;
            this.right = new Node(input);
        }
        else {
            this.right = new Node(input.pop());
        }
        this.left = new Node(input);
    }

    private Node(String input) {
        this.key = input;
    }

    public Object getKey() {
        return key;
    }

    private void setKey(Object key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    private void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    private void setRight(Node right) {
        this.right = right;
    }
}
