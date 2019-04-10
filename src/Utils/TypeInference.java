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
public class TypeInference {
    public static String CheckType(String value) {
        String Boolean = "(true | false)";
        String Integer = "[0-9]+";
        String Decimal = "^\\d*\\.\\d*$";
        
        if (value.matches(Boolean)) return "isBoolean";
        if (value.matches(Integer)) return "isInteger";
        if (value.matches(Decimal)) return "isDecimal";
            
        return "isString";
    }     
}
