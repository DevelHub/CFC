package main.parser;

import java.util.Stack;

import static main.utility.GeneralUtility.operatorPower;

public class GeneralParser {

    public static Stack<String> postFixParse(String input) {
        Stack<String> mainStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
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
