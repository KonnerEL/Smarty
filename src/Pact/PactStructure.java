/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pact;

import org.stringtemplate.v4.ST;

/**
 *
 * @author KonnerEL
 */
public class PactStructure {
    String KeySet;
    Integer Indentation;
    
    public PactStructure(String KeySet) {
        this.KeySet = KeySet;
        Indentation = 0;
    }
    
    public String Compile() {
        ST PS = new ST("(define-keyset '<KeySet> (read-keyset \"<KeySet>\"))"); 
        PS.add("KeySet", KeySet);
        return PS.render();
    }
    
}
