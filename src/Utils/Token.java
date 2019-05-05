/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author KonnerEL
 */
public class Token {

    public static final int NUMBER = 0;
    public static final int OPERATOR = 1;
    public static final int LEFT_PARENTHESIS = 2;
    public static final int RIGHT_PARENTHESIS = 3;
    int precedence;
    String Symbol;
    Integer Type;

    public Token(String Symbol) {
        this.Symbol = Symbol;
        switch (Symbol) {
            case "+":
                Type = OPERATOR;
                precedence = 1;
                break;
            case "-":
                Type = OPERATOR;
                precedence = 1;
                break;
            case "*":
                Type = OPERATOR;
                precedence = 2;
                break;
            case "/":
                Type = OPERATOR;
                precedence = 2;
                break;
            case "(":
                Type = LEFT_PARENTHESIS;
                break;
            case ")":
                Type = RIGHT_PARENTHESIS;
                break;
            default:
                Type = NUMBER;
                break;
        }
    }

    public Token(Token FirstOperand, Token Operator, Token SecondOperand) {
        this.Symbol = "(" + Operator + " " + FirstOperand + " " + SecondOperand + ")";
    }

    public int getPrecedence() {
        return precedence;
    }

    public Integer getType() {
        return Type;
    }

    @Override
    public String toString() {
        return this.Symbol;
    }
}
