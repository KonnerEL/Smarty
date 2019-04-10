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
public class Parenthesis {
    public static String insertBeforeFirstClosedParenthesis(String insertTo, String insert) {
        int index = insertTo.indexOf(")");
        String Aux = insertTo.substring(0, index) + "\n" + insert + insertTo.substring(index);
        return Aux;
    }           
}
