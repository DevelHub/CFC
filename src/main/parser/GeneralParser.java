package main.parser;

import java.util.Stack;

import static main.utility.GeneralUtility.operatorPower;

public class GeneralParser {

    public static Stack<String> postFixParse(String input) {
        Stack<String> mainStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for(char ch: input.toCharArray()) {
            String str = String.valueOf(ch);
            if(Character.isDigit(ch)) {
                mainStack.push(str);
            }
            else {
                if(operatorStack.isEmpty()) {
                    operatorStack.push(str);
                }
                else {
                    if(operatorPower(str) > operatorPower(operatorStack.peek())) {
                        operatorStack.push(str);
                    }
                    else if(operatorPower(str) < operatorPower(operatorStack.peek())) {
                        while(!operatorStack.isEmpty())
                            mainStack.push(operatorStack.pop());
                        operatorStack.push(str);
                    }
                    else {
                        if(!operatorStack.isEmpty()) {
                            mainStack.push(operatorStack.pop());
                            operatorStack.push(str);
                        }
                        else {
                            mainStack.push(str);
                        }
                    }
                }
            }
        }

        while(!operatorStack.isEmpty())
            mainStack.push(operatorStack.pop());

        System.out.println("Stack: " + mainStack);
        return mainStack;
    }
}
