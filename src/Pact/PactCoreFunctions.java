/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pact;

import java.util.HashMap;
import org.stringtemplate.v4.ST;

/**
 *
 * @author KonnerEL
 */
public class PactCoreFunctions {    
    public static ST chooseCoreFunction(int i) {
        ST Function = null;
        switch(i) {
            case 1:
                Function = new ST("(format <Text> <Variables>)");
                break;
            case 2:
                Function = new ST("(with-read <FirstArgument> <Second Argument>)");
                break;
            case 3:
                Function = new ST("(update <FirstArgument> <Second Argument>)");
                break;
            case 4:
                Function = new ST("(insert <FirstArgument> <Second Argument>)");
                break;
        }
        return Function;
    } 
}
