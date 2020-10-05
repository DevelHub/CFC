package main.calculator;

import main.model.Node;

public class SimpleCalculator {

    public static float calculateNode(Node tree) {
        Node left = tree.getLeft();
        Node right = tree.getRight();
        String str = String.valueOf(tree.getKey());

        switch(str) {
            case "+": return calculateNode(left) + calculateNode(right);
            case "-": return calculateNode(left) - calculateNode(right);
            case "*": return calculateNode(left) * calculateNode(right);
            case "/": return calculateNode(left) / calculateNode(right);
            default: return Float.parseFloat(str);
        }
    }
}
