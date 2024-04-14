/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parmat.entitylib;

/**
 *
 * @author matthieuparmentier
 */
public class Property {
    public enum PropertyDataType {
        UUID,
        INTEGER,
        STRING,
        DECIMAL,
        ENUM
    };
    
    private String name;
    private PropertyDataType dataType;
    private Attribute attribute;
    private Boolean required;
    private String valueRangeRegexp;
    private String[] notes;
    
    public final void setName(String name) throws Exception {
        if (name != null && name.length() > 0 && name.length() <= 50)
            this.name = name;
        else
            throw new Exception("Invalid name.");
    }
    
    public final void setDataType(PropertyDataType dataType) throws Exception {
        if (dataType == null)
            throw new Exception("Invalid dataType.");
        this.dataType = dataType;
    }
    
    public final void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
    
    public final void setRequired(Boolean required) {
        this.required = required;
    }
    
    public final void setValueRangeRegexp(String regexp) {
        //@TODO: add further checks on regexp.
        this.valueRangeRegexp = regexp;
    }
    
    public final void setNotes(String[] notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public PropertyDataType getDataType() {
        return dataType;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public Boolean getRequired() {
        return required;
    }

    public String getValueRangeRegexp() {
        return valueRangeRegexp;
    }

    public String[] getNotes() {
        return notes;
    }
    
    public Property(String name, PropertyDataType dataType) throws Exception {
        this.setName(name);
        this.setDataType(dataType);
        this.setRequired(false);
        this.setAttribute(null);
        this.setNotes(null);
        this.setValueRangeRegexp(null);
    }
    
    public static double testProperty() throws Exception {
        int score = 0;
        
        var prop = new Property("test", Property.PropertyDataType.INTEGER);
        assert prop.getName().equals("test");
        assert prop.getDataType() == PropertyDataType.INTEGER;
        score++;
        
        prop.setName("dona");
        assert prop.getName().equals("dona");
        score++;
        
        prop.setRequired(true);
        assert prop.getRequired() == true;
        score++;
        
        prop.setNotes(new String[5]);
        assert prop.getNotes().length == 5;
        score++;
        
        prop.setValueRangeRegexp(".+");
        assert prop.getValueRangeRegexp().equals(".+");
        score++;
        
        prop.setAttribute(new Attribute(Attribute.AttributeType.PRIMARY_KEY));
        assert prop.getAttribute() != null;
        assert prop.getAttribute().getType() == Attribute.AttributeType.PRIMARY_KEY;
        score++;
        
        prop.setDataType(PropertyDataType.DECIMAL);
        assert prop.getDataType() == PropertyDataType.DECIMAL;
        score++;
        
        return score / 7 * 100;
    }
}
