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
public class Precondition {
    String left_Side;
    String Operator;
    String right_Side;
    String Exception;

    public Precondition(String left_Side, String Operator, String right_Side, String Exception) {
        this.left_Side = left_Side;
        this.Operator = Operator;
        this.right_Side = right_Side;
        this.Exception = Exception;
    }

    public String getLeft_Side() {
        return left_Side;
    }

    public String getOperator() {
        return Operator;
    }

    public String getRight_Side() {
        return right_Side;
    }

    public String getException() {
        return Exception;
    }
    
    
    @Override
    public String toString() {
        return left_Side + " " + Operator + " " + right_Side;
    }
}
