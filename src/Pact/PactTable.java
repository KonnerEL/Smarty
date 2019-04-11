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
public class PactTable {
    String Name;
    Integer Indentation;
    
    public PactTable(String Name) {
        this.Name = Name;
        Indentation = 1;
    }
    
    public String Compile() {
        String space = "";
        for (int i = 1; i <= Indentation; i++) {
            space = space + " ";
        }
        ST Table = new ST(space + "(deftable <Name>_table:{<Name>})");
        Table.add("Name", Name);
        return Table.render();
    }
}
