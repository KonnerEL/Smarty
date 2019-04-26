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
