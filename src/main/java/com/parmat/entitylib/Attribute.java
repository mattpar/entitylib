/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parmat.entitylib;

/**
 *
 * @author matthieuparmentier
 */
public class Attribute {
    public enum AttributeType {
        PRIMARY_KEY,
        FOREIGN_KEY
    };
    
    private AttributeType type;
    private Property referencedEntityPK;
    
    public final void setType(AttributeType type) {
        this.type = type;
    }
    
    public AttributeType getType() {
        return this.type;
    }
    
    public final void setReferencedEntityPK(Property entityPK) throws Exception {
        if (entityPK == null && this.type == AttributeType.FOREIGN_KEY)
            throw new Exception("Can not set a reference for a non-foreign key property.");
        //@TODO: Further checks on input property
        this.referencedEntityPK = entityPK;
    }
    
    public Property getReferencedEntityPK() {
        return this.referencedEntityPK;
    }
    
    public Attribute(AttributeType type) throws Exception {
        this.setType(type);
        this.setReferencedEntityPK(null);
    }
    
    public Attribute(AttributeType type, Property referencedEntityPK) throws Exception {
        this.setType(type);
        this.setReferencedEntityPK(referencedEntityPK);
    }
    
    public static double testAttibuteClass() throws Exception {
        int score = 0;
        
        Attribute attr = new Attribute(AttributeType.PRIMARY_KEY);
        assert attr != null;
        score++;
        
        try {
            Attribute attr_1 = new Attribute(AttributeType.FOREIGN_KEY);
        } catch (Exception ex) {
            score++;
            System.out.println("OK: Expected exception thrown: " + ex.getMessage());
        }
        
        Attribute attr_2 = new Attribute(AttributeType.PRIMARY_KEY, null);
        assert attr_2 != null;
        score++;
        
        try {
            Attribute attr_3 = new Attribute(AttributeType.FOREIGN_KEY, null);
        } catch (Exception ex) {
            score++;
            System.out.println("OK: Expected exception thrown: " + ex.getMessage());
        }
        //@TODO: Add instances with entities.
        
        return (score / 4.0) * 100;
    }
}
