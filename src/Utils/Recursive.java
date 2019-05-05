/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author KonnerEL
 */
public class Recursive {
      public static String convertToLispExpression(String string, int i, String output) {  
        if (i == string.length()) return output;
        else {
            int index = getIndexOfOperator(string, i);
            int index2 = 0;
            if (i == 0) {
                if (string.substring(index, index + 2).equals(">=") || string.substring(index, index + 2).equals("!=") || string.substring(index, index + 2).equals("<=")) {
                    index2 = getIndexOfOperator(string, index + 2);
                    output = output + "(" + string.substring(index, index + 2) + " " + string.substring(i, index) + " " + string.substring(index + 2, index2) + ")";
                    
                } else {
                    index2 = getIndexOfOperator(string, index + 1);
                    output = output + "(" + string.substring(index, index + 1) + " " + string.substring(i, index) + " " + string.substring(index + 1, index2) + ")";
                }   
            } else {
                if (string.substring(index, index + 2).equals(">=") || string.substring(index, index + 2).equals("!=") || string.substring(index, index + 2).equals("<=")) {
                    index2 = getIndexOfOperator(string, index + 2);
                    output = "(" + string.substring(index, index + 2) + " " + output + " " +  string.substring(index + 2, index2) + ")";
                } else {
                    index2 = getIndexOfOperator(string, index + 1);
                    output = "(" + string.substring(index, index + 1) + " " + output + " " +  string.substring(index + 1, index2) + ")";
                }
            }
            return convertToLispExpression(string, index2, output);
        }
    }
    
    public static String convertToLispExpression(String expression) {
        String[] splittedExpression = expression.split(String.format("((?<=%1$s)|(?=%1$s))", "\\+|\\-|\\*|\\/"));
        ArrayList<Token>tokens = new ArrayList();
        for (String part:splittedExpression) {
            tokens.add(new Token(part));
        }

        Stack<Token>Values = new Stack();
        Stack<Token>Operators = new Stack<>();
        String LispExpression = "";
        Boolean error = false;
        for (Token token : tokens) {
            if (token.getType() == Token.NUMBER) {
                Values.push(token);
            } else if (token.getType() == Token.OPERATOR) {
                if (Operators.isEmpty() || (token.getPrecedence() > Operators.peek().getPrecedence())) {
                    Operators.push(token);
                } else {
                    while (!Operators.isEmpty() && token.getPrecedence() <= Operators.peek().getPrecedence()) {
                        if (Values.size() >= 2) {
                            Token SecondOperand = Values.pop();
                            Token FirstOperand = Values.pop();
                            Token Operator = Operators.pop();
                            Values.add(new Token(FirstOperand, Operator, SecondOperand));
                            LispExpression = "(" + Operator + " " + FirstOperand + " " + SecondOperand + ")";
                        } else {
                            error = true;
                            break;
                        }
                    }
                    Operators.push(token);
                }

            } else if (token.Type == Token.LEFT_PARENTHESIS) {
                Operators.push(token);
            } else if (token.getType() == Token.RIGHT_PARENTHESIS) {
                while (!Operators.isEmpty() && Operators.peek().getType() == Token.OPERATOR) {
                    if (Values.size() >= 2) {
                        Token SecondOperand = Values.pop();
                        Token FirstOperand = Values.pop();
                        Token Operator = Operators.pop();
                        Values.add(new Token(FirstOperand, Operator, SecondOperand));
                        LispExpression = "(" + Operator + " " + FirstOperand + " " + SecondOperand + ")";
                    } else {
                        error = true;
                        break;
                    }
                }
                if (!Operators.isEmpty() && Operators.peek().getType() == Token.LEFT_PARENTHESIS) {
                    Operators.pop();
                } else {
                    System.out.println("Error: unbalanced parenthesis.");
                    error = true;
                }
            }
        }
        while (!Operators.isEmpty() && Operators.peek().getType() == Token.OPERATOR) {
            if (Values.size() >= 2) {
                Token SecondOperand = Values.pop();
                Token FirstOperand = Values.pop();
                Token Operator = Operators.pop();
                Values.add(new Token(FirstOperand, Operator, SecondOperand));
                LispExpression = "(" + Operator + " " + FirstOperand + " " + SecondOperand + ")";
            }
        }
        return LispExpression;
    } 
      
    public static Integer getIndexOfOperator(String string, int i) {
        for (int j = i; j < string.length(); j++) {
            String currentChar = string.substring(j, j + 1);
            if (currentChar.equals("+") || currentChar.equals("-") || currentChar.equals("*") || currentChar.equals("/")) {
                return j;
            }
            if (j < string.length() - 1) {
                if (string.substring(j, j + 2).equals(">=") || string.substring(j, j + 2).equals("!=") || string.substring(j, j + 2).equals("<=")) {
                    return j;
                }
            }
            
            if (currentChar.equals(">") || currentChar.equals("=") || currentChar.equals("<")) {
                return j;
            }
        }
        return string.length();
    }
}
