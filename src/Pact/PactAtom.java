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
public class PactAtom {
    String FirstArgument;
    String SecondArgument;
    ST Atom;
    Integer Indentation;
    
    public PactAtom(String FirstArgument, String SecondArgument) {
        this.FirstArgument = FirstArgument;
        this.SecondArgument = SecondArgument;
        Atom = null;
    }
    
    public void setIndentation(Integer Indentation) {
        this.Indentation = Indentation + 1;
    }
    
    public Integer getIndentation() {
        return Indentation;
    }
    
    public void chooseCoreFunction(int i) {
        ST Function = null;
        String space = "";
        for (int j = 1; j < Indentation; j++) {
            space = space + " ";
        }
        switch(i) {
            case 1:
                Atom = new ST(space + "(format <FirstArgument> <SecondArgument>)");
                break;
            case 2:
                Atom = new ST(space + "(with-read <FirstArgument> <SecondArgument>"
                            + ")");
                break;
            case 3:
                Atom = new ST(space + "(update <FirstArgument> <SecondArgument>)");
                break;
            case 4:
                Atom = new ST(space + "(insert <FirstArgument> <SecondArgument>)");
                break;
            case 5:
                Atom = new ST(space + "(enforce <FirstArgument> <SecondArgument>)");
        }
    } 
    
    public String Compile() {
        Atom.add("FirstArgument", FirstArgument);
        Atom.add("SecondArgument", SecondArgument);
        return Atom.render();
    }
}
