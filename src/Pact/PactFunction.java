/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pact;

import java.util.List;
import org.stringtemplate.v4.ST;

/**
 *
 * @author KonnerEL
 */
public class PactFunction {
    String Name;
    List<String>Arguments;
    String Body;
    Integer Indentation;

    public PactFunction(String Name, List<String>Arguments, String Body) {
        this.Name = Name;
        this.Arguments = Arguments;
        this.Body = Body;
        Indentation = 1;
    }
    
    public String Compile() {
        String space = "";
        for (int i = 1; i <= Indentation; i++) {
            space = space + " ";
        }
        ST Function = new ST(space + "(defun <Name> (<Arguments>)\n"
                          +  "<Body>\n"
                          + space + ")"
        );
        String Args = "";
        for (String Param: Arguments) {
            Args = Args + Param + " ";
        }
        Args = Args.substring(0, Args.lastIndexOf(" "));
        Function.add("Name", Name);
        Function.add("Arguments", Args);
        Function.add("Body", Body);
        return Function.render();
    }   
    
    
}
