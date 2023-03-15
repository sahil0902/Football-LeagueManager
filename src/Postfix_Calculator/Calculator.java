package Postfix_Calculator;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {

    public void Prefixcalc() {
        // Creates a new stack
        Stack<String> stack = new Stack<>();
        try {
            // Asks the user to enter a prefix expression
            System.out.println("Enter your prefix expression:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            // Splits the input string into an array of values
            String[] Val = input.split(" ");
            stack.push(Arrays.toString(Val));
            System.out.printf("%-20s%-20s%-6s\n", "Method", "Return Value", "Stack Contents ( ... --> top)");
            stack.pop();

            // Iterates over the values
            for (String sign : Val) {
                // Checks if the value is an operator
                if (sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) {
                    // Pushes the operator onto the stack
                    stack.push((sign) +"");
                    System.out.printf("%-20s%-20s%-6s\n", "push(" + sign + ")", sign,stack);
                    // Pops the operator off the stack
                    stack.pop();
                    System.out.printf("%-20s%-20s%-6s\n", "pop()", sign,  stack );
                    double num1 = 0;
                    double num2 = 0;
                    // If the stack is not empty, pop num1 and num2
                    if (!stack.isEmpty()) {
                        num1 = Double.parseDouble(stack.pop());
                        System.out.printf("%-20s%-20s%-6s\n", "pop()", num1, stack);
                    }
                    if (!stack.isEmpty()) {
                        num2 = Double.parseDouble(stack.pop());
                        System.out.printf("%-20s%-20s%-6s\n", "pop()", num2, stack);
                    }
                    // Performs the calculation and store the result in a variable
                    double result=0;
                    switch (sign) {
                        case "+" -> result = num1 + num2;
                        case "-" -> result = num2 - num1;
                        case "*" -> result = num1 * num2;
                        case "/" -> result = num2 / num1;
                        default -> System.out.println("Error");
                    }
//                    // Pushes the result back onto the stack
                    stack.push(Double.toString(result));
//                    // Prints the output
                   System.out.printf("%-20s%-20s%-6s\n", "push(" + result + ")", result, "(" + stack + ")");
                } else {
                    double operand = Double.parseDouble(sign);
                    // If the value is not an operator, pushes it onto the stack
                    stack.push(operand+"");
                    System.out.printf("%-20s%-20s%-6s\n", "push(" + operand + ")", operand,stack);
                }
            }
        } catch (NumberFormatException e) {
            // If the user input is invalid, prints an error message
            System.out.println("Invalid input. Please enter a valid prefix expression.");
        }
    }

    public static void main(String[] args) {
        Calculator prefix = new Calculator();
        prefix.Prefixcalc();
    }
}
