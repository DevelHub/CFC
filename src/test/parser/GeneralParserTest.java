package test.parser;

import main.model.Node;

import java.util.Stack;

import static main.calculator.SimpleCalculator.calculateNode;
import static main.parser.GeneralParser.postFixParse;

public class GeneralParserTest {

    public static void main(String[] args) {
        String[] inputs = new String[] {
                "8+6/3-2",
                "7+4*5-2+0",
                "1+4*3+1",
                "4*5+7",
                "4*5-2/2+7"
        };

        for(String input: inputs) {
            System.out.println("Input: " + input);

            Stack<String> mainStack = postFixParse(input);

            Node binaryTree = new Node(mainStack);
            float output = calculateNode(binaryTree);

            System.out.println("Output: " + output);
            System.out.println();
        }
    }
}
