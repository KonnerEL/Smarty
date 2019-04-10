/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pact;

import org.stringtemplate.v4.*;
/**
 *
 * @author KonnerEL
 */
public class PactModule {
    String Name;
    String KeySet;
    Integer Indentation;

    public PactModule(String Name, String KeySet) {
        this.Name = Name;
        this.KeySet = KeySet;
        Indentation = 0;
    }
    
    public String Compile(String Schema, String Table, String Functions) {
        ST module = new ST("(module <Name> '<KeySet>\n"
                        + "   <Schema>\n"
                        + "   <Table>\n"
                        + "   <Functions>\n "
                        + ")");
        module.add("Name", Name);
        module.add("KeySet", KeySet);
        module.add("Schema", Schema);
        module.add("Table", Table);
        module.add("Functions", Functions);
        return module.render();
    }
}
