/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.List;

/**
 *
 * @author KonnerEL
 */
public class Entity {
    String Name;
    List<String>EntityAttributes;
    List<String>EntityTypes;

    public Entity(String Name, List<String> EntityAttributes, List<String> EntityTypes) {
        this.Name = Name;
        this.EntityAttributes = EntityAttributes;
        this.EntityTypes = EntityTypes;
    }

    public String getName() {
        return Name;
    }

    public List<String> getEntityAttributes() {
        return EntityAttributes;
    }

    public List<String> getEntityTypes() {
        return EntityTypes;
    }
    
    
    
}
