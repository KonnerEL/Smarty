/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pact;

import java.util.LinkedHashMap;
import org.stringtemplate.v4.*;
/**
 *
 * @author KonnerEL
 */
public class PactSchema {
    String Name;
    LinkedHashMap<String,String>Attributes;
    Integer Indentation;

    public PactSchema(String Name, LinkedHashMap Attributes) {
        this.Name = Name;
        this.Attributes = Attributes;
        Indentation = 1;
    }
    
    
    public String Compile() {
        String space = "";
        for (int i = 0; i <= Indentation; i++) {
            space = space + " ";
        }
        ST Schema = new ST(space + "(defschema <Name>\n"
                         + space + "  " + "<Attributes>"
                         + space + ")"
        );
        String Atts = "";
        for (String AttrName: Attributes.keySet()) {
            String AttrType = Attributes.get(AttrName);
            Atts = Atts + AttrName + ":" + AttrType + "\n";
        }
        Schema.add("Name", Name);
        Schema.add("Attributes", Atts);
        return Schema.render();
    }
}
