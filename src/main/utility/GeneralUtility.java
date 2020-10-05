package main.utility;

public class GeneralUtility {

    public static int operatorPower(String input) {
        switch (input) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            default: return 0;
        }
    }

    public static boolean isStringDigit(String input) {
//        might just need to check first character...below for now
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(!Character.isDigit(ch))
                return false;
        }
        return true;
    }

    public static boolean isOperator(String operator) {
        switch (operator) {
            case "+": case "-":
            case "*": case "/": return true;
            default: return false;
        }
    }
}
